package src_jcg284_shg64_hos7_wc523.optimizations;

import java.util.*;
import edu.cornell.cs.cs4120.xic.ir.*;
import src_jcg284_shg64_hos7_wc523.cfg.*;

public class AvailExpr {
  static String mode = "stmt";
  static long tempState = 0;
  // private boolean direction = true;

  /**
   * Generate a fresh temp.
   * @return a fresh temp.
   */
  static IRTemp tempGen() {
    String result = "_availexpr_temp" + tempState++;
    tempState++;
    return new IRTemp(result);
  }
  
  public static IRFuncDecl optimize(IRFuncDecl f) {
    IRCFG<AvailExprData> cfg = new IRCFG<AvailExprData>(f, mode, AvailExprData.getTop());
    worklist(cfg);
      // Go through node list
      // If you find a node which has a subexpression that was defined earlier,
      // generate a temp t
      // for each node where it was defined
      //   iterate down list of statements until one has expr available
      //   if none give up
      //   insert t = expr above statement
      //   replace expr with t in every statement in defNode.code after t = ...
      // replace expr with t in every statement in usedNode.code 
    for (IRCFGNode<AvailExprData> node : cfg.nodes){
      AvailExprData in = AvailExprData.getTop();
      for (IRCFGNode<AvailExprData> pred : node.predecessors) {
        in = in.meet(pred.data);
      }
      PriorityQueue<IRExpr> exprs = new PriorityQueue<>(new CompareIRExpr());
      exprs.addAll(in.exprs().keySet());
      while (!exprs.isEmpty()){        
        IRExpr sub = exprs.poll();
        boolean mode = false; // false for scanning, true for replacing
        IRTemp t = tempGen();
        for (int i = 0; i < node.code.size(); i++) {
          IRStmt stmt = node.code.get(i);
          if (!mode) {
            // scanning
            if (stmt.availableExpressions().contains(sub)) {
              // set t = expr in all source nodes
              for (IRCFGNode<AvailExprData> source : in.exprs().get(sub)) {
                IRMove mov = new IRMove(t, sub);
                source.code.add(0, mov);
                for (int j = 1; j < source.code.size(); j++) {
                  source.code.set(j, source.code.get(j).replaceSubexprs(sub, t));
                }
              }
              mode = true;
            }
          } 
          if (mode) {
            // replacing
            node.code.set(i, stmt.replaceSubexprs(sub, t));
          }
        }
      }
    }
    return cfg.toIR();
  }

  public static void worklist(IRCFG<AvailExprData> cfg) {
    // Maps an IRNode's id to its equations for in and out
    // The first element of the ArrayList corresponds to in; the second to out
    HashSet<IRCFGNode<AvailExprData>> workset = new HashSet<>(cfg.nodes);
    LinkedList<IRCFGNode<AvailExprData>> worklist = new LinkedList<>(cfg.nodes);

    // While worklist is not empty
    while (!worklist.isEmpty()) {
      IRCFGNode<AvailExprData> node = worklist.pop();
      workset.remove(node);
      
      // update in[n]
      AvailExprData in = AvailExprData.getTop();
      for (IRCFGNode<AvailExprData> pred : node.predecessors) {
        in = in.meet(pred.data);
      }

      // update out[n]
      boolean changed = transferFunction(node, in);

      // if out[n] is different, add the successors of n to the worklist
      if (changed) {
        for (IRCFGNode<AvailExprData> n : node.successors) {
          if (workset.add(n)) worklist.add(n);
        }
      }
    }
  }

  public static boolean transferFunction(IRCFGNode<AvailExprData> node, AvailExprData in) {
    Map<IRExpr, Set<IRCFGNode<AvailExprData>>> out = new HashMap<>(in.exprs());
    Set<IRCFGNode<AvailExprData>> source = new HashSet<>();
    source.add(node);
    for (IRExpr expr : node.code.get(0).availableExpressions()){
      if (!out.containsKey(expr)) out.put(expr, source);
    }
    try {
      IRMove mov = (IRMove)node.code.get(0);
      IRTemp x = (IRTemp)mov.target();
      Set<IRExpr> kill = new HashSet<>();
      for (IRExpr expr : out.keySet()) {
        if (containsTemp(expr, x)) kill.add(expr);
      }
      for (IRExpr expr : kill) out.remove(expr);
    } catch (ClassCastException e) {
      // not a move into a temp
    }
    AvailExprData oldData = node.data;
    node.data = new AvailExprData(out);
    return !oldData.equals(node.data);
  }
  
  public static boolean containsTemp(IRExpr e, IRTemp t){
    if (e instanceof IRBinOp){
      IRBinOp binop = (IRBinOp)e;
      return containsTemp(binop.left(), t) || containsTemp(binop.right(), t);
    } 
    if (e instanceof IRMem){
      IRMem mem = (IRMem)e;
      return containsTemp(mem.expr(), t);
    }
    if (e instanceof IRTemp) return t.equals((IRTemp)e);
    return false;
  }
}

class CompareIRExpr implements Comparator<IRExpr> {
  public int compare(IRExpr e1, IRExpr e2){
    return e2.size() - e1.size();
  }
}