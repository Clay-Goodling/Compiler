package src_jcg284_shg64_hos7_wc523.codeGen;

import edu.cornell.cs.cs4120.xic.ir.IRBinOp;
import edu.cornell.cs.cs4120.xic.ir.IRBinOp.OpType;
import edu.cornell.cs.cs4120.xic.ir.*;

import java.util.*;

//ADD(ADD(MUL(e1, m), const), e2))
public class TileAAMEPCE extends Tile{

  /**
   * @{inheritDoc}
   */
  public boolean matchIRTree(IRNode node, CodeGenerator cg){
    IRConst c;
    IRBinOp anode;
    IRExpr e1;
    IRBinOp mnode;
    IRExpr e2;
    IRConst m;

    score = 4;
    try{
      IRBinOp bnode = (IRBinOp)node;
      if (bnode.opType() != OpType.ADD) return false;

      if (bnode.left() instanceof IRBinOp &&
         (((IRBinOp)bnode.left()).opType() == OpType.ADD || 
         (((IRBinOp)bnode.left()).opType() == OpType.SUB && 
         ((IRBinOp)bnode.left()).right() instanceof IRConst))) {
          anode = (IRBinOp) bnode.left();
          e2 = bnode.right();
      } else if (bnode.right() instanceof IRBinOp &&
        (((IRBinOp)bnode.right()).opType() == OpType.ADD || 
        (((IRBinOp)bnode.right()).opType() == OpType.SUB && 
        ((IRBinOp)bnode.right()).right() instanceof IRConst))) {
          anode = (IRBinOp) bnode.right();
          e2 = bnode.left();
      } else return false;
      
      if (anode.left() instanceof IRBinOp &&
        (((IRBinOp)anode.left()).opType() == OpType.MUL)){
          mnode = (IRBinOp) anode.left();
          c = (IRConst) anode.right();
      } else if (anode.right() instanceof IRBinOp &&
        (((IRBinOp)anode.right()).opType() == OpType.MUL)){
          mnode = (IRBinOp) anode.right();
          c = (IRConst) anode.left();
      } else if (anode.left() instanceof IRConst) {
        c = (IRConst)anode.left();
        mnode = new IRBinOp(IRBinOp.OpType.MUL, anode.right(), new IRConst(1));
        score--;
      } else if (anode.right() instanceof IRConst) {
        c = (IRConst)anode.right();
        mnode = new IRBinOp(IRBinOp.OpType.MUL, anode.left(), new IRConst(1));
        score --;
      } else return false;
      
      if (mnode.right() instanceof IRConst){
        e1 = mnode.left();
        m = (IRConst) mnode.right();
      } else {
        e1 = mnode.right();
        m = (IRConst) mnode.left();
      }

      if (!isPower(m.value())) return false;

      asm = new ArrayList<>();

      asm.addAll(((IRExpr_c)e1).asm);
      asm.addAll(((IRExpr_c)e2).asm);

      AsmOp t1;
      AsmOp t2;
      
      if (e1.getAsmTarget() instanceof AsmMem) {
        t1 = cg.tempGen();
        asm.add(new AsmMove(t1, e1.getAsmTarget()));
      } else t1 = e1.getAsmTarget();
      if (e2.getAsmTarget() instanceof AsmMem){
        t2 = cg.tempGen();
        asm.add(new AsmMove(t2, e2.getAsmTarget()));
      } else t2 = e2.getAsmTarget();
      
      if (anode.opType() == OpType.SUB) {
        if (anode.left() == mnode) c = new IRConst(-c.value());
        else return false;
      }
      asmTarget = new AsmMem(
        t2,
        t1,
        new AsmConst(m.value()),
        new AsmConst(c.value())
      );

      return true;
    } catch (ClassCastException e){
      return false;
    }
  }
}
