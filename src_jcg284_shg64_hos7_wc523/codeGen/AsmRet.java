package src_jcg284_shg64_hos7_wc523.codeGen;

public class AsmRet extends Assembly {
  public AsmRet() {}

  public String toString() {
    return "\tret\n";
  }

  @Override
  public boolean equals(Object o){
    return (o instanceof AsmRet);
  }
}
