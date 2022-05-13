package src_jcg284_shg64_hos7_wc523.codeGen;

import java.util.*;
import polyglot.util.Pair;

public class AsmBinop extends Assembly {
  
  static enum OpType {
    ADD,
    SUB,
    MUL,
    AND,
    OR,
    XOR,
    LSHIFT,
    RSHIFT,
    ARSHIFT
  }

  public OpType op;
  public AsmOp src, dest;

  
  public AsmBinop(OpType op, AsmOp dest, AsmOp src) {
    this.op = op;
    this.src = src;
    this.dest = dest;
  }

  public String toString() {
    String op_text = "";
    switch (op) {
      case ADD:
        op_text = "add";
        break;
      case SUB:
        op_text = "sub";
        break;
      case MUL:
        op_text = "imul";
        break;
      case AND:
        op_text = "and";
        break;
      case OR:
        op_text = "or";
        break;
      case XOR:
        op_text = "xor";
        break;
      case LSHIFT:
        op_text = "shl";
        break;
      case RSHIFT:
        op_text = "shr";
        break;
      case ARSHIFT:
        op_text = "sar";
        break;
    }

    return String.format("\t%s %s, %s\n", op_text, dest, src);
  }

  public AsmBinop copyReplace(Set<Pair<AsmTemp, AsmTemp>> equivalences) {
    return new AsmBinop(this.op, dest.copyReplace(equivalences), src.copyReplace(equivalences));
  }

  public Set<AsmTemp> getUse() {
    Set<AsmTemp> use = new HashSet<>(src.getUse());
    use.addAll(dest.getUse());
    return use;
  }

  public Set<AsmTemp> getDef() {
    return dest.getDef();
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
        body.add(new AsmMove(spillRegisters[0], new AsmMem(
          new AsmRegister("rbp"),
          new AsmConst(-tempSet.get(destTemp) * 8 - offset)
        )));
        concreteDest = spillRegisters[0];
      } else {
        concreteDest = tempRegisters[tempSet.get(destTemp)];
      }
      //concreteDest = spillRegisters[0];
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
          concreteDest = tempRegisters[tempSet.get(baseTemp)];
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
      if (!tempSet.containsKey(srcTemp)) tempSet.put(srcTemp, tempSet.size());
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
    
    body.add(new AsmBinop(this.op, concreteDest, concreteSrc));

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
    if (!(o instanceof AsmBinop)) return false;
    AsmBinop e = (AsmBinop)o;
    return op.equals(e.op) && src.equals(e.src) && dest.equals(e.dest);
  }
}