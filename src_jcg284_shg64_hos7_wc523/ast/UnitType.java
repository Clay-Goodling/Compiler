package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;

public class UnitType extends Type {

  public boolean subtypeof(Type t) {
    return t instanceof UnitType;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.printAtom("unit");
  }

  public String toString() {
    return "unit";
  }

  /**
   * {@inheritdoc}
   */
  public String encoding() {
    return "p";
  }
}
