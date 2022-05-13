package src_jcg284_shg64_hos7_wc523.codeGen;

import edu.cornell.cs.cs4120.xic.ir.IRBinOp;
import edu.cornell.cs.cs4120.xic.ir.IRBinOp.OpType;

import java.util.ArrayList;

import edu.cornell.cs.cs4120.xic.ir.*;

//s in {1,2,4,8}
//ADD(MUL(e1, m), ADD(e2, const))
public class TileAMEPAEC extends Tile {

  /**
   * @{inheritDoc}
   */
  public boolean matchIRTree(IRNode node, CodeGenerator cg) {
    score = 4;
    try {
      IRBinOp bnode = (IRBinOp) node;
      if (bnode.opType() != OpType.ADD) return false;

      IRBinOp lnode = (IRBinOp) bnode.left();
      IRBinOp rnode = (IRBinOp) bnode.right();

      IRBinOp anode, mnode;
      if (rnode.opType() == OpType.ADD || 
        (rnode.opType() == OpType.SUB && rnode.right() instanceof IRConst)) {
          anode = rnode;
          if (lnode.opType() == OpType.MUL) {
            mnode = lnode;
          } else {
            mnode = new IRBinOp(IRBinOp.OpType.MUL, lnode, new IRConst(1));
            score--;
          }
      } else if (lnode.opType() == OpType.MUL) {
        anode = new IRBinOp(OpType.ADD, rnode, new IRConst(0));
        score--;
        mnode = lnode;
      } else if (lnode.opType() == OpType.ADD || 
        (lnode.opType() == OpType.SUB && lnode.right() instanceof IRConst)) {
          anode = lnode;
          if (rnode.opType() == OpType.MUL) {
            mnode = rnode;
          } else {
            mnode = new IRBinOp(IRBinOp.OpType.MUL, rnode, new IRConst(1));
            score--;
          }
      } else if (rnode.opType() == OpType.MUL) {
        anode = new IRBinOp(OpType.ADD, lnode, new IRConst(0));
        score--;
        mnode = rnode;
      } else return false;
      
      IRExpr e1;
      IRConst m;
      if (mnode.right() instanceof IRConst &&
        isPower(((IRConst)mnode.right()).value())) {
          e1 = mnode.left();
          m = (IRConst)mnode.right();
      } else if (mnode.left() instanceof IRConst &&
        isPower(((IRConst)mnode.left()).value())) {
          e1 = mnode.right();
          m = (IRConst)mnode.left();
      } else return false;
      
      IRExpr e2;
      IRConst c;
      if (anode.right() instanceof IRConst) {
        e2 = anode.left();
        c = (IRConst)anode.right();
      } else {
        e2 = anode.right();
        c = (IRConst)anode.left();
      } 
      
      asm = new ArrayList<>();

      asm.addAll(((IRExpr_c)e1).asm);
      asm.addAll(((IRExpr_c)e2).asm);

      AsmOp t1 = cg.tempGen();
      AsmOp t2 = cg.tempGen();
      
      if (e1.getAsmTarget() instanceof AsmMem) {
        t1 = cg.tempGen();
        asm.add(new AsmMove(t1, e1.getAsmTarget()));
      } else t1 = e1.getAsmTarget();
      if (e2.getAsmTarget() instanceof AsmMem){
        asm.add(new AsmMove(t2, e2.getAsmTarget()));
      } else t2 = e2.getAsmTarget();

      if(anode.opType() == OpType.SUB) {
        if (anode.left() == e2) c = new IRConst(-c.value());
        else return false;
      }

      asmTarget = new AsmMem(
        t2,
        t1,
        new AsmConst(m.value()),
        new AsmConst(c.value())
      );
      return true;
    } catch (ClassCastException e) {
      return false;
    }
  }
}
