package src_jcg284_shg64_hos7_wc523.optimizations;

import java.util.*;
import edu.cornell.cs.cs4120.xic.ir.*;
import src_jcg284_shg64_hos7_wc523.cfg.IRCFGNode;

public class AvailExprData implements Data<AvailExprData> {
  private static AvailExprData top = new AvailExprData();
  private Map<IRExpr, Set<IRCFGNode<AvailExprData>>> exprs;

  public AvailExprData() {
    this(new HashMap<>());
  }

  public AvailExprData(Map<IRExpr, Set<IRCFGNode<AvailExprData>>> exprs) {
    this.exprs = exprs;
  }

  public static AvailExprData getTop(){
    return top;
  }

  public Map<IRExpr, Set<IRCFGNode<AvailExprData>>> exprs() {
    return exprs;
  }

  public AvailExprData meet(AvailExprData target) {
    if (this == top && target == top) return top;
    if (this == top) return target;
    if (target == top) return this;

    Map<IRExpr, Set<IRCFGNode<AvailExprData>>> intersect = new HashMap<>();
    for (IRExpr expr : exprs.keySet()) {
      if (target.exprs.keySet().contains(expr)) {
        Set<IRCFGNode<AvailExprData>> sources = new HashSet<>(exprs.get(expr));
        sources.addAll(target.exprs.get(expr));
        intersect.put(expr, sources);
      }
    }
    return new AvailExprData(intersect);
  }

  public String toString(){
    return exprs.keySet().toString();
  }

  public boolean equals(Object o){
    if (!(o instanceof AvailExprData)) return false;    
    AvailExprData target = (AvailExprData)o;
    if (this == top) return target == top;
    if (target == top) return false;
    else return exprs.equals(target.exprs());
  }

}