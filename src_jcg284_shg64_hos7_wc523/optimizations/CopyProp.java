package src_jcg284_shg64_hos7_wc523.optimizations;

import java.util.*;

import polyglot.util.Pair;
import src_jcg284_shg64_hos7_wc523.cfg.*;
import src_jcg284_shg64_hos7_wc523.codeGen.*;

public class CopyProp {

  public static Pair<List<Assembly>, Boolean> optimize(List<Assembly> asm) {
    AsmCFG<CopyPropData> cfg = analyze(asm);
    boolean changed = false;
    for (AsmCFGNode<CopyPropData> node : cfg.nodes) {
      Assembly newCode = node.code.copyReplace(getIn(node).equalities);
      changed = changed || !newCode.equals(node.code);
      node.code = newCode;
    }
    return new Pair<>(cfg.toAsm(), changed);
  }

  private static CopyPropData getIn(AsmCFGNode<CopyPropData> node) {
    CopyPropData in = CopyPropData.getTop();
    if (node.predecessors.size() == 0) in = new CopyPropData(); // start node
    for (AsmCFGNode<CopyPropData> pred : node.predecessors) {
      in = in.meet(pred.data);
    }
    return in;
  }

  public static AsmCFG<CopyPropData> analyze(List<Assembly> asm) {
    //Maps an IRNode's id to its equations for in and out
    //The first element of the ArrayList corresponds to in; the second to out
    AsmCFG<CopyPropData> cfg = new AsmCFG<CopyPropData>(asm, CopyPropData.getTop());

    HashSet<AsmCFGNode<CopyPropData>> workset = new HashSet<>(cfg.nodes);
    LinkedList<AsmCFGNode<CopyPropData>> worklist = new LinkedList<>(cfg.nodes);

    // While worklist is not empty
    while (!worklist.isEmpty()) {
      AsmCFGNode<CopyPropData> node = worklist.pop();
      workset.remove(node);
      
      // update in[n]
      CopyPropData in = getIn(node);

      // update out[n]
      boolean changed = transferFunction(node, in);

      // if out[n] is different, add the successors of n to the worklist
      if (changed) {
        for (AsmCFGNode<CopyPropData> n : node.successors) {
          if (workset.add(n)) worklist.add(n);
        }
      }
    }

    return cfg;
  }

  //out = gen u (in - kill)
  public static boolean transferFunction(AsmCFGNode<CopyPropData> node, CopyPropData in){
    Set<Pair<AsmTemp, AsmTemp>> gen = new HashSet<>();
    if (node.code instanceof AsmMove) {
      AsmMove mov = (AsmMove)node.code;
      if (mov.dest instanceof AsmTemp && !mov.dest.equals(mov.src)) {
        // x = e
        AsmTemp dest = (AsmTemp)mov.dest;
        if (mov.src instanceof AsmTemp) {
          // x = y
          AsmTemp src = (AsmTemp)mov.src;
          // gen x = y
          gen.add(new Pair<AsmTemp, AsmTemp>(dest, src));
        }
        // kill x = z, z = x (for all z)
        Set<Pair<AsmTemp, AsmTemp>> kill = new HashSet<>();
        for (Pair<AsmTemp, AsmTemp> e : in.equalities) {
          if (e.part1().equals(dest) || e.part2().equals(dest)) {
            kill.add(e);
          }
        }
        in.equalities.removeAll(kill);
      }
    }
    
    CopyPropData newdata = in.join(new CopyPropData(gen));
    if (!newdata.equals(node.data)) {
      node.data = newdata;
      return true;
    }
    return false;
  }
}