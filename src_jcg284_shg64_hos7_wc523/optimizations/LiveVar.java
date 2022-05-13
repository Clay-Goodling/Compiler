package src_jcg284_shg64_hos7_wc523.optimizations;

import java.util.*;

import polyglot.util.Pair;
import src_jcg284_shg64_hos7_wc523.cfg.*;
import src_jcg284_shg64_hos7_wc523.codeGen.*;

public class LiveVar {

  public static Pair<List<Assembly>, Boolean> deadCodeElimination(List<Assembly> asm) {
    boolean changed = true;
    boolean everChanged = false;
    do {
      AsmCFG<LiveVarData> cfg = analyze(asm);
      List<Assembly> result = new ArrayList<>();
      changed = false;
      for (AsmCFGNode<LiveVarData> node : cfg.nodes) {
        if (node.code instanceof AsmMove && ((AsmMove)node.code).dest instanceof AsmTemp) {
          AsmMove mov = (AsmMove)node.code;
          LiveVarData out = LiveVarData.getTop();
          for (AsmCFGNode<LiveVarData> succ : node.successors) {
            out = out.meet(succ.data);
          }
          if (!mov.src.equals(mov.dest) && out.vars.contains(mov.dest)) {
            result.add(node.code);
          } else {
            changed = true;
            everChanged = true;
          }
        } else {
          result.add(node.code);
        }
        asm = result;
      }
    } while (changed);
    return new Pair<>(asm, everChanged);
  }

  public static AsmCFG<LiveVarData> analyze(List<Assembly> asm) {
    //Maps an IRNode's id to its equations for in and out
    //The first element of the ArrayList corresponds to in; the second to out
    AsmCFG<LiveVarData> cfg = new AsmCFG<LiveVarData>(asm, LiveVarData.getTop());

    HashSet<AsmCFGNode<LiveVarData>> workset = new HashSet<>(cfg.nodes);
    LinkedList<AsmCFGNode<LiveVarData>> worklist = new LinkedList<>(cfg.nodes);

    // While worklist is not empty
    while (!worklist.isEmpty()) {
      AsmCFGNode<LiveVarData> node = worklist.pop();
      workset.remove(node);
      
      // update out[n]
      LiveVarData out = LiveVarData.getTop();
      for (AsmCFGNode<LiveVarData> succ : node.successors) {
        out = out.meet(succ.data);
      }

      // update in[n]
      boolean changed = transferFunction(node, out);

      // if in[n] is different, add the predecessors of n to the worklist
      if (changed) {
        for (AsmCFGNode<LiveVarData> n : node.predecessors) {
          if (workset.add(n)) worklist.add(n);
        }
      }
    }

    return cfg;
  }

  //in = use u (out - def)
  public static boolean transferFunction(AsmCFGNode<LiveVarData> node, LiveVarData out){
    Set<AsmTemp> use = node.code.getUse();
    Set<AsmTemp> def = node.code.getDef();
    LiveVarData newdata = out.minus(new LiveVarData(def)).meet(new LiveVarData(use));
    if (!newdata.equals(node.data)) {
      node.data = newdata;
      return true;
    }
    return false;
  }
}