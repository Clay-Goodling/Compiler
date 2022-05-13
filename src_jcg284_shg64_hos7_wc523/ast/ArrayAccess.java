package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;

public class ArrayAccess extends Assignee {
  
  public Expr array;
  public Expr index;

  public ArrayAccess(Expr array, Expr index) {
    super(array.line, array.column);

    this.array = array;
    this.index = index;
  }
  
  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.startUnifiedList();
    printer.printAtom("[]");
    array.pprint(printer);
    index.pprint(printer);
    printer.endList();
  }

  public String toString() {
    return "([] " + array + " " + index + ")";

  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception {
    v.enterArrayAccess(this);
    array.accept(v);
    index.accept(v);
    v.exitArrayAccess(this);
  }
}
