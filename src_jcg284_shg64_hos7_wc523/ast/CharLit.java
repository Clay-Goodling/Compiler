package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;

public class CharLit extends Expr{
  public char c;

  public CharLit(char c, int line, int column) {
    super(line, column);
    this.c = c;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.printAtom("\'" + c + "\'");
  }

  public String toString() {
    return "\'" + c + "\'";
  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception {
    v.enterCharLit(this);
    v.exitCharLit(this);
  }
}
