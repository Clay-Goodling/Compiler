package src_jcg284_shg64_hos7_wc523.ir;

import edu.cornell.cs.cs4120.xic.ir.visit.IRVisitor;
import edu.cornell.cs.cs4120.xic.ir.*;

public class ConstantFold extends IRVisitor {
  
  public ConstantFold() {
    super(new IRNodeFactory_c());
  }

  @Override
  public IRNode visit(IRNode parent, IRNode n){
    if (n instanceof IRBinOp) return visit(parent, (IRBinOp)n);
    return super.visit(parent, n);
  }
  
  /**
   * Constant fold a BinOp node.
   * If the two operands are both constants, return a new constant node
   * consisting of the result, otherwise return this node.
   * @param parent The parent node of the BinOp.
   * @param node The node representing the BinOp.
   * @return A node representing the computation or result thereof.
   */
  public IRNode visit(IRNode parent, IRBinOp node) {
    IRBinOp folded = (IRBinOp)node.visitChildren(this);
    
    //get left and right expressions
    IRExpr e1 = folded.left();
    IRExpr e2 = folded.right();
    
    //fold if left and right are constants
    if(e1 instanceof IRConst && e2 instanceof IRConst){
      //get the constant value in each of the left and right expressions
      long v1 = ((IRConst)e1).value();
      long v2 = ((IRConst)e2).value();
      //return a new IRConst node which is the result of [e1 binop e2]
      switch (folded.opType()){
        case ADD: return new IRConst(v1 + v2);
        case SUB: return new IRConst(v1 - v2);
        case MUL: return new IRConst(v1 * v2);
        case HMUL: return new IRConst(Math.multiplyHigh(v1, v2));
        case DIV:
          if (v2 == 0) {
            return new IRBinOp(node.opType(), new IRTemp("_cfdbz"), e2);
          } else { 
            return new IRConst(v1 / v2);
          }
        case MOD:
        if (v2 == 0) {
          return new IRBinOp(node.opType(), new IRTemp("_cfdbz"), e2);
        } else { 
          return new IRConst(v1 % v2);
        }
        case AND: return new IRConst(v1 & v2);
        case OR: return new IRConst(v1 | v2);
        case XOR: return new IRConst((v1 + v2) % 2);
        case LSHIFT: return new IRConst(v1 << v2);
        case RSHIFT: return new IRConst(v1 >>> v2);
        case ARSHIFT: return new IRConst(v1 >> v2);
        case EQ: return new IRConst(v1 == v2 ? 1 : 0);
        case NEQ: return new IRConst(v1 != v2 ? 1 : 0);
        case LT: return new IRConst(v1 < v2 ? 1 : 0);
        case ULT: return new IRConst(Long.compareUnsigned(v1, v2) < 0 ? 1 : 0);
        case GT: return new IRConst(v1 > v2 ? 1 : 0);
        case LEQ: return new IRConst(v1 <= v2 ? 1 : 0);
        case GEQ: return new IRConst(v1 >= v2 ? 1 : 0);
      }
    }
    //if unable to constant fold
    return folded;
  }
}
