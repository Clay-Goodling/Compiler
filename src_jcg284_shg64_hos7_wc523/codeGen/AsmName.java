package src_jcg284_shg64_hos7_wc523.codeGen;

public class AsmName extends AsmOp {
  String name;
  
  public AsmName(String name) {
    this.name = name;
  }

  public String toString() {
    return name;
  }
  
  @Override
  public boolean equals(Object o) {
    if (!(o instanceof AsmName)) return false;
    AsmName e = (AsmName)o;
    return name.equals(e.name);
  }
}
