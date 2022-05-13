package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;

public class Use extends Node {
  public Identifier id;

  public Use(Identifier id, int line, int column) {
    super(line, column);
    this.id = id;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.startUnifiedList();
    printer.printAtom("use");
    id.pprint(printer);
    printer.endList();
  }

  public String toString() {
    return "(use " + id + ")";
  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception {
    v.enterUse(this);
    v.exitUse(this);
  }
}
