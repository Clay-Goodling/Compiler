package src_jcg284_shg64_hos7_wc523.codeGen;

import java.util.*;

import polyglot.util.Pair;

public abstract class Assembly{
  public String opcode;
  
  public String toString() {
    return "";
  }

  /**
   * Converts abstract assembly to concrete assembly.
   * @param tempSet a map from temps to locations on the stack (as offsets)
   * @param spillregisters the regesters reserved for holding spilled temps
   * @param offset the distance between rbp and the first spilled temp
   * @return list of valid assembly instructions
   */
  public List<Assembly> toConcrete(Map<AsmTemp, Integer> tempSet, AsmRegister[] spillRegisters, int offset) {
    List<Assembly> l = new ArrayList<>();
    l.add(this);
    return l;
  }

  /**
   * Converts abstract assembly to concrete assembly.
   * @param tempSet a map from temps to tempRegisters or locations on the stack
   * @param tempRegisters the registers used in basic operations
   * @param spillregisters the regesters reserved for holding spilled temps
   * @param offset the distance between rbp and the first spilled temp
   * @return list of valid assembly instructions
   */
  public List<Assembly> toConcrete(Map<AsmTemp, Integer> tempSet, AsmRegister[] tempRegisters, AsmRegister[] spillRegisters, int offset) {
    List<Assembly> l = new ArrayList<>();
    l.add(this);
    return l;
  }

  public Assembly copyReplace(Set<Pair<AsmTemp, AsmTemp>> equivalences) {
    return this;
  }

  public Set<AsmTemp> getUse() {
    return new HashSet<>();
  }

  public Set<AsmTemp> getDef() {
    return new HashSet<>();
  }

  @Override
  public boolean equals(Object o) {
    return false;
  }
}