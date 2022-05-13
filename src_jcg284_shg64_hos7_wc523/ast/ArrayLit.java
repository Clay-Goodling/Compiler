package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;
import java.util.*;

public class ArrayLit extends Expr {
  public List<Expr> values;

  public ArrayLit(List<Expr> values, int line, int column) {
    super(line, column);
    this.values = values;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.startUnifiedList();
    for (Expr e : values) {
      e.pprint(printer);
    }
    printer.endList();
  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception {
    v.enterArrayLit(this);
    for (Expr e : values) e.accept(v);
    v.exitArrayLit(this);
  }
}
