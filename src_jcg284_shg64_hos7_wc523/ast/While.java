package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;

public class While extends Stmt{
  
  public Expr e;
  public Block block;

  public While(Expr e, Block b, int line, int column) {
    super(line, column);
    this.e = e;
    this.block = b;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.startUnifiedList();
    printer.printAtom("while");
    e.pprint(printer);
    block.pprint(printer);
    printer.endList();
  }

  public String toString() {
    return "while (" + e + ") (" + block + " )";
  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception {
    v.enterWhile(this);
    e.accept(v);
    block.accept(v);
    v.exitWhile(this);
  }
}
