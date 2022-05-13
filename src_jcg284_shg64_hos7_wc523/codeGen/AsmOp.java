package src_jcg284_shg64_hos7_wc523.codeGen;

import java.util.Set;
import polyglot.util.Pair;

public abstract class AsmOp extends Assembly {
  public AsmOp copyReplace(Set<Pair<AsmTemp, AsmTemp>> equivalences) {
    return this;
  }
}