package src_jcg284_shg64_hos7_wc523.codeGen;

import java.util.HashSet;
import java.util.Set;
import polyglot.util.Pair;

public class AsmMem extends AsmOp {
  public AsmOp base;
  public AsmOp index;
  public AsmConst scale;
  public AsmConst displacement;

  public AsmMem(AsmOp base, AsmOp index, AsmConst scale, AsmConst disp) {
    this.base = base;
    this.index = index;
    this.scale = scale;
    this.displacement = disp;
  }

  public AsmMem(AsmOp base) {
    this.base = base;
  }

  public AsmMem(AsmOp base, AsmOp index) {
    this.base = base;
    this.index = index;
    this.scale = new AsmConst(1);
  }

  public AsmMem(AsmOp base, AsmOp index, AsmConst scale) {
    this.base = base; 
    this.index = index;
    this.scale = scale;
  }

  public AsmMem(AsmOp base, AsmConst displacement) {
    this.base = base;
    this.displacement = displacement;
  }

  public AsmMem copyReplace(Set<Pair<AsmTemp, AsmTemp>> equivalences) {
    return new AsmMem(
      (base == null ? null : base.copyReplace(equivalences)),
      (index == null ? null : index.copyReplace(equivalences)),
      scale, displacement
    );
  }
 
  public Set<AsmTemp> getUse() {
    Set<AsmTemp> use = new HashSet<>();
    if (base != null && base instanceof AsmTemp) use.add((AsmTemp)base);
    if (index != null && index instanceof AsmTemp) use.add((AsmTemp)index);
    return use;
  }

  public String toString() {
    String memString = "QWORD PTR [" + base;
    if (index != null) {
      if (scale.value < 0) {
        memString += String.format(" - %s * %d", index, -scale.value);
      } else memString += String.format(" + %s * %s", index, scale);
    }
    if (displacement != null){
      if(displacement.value < 0) {
        memString += String.format(" - %s", -displacement.value);
      } else memString += String.format(" + %s", displacement);
    }
    return memString + "]";
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof AsmMem)) return false;
    AsmMem target = (AsmMem)o;
    return (base == null ? target.base == null : base.equals(target.base)) &&
           (index == null ? target.index == null : index.equals(target.index)) &&
           (scale == null ? target.scale == null : scale.equals(target.scale)) && 
           (displacement == null ? target.displacement == null : displacement.equals(target.displacement));
  }
}
