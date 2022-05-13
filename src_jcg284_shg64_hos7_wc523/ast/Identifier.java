package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;

public class Identifier extends Assignee {
  public String id;

  public Identifier(String id, int line, int column) {
    super(line, column);
    this.id = id;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.printAtom(id);
  }

  public String toString() {
    return id;
  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception {
    v.enterIdentifier(this);
    v.exitIdentifier(this);
  }
}
