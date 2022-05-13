package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;

public class Wildcard extends Assignee {

  public Wildcard(int line, int column) {
    super(line, column);
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.printAtom("_");
  }

  public String toString() {
    return "_";
  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception {
    v.enterWildcard(this);
    v.exitWildcard(this);
  }
}
