package src_jcg284_shg64_hos7_wc523.codeGen;

public class AsmLabel extends Assembly {
  public String name;
  
  public AsmLabel(String name) {
    this.name = name;
  }

  public String toString() {
    return name + ":\n";
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof AsmLabel)) return false;
    AsmLabel e = (AsmLabel)o;
    return name.equals(e.name);
  }
}
