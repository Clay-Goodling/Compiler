package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;
public class Len extends Expr{

  public Expr e;

  public Len(Expr e, int line, int column) {
    super(line, column);
    this.e = e;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.startUnifiedList();
    printer.printAtom("length ");
    e.pprint(printer);
    printer.endList();
  }

  public String toString() {
    return "length " + e;
  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception {
    v.enterLen(this);
    e.accept(v);
    v.exitLen(this);
  }
}
 