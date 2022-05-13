package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.xic.ir.IRExpr;

//import edu.cornell.cs.cs4120.util.SExpPrinter;

public abstract class Expr extends Node {
  public Type t;
  public IRExpr ir;

  public Expr(int line, int column){
    super(line, column);
    t = null;
    ir = null;
  }
}
