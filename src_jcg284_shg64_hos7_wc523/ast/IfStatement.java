package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;

public class IfStatement extends Stmt {
  public Expr e;
  public Block b1;
  public Block b2;
  public boolean else_exists;

  public IfStatement(Expr e, Block b1, Block b2, int line, int column) {
    super(line, column);
    this.e = e;
    this.b1 = b1;
    this.b2 = b2;
    this.else_exists = true;
  }

  public IfStatement(Expr e, Block b1, int line, int column) {
    super(line, column);
    this.e = e;
    this.b1 = b1;
    this.b2 = null;
    this.else_exists = false;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.startUnifiedList();

    printer.printAtom("if");
    e.pprint(printer);
    b1.pprint(printer);
    if(else_exists) b2.pprint(printer);

    printer.endList();
  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception {
    v.enterIfStatement(this);
    e.accept(v);
    b1.accept(v);
    if (else_exists) b2.accept(v);
    v.exitIfStatement(this);
  }
 }
 