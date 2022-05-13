package src_jcg284_shg64_hos7_wc523.codeGen;

import java.util.*;
import polyglot.util.Pair;

public class AsmLea extends Assembly {
  AsmOp target;
  AsmMem address;

  public AsmLea(AsmOp target, AsmMem address) {
      this.target = target;
      this.address = address;
  }

  public String toString() {
    return String.format("\tlea %s, %s\n", target, address);
  }

  public AsmLea copyReplace(Set<Pair<AsmTemp, AsmTemp>> equivalences) {
    return new AsmLea(target.copyReplace(equivalences), address.copyReplace(equivalences));
  }

  public Set<AsmTemp> getUse() {
    Set<AsmTemp> use = new HashSet<>(address.getUse());
    if (!(target instanceof AsmTemp)) {
      use.addAll(target.getUse());
    }
    return use;
  }

  public Set<AsmTemp> getDef() {
    Set<AsmTemp> def = new HashSet<>();
    if ((target instanceof AsmTemp)) {
      def.add((AsmTemp)target);
    }
    return def;
  }

  /**
   * {@inheritDoc}
   */
  public List<Assembly> toConcrete(Map<AsmTemp, Integer> tempSet, AsmRegister[] spillRegisters, int offset){
    AsmRegister[] tempRegisters = {};
    return this.toConcrete(tempSet, tempRegisters, spillRegisters, offset);
  }

  /**
  * {@inheritDoc}
  */
  public List<Assembly> toConcrete(Map<AsmTemp, Integer> tempSet, AsmRegister[] tempRegisters, AsmRegister[] spillRegisters, int offset) {
    ArrayList<Assembly> body = new ArrayList<>();

    AsmOp concreteTarget = target;
    AsmMem concreteAddress = address;
    
    if (target instanceof AsmTemp) {
      AsmTemp targetTemp = (AsmTemp)target;
      if (!tempSet.containsKey(targetTemp)) {
        tempSet.put(targetTemp, tempSet.size());
      }
      if (tempSet.get(targetTemp) >= tempRegisters.length) {
        concreteTarget = spillRegisters[0];
      } else {
        concreteTarget = tempRegisters[tempSet.get(targetTemp)];
      }
    }
    
    AsmOp concreteBase = address.base;
    AsmOp concreteIndex = address.index;
    if (address.base instanceof AsmTemp) {
      AsmTemp baseTemp = (AsmTemp)address.base;
      if (!tempSet.containsKey(baseTemp)) {
        tempSet.put(baseTemp, tempSet.size());
      }
      if (tempSet.get(baseTemp) >= tempRegisters.length) {
        body.add(new AsmMove(spillRegisters[1], new AsmMem(
          new AsmRegister("rbp"),
          new AsmConst(-tempSet.get(baseTemp) * 8 - offset)
        )));
        concreteBase = spillRegisters[1];
      } else {
        concreteBase = tempRegisters[tempSet.get(baseTemp)];
      }
    }
    if (address.index instanceof AsmTemp) {
      AsmTemp indexTemp = (AsmTemp)address.index;
      if (!tempSet.containsKey(indexTemp)) {
        tempSet.put(indexTemp, tempSet.size());
      }
      if (tempSet.get(indexTemp) >= tempRegisters.length) {
        body.add(new AsmMove(spillRegisters[2], new AsmMem(
        new AsmRegister("rbp"),
          new AsmConst(-tempSet.get(indexTemp) * 8 - offset)
        )));
        concreteIndex = spillRegisters[2];
      } else {
        concreteIndex = tempRegisters[tempSet.get(indexTemp)];
      }
    }
    concreteAddress = new AsmMem(
      concreteBase, concreteIndex, address.scale, address.displacement
    );
    
    body.add(new AsmLea(concreteTarget, concreteAddress));

    if (target instanceof AsmTemp) {
      AsmTemp targetTemp = (AsmTemp)target;
      if (tempSet.get(targetTemp) >= tempRegisters.length) {
        body.add(new AsmMove(new AsmMem(
          new AsmRegister("rbp"),
          new AsmConst(-tempSet.get(targetTemp) * 8 - offset)
        ), spillRegisters[0]));
      }
    }
    
    return body;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof AsmLea)) return false;
    AsmLea e = (AsmLea)o;
    return target.equals(e.target) && address.equals(e.address);
  }
}
