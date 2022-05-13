package src_jcg284_shg64_hos7_wc523.codeGen;

public class AsmJump extends Assembly {
  public String label;
  
  public AsmJump(String label) {
    this.label = label;
  }

  public String toString() {
    return String.format("\tjmp %s\n", label);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof AsmJump)) return false;
    AsmJump e = (AsmJump)o;
    return label.equals(e.label);
  }
}
