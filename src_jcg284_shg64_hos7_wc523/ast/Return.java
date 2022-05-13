package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;
import java.util.*;

public class Return extends Stmt{
  
  public List<Expr> l;


  public Return(List<Expr> l, int line, int column) {
    super(line, column);
    this.l = l;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.startUnifiedList();
    printer.printAtom("return");
    for (Expr e : l) {
      e.pprint(printer);
    }
    printer.endList();
  }

  public String toString() {
    if(l != null) {
      return "return " + l;
    } 
    return "return";
  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception {
    v.enterReturn(this);
    for (Expr e : l) e.accept(v);
    v.exitReturn(this);
  }
}
