package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.xic.ir.IRStmt;

public abstract class Stmt extends Node {
  public Type t;
  public IRStmt ir;

  public Stmt(int line, int column){
    super(line, column);
    t = null;
    ir = null;
  }
}
