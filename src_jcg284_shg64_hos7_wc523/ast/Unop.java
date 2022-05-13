package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;

public class Unop extends Expr {

  /**
   * The set of unary operators.
   */
  public static enum ops {
    NOT,
    NEG
  }

  public Unop.ops op;
  public Expr e;

  public Unop(Unop.ops op, Expr e, int line, int column) {
    super(line, column);
    this.op = op;
    this.e = e;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.startUnifiedList();
    switch (op) {
      case NOT:
        printer.printAtom("!"); break;
      case NEG:
        printer.printAtom("-"); break;
    }
    e.pprint(printer);
    printer.endList();
  
  }

  public String toString() {
    String s = "(";

    switch (op) {
      case NOT:
        s += "+"; break;
      case NEG:
        s += "-"; break;
      default:
        return "error: unknown unary operator";
    }
    return s + " " + e + ")";
  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception {
    v.enterUnop(this);
    e.accept(v);
    v.exitUnop(this);
  }
}
