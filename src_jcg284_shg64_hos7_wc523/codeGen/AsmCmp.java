package src_jcg284_shg64_hos7_wc523.codeGen;

import java.util.*;
import polyglot.util.Pair;

public class AsmCmp extends Assembly {
  AsmOp e1, e2;

  public AsmCmp(AsmOp e1, AsmOp e2) {
    this.e1 = e1;
    this.e2 = e2;
    if (e1 == null || e2 == null) {
      throw new NullPointerException();
    }
  }

  public String toString() {
    return "\tcmp " + e1.toString() + ", " + e2.toString() + "\n";
  }

  public AsmCmp copyReplace(Set<Pair<AsmTemp, AsmTemp>> equivalences) {
    return new AsmCmp(e1.copyReplace(equivalences), e2.copyReplace(equivalences));
  }

  public Set<AsmTemp> getUse() {
    Set<AsmTemp> use = new HashSet<>(e1.getUse());
    use.addAll(e2.getUse());
    
    return use;
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

    AsmOp concreteE1 = e1;
    AsmOp concreteE2 = e2;
    
    if (e1 instanceof AsmTemp) {
      AsmTemp e1Temp = (AsmTemp)e1;
      if (!tempSet.containsKey(e1Temp)) tempSet.put(e1Temp, tempSet.size());
      if (tempSet.get(e1Temp) >= tempRegisters.length) {
        body.add(new AsmMove(spillRegisters[0], new AsmMem(
          new AsmRegister("rbp"),
          new AsmConst(-tempSet.get(e1Temp) * 8 - offset)
        )));
        concreteE1 = spillRegisters[0];
      } else {
        concreteE1 = tempRegisters[tempSet.get(e1Temp)];
      }
    } else if (e1 instanceof AsmMem){
      AsmMem e1Mem = (AsmMem)e1;
      AsmOp concreteBase = e1Mem.base;
      AsmOp concreteIndex = e1Mem.index;
      if (e1Mem.base instanceof AsmTemp) {
        AsmTemp baseTemp = (AsmTemp)e1Mem.base;
        if (!tempSet.containsKey(baseTemp)) {
          tempSet.put(baseTemp, tempSet.size());
        }
        if (tempSet.get(baseTemp) >= tempRegisters.length) {
          body.add(new AsmMove(spillRegisters[0], new AsmMem(
            new AsmRegister("rbp"),
            new AsmConst(-tempSet.get(baseTemp) * 8 - offset)
          )));
          concreteBase = spillRegisters[0];
        } else {
          concreteBase = tempRegisters[tempSet.get(baseTemp)];
        }
      }
      if (e1Mem.index instanceof AsmTemp) {
        AsmTemp indexTemp = (AsmTemp)e1Mem.index;
        if (!tempSet.containsKey(indexTemp)) {
          tempSet.put(indexTemp, tempSet.size());
        }
        if (tempSet.get(indexTemp) >= tempRegisters.length) {
          body.add(new AsmMove(spillRegisters[1], new AsmMem(
            new AsmRegister("rbp"),
            new AsmConst(-tempSet.get(indexTemp) * 8 - offset)
          )));
          concreteIndex = spillRegisters[1];
        } else {
          concreteIndex = tempRegisters[tempSet.get(indexTemp)];
        }
      }
      concreteE1 = new AsmMem(
        concreteBase, concreteIndex, e1Mem.scale, e1Mem.displacement
      );
    }
    
    if (e2 instanceof AsmTemp) {
      AsmTemp e2Temp = (AsmTemp)e2;
      if (!tempSet.containsKey(e2Temp)) tempSet.put(e2Temp, tempSet.size());
      if (tempSet.get(e2Temp) >= tempRegisters.length) {
        body.add(new AsmMove(spillRegisters[2], new AsmMem(
          new AsmRegister("rbp"),
          new AsmConst(-tempSet.get(e2Temp) * 8 - offset)
        )));
        concreteE2 = spillRegisters[2];
      } else {
        concreteE2 = tempRegisters[tempSet.get(e2Temp)];
      }
    } else if (e2 instanceof AsmMem){
      AsmMem e2Mem = (AsmMem)e2;
      AsmOp concreteBase = e2Mem.base;
      AsmOp concreteIndex = e2Mem.index;
      if (e2Mem.base instanceof AsmTemp) {
        AsmTemp baseTemp = (AsmTemp)e2Mem.base;
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
      if (e2Mem.index instanceof AsmTemp) {
        AsmTemp indexTemp = (AsmTemp)e2Mem.index;
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
      concreteE2 = new AsmMem(
        concreteBase, concreteIndex, e2Mem.scale, e2Mem.displacement
      );
    }
    
    body.add(new AsmCmp(concreteE1, concreteE2));

    return body;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof AsmCmp)) return false;
    AsmCmp e = (AsmCmp)o;
    return e1.equals(e.e1) && e2.equals(e.e2);
  }
}