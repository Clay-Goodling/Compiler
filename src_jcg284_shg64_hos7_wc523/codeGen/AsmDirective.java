package src_jcg284_shg64_hos7_wc523.codeGen;


public class AsmDirective extends Assembly{
  String name;
  String[] args;

  public AsmDirective(String name, String... args) {
    this.name = name;
    this.args = args;
  }

  public String toString() {
    return String.format("\t.%s %s\n", name, String.join(", ", args));
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof AsmDirective)) return false;
    AsmDirective e = (AsmDirective)o;
    return name.equals(e.name) && args.equals(e.args);
  }

}
