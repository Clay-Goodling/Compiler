package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;

public class DeclStmt extends Stmt {
  public Identifier id;

  public DeclStmt(Decl d) {
    super(d.id.line, d.id.column);
    this.id = d.id;
    this.t = d.t;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.startUnifiedList();
    id.pprint(printer);
    t.pprint(printer);
    printer.endList();
  }

  public String toString() {
    return "(" + id + " " + t + ")";
  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception {
    v.enterDeclStmt(this);
    v.exitDeclStmt(this);
  }
}
