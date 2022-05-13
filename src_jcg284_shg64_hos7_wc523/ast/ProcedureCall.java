package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;
import java.util.*;

public class ProcedureCall extends Stmt {
  
  public Identifier id;
  public List<Expr> arguments;

  public ProcedureCall(
    Identifier id, List<Expr> arguments) {
      super(id.line, id.column);
      this.id = id;
      this.arguments = arguments;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.startUnifiedList();
    id.pprint(printer);
    for(Expr arg : arguments) {
      arg.pprint(printer);
    }
    printer.endList();
  }

  public String toString() {
    String s = "(" + id + "(";
    for(Expr arg : arguments) {
      s += arg;
    }
    return s + "))";
  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception {
    v.enterProcedureCall(this);
    id.accept(v);
    for (Expr e: arguments) e.accept(v);
    v.exitProcedureCall(this);
  }
}