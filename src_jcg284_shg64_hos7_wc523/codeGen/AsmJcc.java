package src_jcg284_shg64_hos7_wc523.codeGen;

public class AsmJcc extends Assembly {
  static enum conds {
    EQ, NE, LT, ULT, LEQ, GT, GEQ
  }

  public conds cond;
  public String target;

  public AsmJcc(AsmJcc.conds cond, String target) {
    this.target = target;
    this.cond = cond;
  }

  public String toString() {
    String s = "";
    switch (cond) {
    case EQ:
      s = "je";
      break;
    case NE:
      s = "jne";
      break;
    case LT:
      s = "jl";
      break;
    case ULT:
      s = "jb";
      break;
    case LEQ:
      s = "jle";
      break;
    case GT:
      s = "jg";
      break;
    case GEQ:
      s = "jge";
      break;
    }
    return String.format("\t%s %s\n", s, target);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof AsmJcc)) return false;
    AsmJcc e = (AsmJcc)o;
    return cond.equals(e.cond) && target.equals(e.target);
  }
}