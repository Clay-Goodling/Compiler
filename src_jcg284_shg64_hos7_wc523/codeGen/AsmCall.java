package src_jcg284_shg64_hos7_wc523.codeGen;

public class AsmCall extends Assembly {
  AsmOp target;

  public AsmCall(AsmOp target) {
      this.target = target;
  }

  public String toString() {
    return String.format("\tcall %s\n", target);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof AsmCall)) return false;
    AsmCall e = (AsmCall)o;
    return target.equals(e.target);
  }
}
