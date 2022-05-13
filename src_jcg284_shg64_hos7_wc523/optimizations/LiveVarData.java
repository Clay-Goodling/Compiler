package src_jcg284_shg64_hos7_wc523.optimizations;

import java.util.HashSet;
import java.util.Set;

import src_jcg284_shg64_hos7_wc523.codeGen.*;

public class LiveVarData implements Data<LiveVarData> {
  public Set<AsmTemp> vars;

  public LiveVarData() {
    this(new HashSet<>());
  }

  public LiveVarData(Set<AsmTemp> vars) {
    this.vars = vars;
  }

  public static LiveVarData getTop(){
    return new LiveVarData();
  }

  public LiveVarData meet(LiveVarData target) {
    HashSet<AsmTemp> union = new HashSet<>(vars);
    union.addAll(target.vars);
    return new LiveVarData(union);
  }

  public LiveVarData minus(LiveVarData subtrahend) {
    HashSet<AsmTemp> difference = new HashSet<>(vars);
    difference.removeAll(subtrahend.vars);
    return new LiveVarData(difference);
  }

  public boolean equals(Object o) {
    if (!(o instanceof LiveVarData)) return false;
    LiveVarData target = (LiveVarData)o;
    return this.vars.equals(target.vars);
  }

  public String toString() {
    return vars.toString();
  }
}
