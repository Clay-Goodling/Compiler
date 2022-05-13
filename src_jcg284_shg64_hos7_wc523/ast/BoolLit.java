package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;

public class BoolLit extends Expr {
  public boolean b;

  public BoolLit(boolean b, int line, int column) {
    super(line, column);
    this.b = b;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.printAtom("" + b);
  }

  public String toString() {
    return "" + b;
  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception {
    v.enterBoolLit(this);
    v.exitBoolLit(this);
  }
}
