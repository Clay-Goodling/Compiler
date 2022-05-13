package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;

public class IntType extends BaseType {

  /**
   * {@inheritDoc}
   */
  public boolean subtypeof(Type t) {
    return t instanceof UnitType || t instanceof IntType;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.printAtom("int");
  }

  public String toString() {
    return "int";
  }

  /**
   * {@inheritdoc}
   */
  public String encoding() {
    return "i";
  }
}
