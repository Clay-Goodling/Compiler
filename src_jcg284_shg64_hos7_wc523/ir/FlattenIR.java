package src_jcg284_shg64_hos7_wc523.ir;

import edu.cornell.cs.cs4120.xic.ir.visit.IRVisitor;
import edu.cornell.cs.cs4120.xic.ir.*;

import java.util.*;

public class FlattenIR extends IRVisitor {


  public FlattenIR() {
    super(new IRNodeFactory_c());
  }

  @Override
  public IRNode visit(IRNode parent, IRNode n){
    if (n instanceof IRSeq) return visit(parent, (IRSeq)n);
    if (n instanceof IRFuncDecl) return visit(parent, (IRFuncDecl)n);
    return super.visit(parent, n);
  }

  /**
   * Flatten a Seq node.
   * @param parent The parent node of the Seq
   * @param node The Seq node to be flattened.
   * @return a Seq with all non Seq statements as well as the statements in any
   * child Seq statements
   */
  public IRSeq visit(IRNode parent, IRSeq node) {
    IRSeq flattened = (IRSeq)node.visitChildren(this);

    List<IRStmt> stmts = new ArrayList<>();

    for (IRStmt s : flattened.stmts()) {
      if (s instanceof IRSeq) {
        for (IRStmt s1 : ((IRSeq)s).stmts()) {
          stmts.add(s1);
        }
      } else {
        stmts.add(s);
      }
    }
    return new IRSeq(stmts);
  }

    /**
   * Flatten a FuncDecl node.
   * @param parent The parent node of the FuncDecl
   * @param node The FuncDecl node to be flattened.
   * @return a IRFuncDecl with all non Seq statements as well as the statements 
   * in any child Seq statements
   */
  public IRFuncDecl visit(IRNode parent, IRFuncDecl node) {
    IRFuncDecl flattened = (IRFuncDecl)node.visitChildren(this);

    List<IRStmt> stmts = ((IRSeq)flattened.body()).stmts();
    if (stmts.size() > 0 && !(stmts.get(stmts.size()-1) instanceof IRReturn)) {
      stmts.add(new IRReturn());
    }

    return new IRFuncDecl(node.name(), new IRSeq(stmts));
  }
}