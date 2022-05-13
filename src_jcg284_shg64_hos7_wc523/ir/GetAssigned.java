package src_jcg284_shg64_hos7_wc523.ir;

import edu.cornell.cs.cs4120.xic.ir.visit.IRVisitor;
import edu.cornell.cs.cs4120.xic.ir.*;

import java.util.*;

public class GetAssigned extends IRVisitor {

  public Set<IRTemp> assigned;
  public boolean memAssign;

  public GetAssigned() {
    super(new IRNodeFactory_c());
    
    assigned = new HashSet<>();
    memAssign = false;
  }

  @Override
  public IRNode visit(IRNode parent, IRNode n){
    if (n instanceof IRCall) return visit(parent, (IRCall)n);
    if (n instanceof IRCallStmt) return visit(parent, (IRCallStmt)n);
    if (n instanceof IRMove) return visit(parent, (IRMove)n);
    return super.visit(parent, n);
  }


  /**
   * Note that we can assign memory in a call.
   * @param parent The parent node of this mem.
   * @param node The node representing this node.
   * @return This node.
   */
  public IRNode visit(IRNode parent, IRCall node) {
    memAssign = true;

    return node.visitChildren(this);
  }

  /**
   * Note that we can assign memory in a call statement.
   * @param parent The parent node of this mem.
   * @param node The node representing this node.
   * @return This node.
   */
  public IRNode visit(IRNode parent, IRCallStmt node) {
    memAssign = true;

    return node.visitChildren(this);
  }

  /**
   * Accumulate the temps which are bound in a move statement.
   * @param parent The parent node of this move.
   * @param node The node representing this node.
   * @return This node.
   */
  public IRNode visit(IRNode parent, IRMove node) {
    if (node.target() instanceof IRTemp) assigned.add((IRTemp)node.target());
    if (node.target() instanceof IRMem) memAssign = true;

    return node.visitChildren(this);
  }
}
