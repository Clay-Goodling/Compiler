package src_jcg284_shg64_hos7_wc523.codeGen;

public class AsmConst extends AsmOp {
  public long value;
  
  public AsmConst(long val) {
    value = val;
  }

  public String toString() {
    return "" + value;
  }

  public boolean equals(Object o) {
    if(!(o instanceof AsmConst)) return false;
    AsmConst e = (AsmConst)o;
    return value == e.value;
  }
}