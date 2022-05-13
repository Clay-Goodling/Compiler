package src_jcg284_shg64_hos7_wc523.codeGen;

import java.util.*;
import polyglot.util.Pair;

public class AsmMove extends Assembly {
  public AsmOp dest;
  public AsmOp src;

  public AsmMove(AsmOp dest, AsmOp src) {
    this.dest = dest;
    this.src = src;
  }

  public String toString() {
    return String.format("\tmov %s, %s\n", dest, src);
  }

 public AsmMove copyReplace(Set<Pair<AsmTemp, AsmTemp>> equivalences) {
    return new AsmMove(dest.copyReplace(equivalences), src.copyReplace(equivalences));
  }

  public Set<AsmTemp> getUse() {
    Set<AsmTemp> use = new HashSet<>(src.getUse());
    if (!(dest instanceof AsmTemp)) {
      use.addAll(dest.getUse());
    }
    return use;
  }

  public Set<AsmTemp> getDef() {
    Set<AsmTemp> def = new HashSet<>();
    if ((dest instanceof AsmTemp)) {
      def.add((AsmTemp)dest);
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

    AsmOp concreteDest = dest;
    AsmOp concreteSrc = src;
    
    if (dest instanceof AsmTemp) {
      AsmTemp destTemp = (AsmTemp)dest;
      if (!tempSet.containsKey(destTemp)) {
          tempSet.put(destTemp, tempSet.size());
      }
      if (tempSet.get(destTemp) >= tempRegisters.length) {
        concreteDest = spillRegisters[0];
      } else {
        concreteDest = tempRegisters[tempSet.get(destTemp)];
      }
    } else if (dest instanceof AsmMem){
      AsmMem destMem = (AsmMem)dest;
      AsmOp concreteBase = destMem.base;
      AsmOp concreteIndex = destMem.index;
      if (destMem.base instanceof AsmTemp) {
        AsmTemp baseTemp = (AsmTemp)destMem.base;
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
      if (destMem.index instanceof AsmTemp) {
        AsmTemp indexTemp = (AsmTemp)destMem.index;
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
      concreteDest = new AsmMem(
        concreteBase, concreteIndex, destMem.scale, destMem.displacement
      );
    }
    
    if (src instanceof AsmTemp) {
      AsmTemp srcTemp = (AsmTemp)src;
      if (!tempSet.containsKey(srcTemp)) {
        tempSet.put(srcTemp, tempSet.size());
      }
      if (tempSet.get(srcTemp) >= tempRegisters.length) {
        body.add(new AsmMove(spillRegisters[2], new AsmMem(
          new AsmRegister("rbp"),
          new AsmConst(-tempSet.get(srcTemp) * 8 - offset)
        )));
        concreteSrc = spillRegisters[2];
      } else {
        concreteSrc = tempRegisters[tempSet.get(srcTemp)];
      }
    } else if (src instanceof AsmMem){
      AsmMem srcMem = (AsmMem)src;
      AsmOp concreteBase = srcMem.base;
      AsmOp concreteIndex = srcMem.index;
      if (srcMem.base instanceof AsmTemp) {
        AsmTemp baseTemp = (AsmTemp)srcMem.base;
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
      if (srcMem.index instanceof AsmTemp) {
        AsmTemp indexTemp = (AsmTemp)srcMem.index;
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
      concreteSrc = new AsmMem(
        concreteBase, concreteIndex, srcMem.scale, srcMem.displacement
      );
    }
    
    body.add(new AsmMove(concreteDest, concreteSrc));

    if (dest instanceof AsmTemp) {
      AsmTemp destTemp = (AsmTemp)dest;
      if (tempSet.get(destTemp) >= tempRegisters.length) {
        body.add(new AsmMove(new AsmMem(
          new AsmRegister("rbp"),
          new AsmConst(-tempSet.get(destTemp) * 8 - offset)
        ), spillRegisters[0]));
      }
    }
    
    return body;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof AsmMove)) return false;
    AsmMove e = (AsmMove)o;
    return dest.equals(e.dest) && src.equals(e.src);
  }
}
