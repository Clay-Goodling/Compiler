package src_jcg284_shg64_hos7_wc523.codeGen;

import java.util.*;
import polyglot.util.Pair;

public class AsmPop extends Assembly {
  AsmOp e;
  
  public AsmPop(AsmOp e) {
      this.e = e;
  }

  public String toString() {
    return String.format("\tpop %s\n", e);
  }

  public AsmPop copyReplace(Set<Pair<AsmTemp, AsmTemp>> equivalences) {
    return new AsmPop(e.copyReplace(equivalences));
  }

  public Set<AsmTemp> getUse() {
    return e.getUse();
  }

  /**
   * {@inheritDoc}
   */
  public List<Assembly> toConcrete(Map<AsmTemp, Integer> tempSet, AsmRegister[] spillRegisters, int offset) {
    AsmRegister[] tempRegisters = {};
    return this.toConcrete(tempSet, tempRegisters, spillRegisters, offset);
  }

  /**
  * {@inheritDoc}
  */
  public List<Assembly> toConcrete(Map<AsmTemp, Integer> tempSet, AsmRegister[] tempRegisters, AsmRegister[] spillRegisters, int offset) {
    ArrayList<Assembly> body = new ArrayList<>();
    AsmOp concreteE = e;
    
    if (e instanceof AsmTemp) {
      AsmTemp eTemp = (AsmTemp)e;
      if (!tempSet.containsKey(eTemp)) {
        tempSet.put(eTemp, tempSet.size());
      }
      if (tempSet.get(eTemp) >= tempRegisters.length) {
        concreteE = spillRegisters[0];
      } else {
        concreteE = tempRegisters[tempSet.get(eTemp)];
      }
    } else if (e instanceof AsmMem){
      AsmMem eMem = (AsmMem)e;
      AsmOp concreteBase = eMem.base;
      AsmOp concreteIndex = eMem.index;
      if (eMem.base instanceof AsmTemp) {
        AsmTemp baseTemp = (AsmTemp)eMem.base;
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
      if (eMem.index instanceof AsmTemp) {
        AsmTemp indexTemp = (AsmTemp)eMem.index;
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
      concreteE = new AsmMem(
        concreteBase, concreteIndex, eMem.scale, eMem.displacement
      );
    }

    body.add(new AsmPop(concreteE));

    if (e instanceof AsmTemp) {
      AsmTemp eTemp = (AsmTemp)e;
      if (tempSet.get(eTemp) >= tempRegisters.length) {
        body.add(new AsmMove(new AsmMem(
          new AsmRegister("rbp"),
          new AsmConst(-tempSet.get(eTemp) * 8 - offset)
        ), spillRegisters[0]));
      }
    }
    
    return body;
  }

  @Override
  public boolean equals(Object o){
    return (o instanceof AsmPop) && e.equals(((AsmPop)o).e);
  }
}
