package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;

public class IntLit extends Expr {

  public long value;

  public IntLit(long n, int line, int column) {
    super(line, column);
    value = n;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.printAtom(Long.toUnsignedString(value));
  }

  public String toString() {
    return Long.toUnsignedString(value);
  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception {
    v.enterIntLit(this);
    v.exitIntLit(this);
  }
}
