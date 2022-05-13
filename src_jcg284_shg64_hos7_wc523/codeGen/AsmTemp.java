package src_jcg284_shg64_hos7_wc523.codeGen;

import java.util.HashSet;
import java.util.Set;
import polyglot.util.Pair;

public class AsmTemp extends AsmOp {
  public String name;
  
  public AsmTemp(String n) {
    name = n;
  }

  public String toString() {
    return name;
  }

  public AsmTemp copyReplace(Set<Pair<AsmTemp, AsmTemp>> equivalences) {
    AsmTemp result = this;
    boolean changed = true;
    while(changed) {
      changed = false;
      for (Pair<AsmTemp, AsmTemp> p : equivalences) {
        if (p.part1().equals(result)) {
          result = p.part2();
          changed = true;
        }
      }
    }
    return result;
  }

  public Set<AsmTemp> getUse() {
    Set<AsmTemp> use = new HashSet<>();
    use.add(this);
    return use;
  }

  public Set<AsmTemp> getDef() {
    Set<AsmTemp> def = new HashSet<>();
    def.add(this);
    return def;
  }

  public boolean equals(Object o) {
    return (o instanceof AsmTemp) && ((AsmTemp)o).name.equals(name);
  }

  public int hashCode(){
    return name.hashCode();
  }

}