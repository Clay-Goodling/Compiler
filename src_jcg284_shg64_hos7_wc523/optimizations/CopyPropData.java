package src_jcg284_shg64_hos7_wc523.optimizations;

import java.util.HashSet;
import java.util.Set;

import polyglot.util.Pair;
import src_jcg284_shg64_hos7_wc523.codeGen.AsmTemp;

public class CopyPropData implements Data<CopyPropData> {
  private static CopyPropData top = new CopyPropData();
  
  public Set<Pair<AsmTemp, AsmTemp>> equalities;

  public CopyPropData() {
    this(new HashSet<>());
  }

  public CopyPropData(Set<Pair<AsmTemp, AsmTemp>> equalities) {
    this.equalities = equalities;
  }

  public static CopyPropData getTop(){
    return top;
  }

  public CopyPropData meet(CopyPropData target) {
    if (this == top && target == top) return top;
    if (this == top) return target;
    if (target == top) return this;

    Set<Pair<AsmTemp, AsmTemp>> intersect = new HashSet<>();
    for (Pair<AsmTemp, AsmTemp> e : equalities) {
      if (target.equalities.contains(e)) intersect.add(e);
    }
    return new CopyPropData(intersect);
  }

  public CopyPropData join(CopyPropData target) {
    if (this == top || target == top) return top;

    Set<Pair<AsmTemp, AsmTemp>> union = new HashSet<>(equalities);
    union.addAll(target.equalities);
    return new CopyPropData(union);
  }

  public boolean equals(Object o) {
    return o instanceof CopyPropData && equalities.equals(((CopyPropData)o).equalities);
  }

  public String toString() {
    String s = "{ ";
    for (Pair<AsmTemp, AsmTemp> e : equalities) {
      s += e.toString() + " ";
    }
    return s += "}";
  }
}
