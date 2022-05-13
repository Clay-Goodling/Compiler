package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;

public class Binop extends Expr {

  /**
   * The set of binary operators.
   */
  public static enum ops {
    PLUS,   MINUS,
    TIMES,  UPPER,
    DIVIDE, MODULO,
    LT,     LEQ,
    GT,     GEQ,
    EQ,     NEQ,
    AND,    OR
  }

  public Binop.ops op;
  public Expr e1, e2;

  public Binop(Binop.ops op, Expr e1, Expr e2) {
    super(e1.line, e1.column);
    this.op = op;
    this.e1 = e1;
    this.e2 = e2;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.startUnifiedList();

    switch (op) {
      case PLUS:
        printer.printAtom("+"); break;
      case MINUS:
        printer.printAtom("-"); break;
      case TIMES:
        printer.printAtom("*"); break;
      case UPPER:
        printer.printAtom("*>>"); break;
      case DIVIDE:
        printer.printAtom("/"); break;
      case MODULO:
        printer.printAtom("%"); break;
      case LT:
        printer.printAtom("<"); break;
      case LEQ:
        printer.printAtom("<="); break;
      case GT:
        printer.printAtom(">"); break;
      case GEQ:
        printer.printAtom(">="); break;
      case EQ:
        printer.printAtom("=="); break;
      case NEQ:
        printer.printAtom("!="); break;
      case AND:
        printer.printAtom("&"); break;
      case OR:
        printer.printAtom("|"); break;
    }

    e1.pprint(printer);
    e2.pprint(printer);
    printer.endList();
  }

  public String toString() {
    String s = "(";

    switch (op) {
      case PLUS:
        s += "+"; break;
      case MINUS:
        s += "-"; break;
      case TIMES:
        s += "*"; break;
      case UPPER:
        s += "*>>"; break;
      case DIVIDE:
        s += "/"; break;
      case MODULO:
        s += "%"; break;
      case LT:
        s += "<"; break;
      case LEQ:
        s += "<="; break;
      case GT:
        s += ">"; break;
      case GEQ:
        s += ">="; break;
      case EQ:
        s += "=="; break;
      case NEQ:
        s += "!="; break;
      case AND:
        s += "&"; break;
      case OR:
        s += "|"; break;
      default:
        return "error: unknown binary operator";
    }
    return s + " " + e1 + " " + e2 + ")";
  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception {
    v.enterBinop(this);
    e1.accept(v);
    e2.accept(v);
    v.exitBinop(this);
  }
}
