package src_jcg284_shg64_hos7_wc523.ir;

import edu.cornell.cs.cs4120.xic.ir.visit.IRVisitor;
import edu.cornell.cs.cs4120.xic.ir.*;

import java.util.*;

public class GetUsed extends IRVisitor {

  public Set<IRTemp> used;
  public boolean memUse;

  public GetUsed() {
    super(new IRNodeFactory_c());
    
    used = new HashSet<>();
    memUse = false;
  }

  @Override
  public IRNode visit(IRNode parent, IRNode n){
    if (n instanceof IRCall) return visit(parent, (IRCall)n);
    if (n instanceof IRCallStmt) return visit(parent, (IRCallStmt)n);
    if (n instanceof IRMove) return visit(parent, (IRMove)n);
    if (n instanceof IRTemp) return visit(parent, (IRTemp)n);
    return super.visit(parent, n);
  }

  /**
   * Note that we use memory in a call.
   * @param parent The parent node of this mem.
   * @param node The node representing this node.
   * @return This node.
   */
  public IRNode visit(IRNode parent, IRCall node) {
    memUse = true;

    return node.visitChildren(this);
  }

  /**
   * Note that we use memory in a call statement.
   * @param parent The parent node of this mem.
   * @param node The node representing this node.
   * @return This node.
   */
  public IRNode visit(IRNode parent, IRCallStmt node) {
    memUse = true;
    return node.visitChildren(this);
  }

  /**
   * Note that we use memory in a mem statement.
   * @param parent The parent node of this mem.
   * @param node The node representing this node.
   * @return This node.
   */
  public IRNode visit(IRNode parent, IRMem node) {
    memUse = true;

    return node.visitChildren(this);
  }

  /**
   * Accumulate the temps which are used in a temp statement.
   * @param parent The parent node of this temp.
   * @param node The node representing this node.
   * @return This node.
   */
  public IRNode visit(IRNode parent, IRTemp node) {
    used.add(node);

    return node.visitChildren(this);
  }
}