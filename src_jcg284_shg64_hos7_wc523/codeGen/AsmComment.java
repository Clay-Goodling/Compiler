package src_jcg284_shg64_hos7_wc523.codeGen;

public class AsmComment extends Assembly {
  public String comment;
  
  public AsmComment(String comment) {
    this.comment = comment;
  }

  public String toString() {
    return String.format("\t# %s\n", comment);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof AsmComment)) return false;
    AsmComment e = (AsmComment)o;
    return comment.equals(e.comment);
  }
}