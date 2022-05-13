package src_jcg284_shg64_hos7_wc523.codeGen;

import java.util.*;
import polyglot.util.Pair;

public class AsmUnop extends Assembly {
  
  static enum OpType {
    DIV,
    NEG,
    INC,
    DEC,
    MUL
  }

  public OpType op;
  public AsmOp dest;

  public AsmUnop(OpType op, AsmOp dest) {
    this.op = op;
    this.dest = dest;
  }

  public String toString() {
    String op_text = "";
    switch (op) {
      case DIV:
        op_text = "idiv";
        break;
      case NEG:
        op_text = "neg";
        break;
      case INC:
        op_text = "inc";
        break;
      case DEC:
        op_text = "dec";
        break;
      case MUL:
        op_text = "imul";
    }

    return String.format("\t%s %s\n", op_text, dest);
  }

  public AsmUnop copyReplace(Set<Pair<AsmTemp, AsmTemp>> equivalences) {
    return new AsmUnop(this.op, dest.copyReplace(equivalences));
  }

  public Set<AsmTemp> getUse() {
    return dest.getUse();
  }

  public Set<AsmTemp> getDef() {
    return dest.getDef();
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
    AsmOp concreteDest = dest;
    
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
    
    body.add(new AsmUnop(this.op, concreteDest));

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
  public boolean equals(Object o){
    if (o instanceof AsmUnop) {
      AsmUnop asm = (AsmUnop)o;
      return op == asm.op && dest.equals(asm.dest);
    }
    return false; 
  }
}