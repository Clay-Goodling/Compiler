package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;

public class VoidType extends Type {

  /**
   * {@inheritDoc}
   */
  public boolean subtypeof(Type t) {
    return true;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.printAtom("void");
  }

  public String toString() {
    return "void";
  }

  /**
   * {@inheritdoc}
   */
  public String encoding() {
    return "void";
  }
}
