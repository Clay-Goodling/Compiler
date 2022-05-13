package src_jcg284_shg64_hos7_wc523.codeGen;

public class AsmRegister extends AsmOp {
  String name;

  public AsmRegister(String n) {
    name = n;
  }

  public String toString() {
    return name;
  }

  public boolean equals(Object o) {
    return (o instanceof AsmRegister) && ((AsmRegister)o).name.equals(name);
  }

  public int hashCode(){
    return name.hashCode();
  }
}