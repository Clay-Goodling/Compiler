
package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;

public class Decl extends Assignee {
  public Identifier id;

  public Decl(Identifier id, Type type) {
    super(id.line, id.column);
    this.id = id;
    this.t = type;
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
    v.enterDecl(this);
    v.exitDecl(this);
  }
}
