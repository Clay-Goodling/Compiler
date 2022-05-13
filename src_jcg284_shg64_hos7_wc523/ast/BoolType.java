package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;

public class BoolType extends BaseType {

  /**
   * {@inheritDoc}
   */
  public boolean subtypeof(Type t){
    return t instanceof UnitType || t instanceof BoolType;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.printAtom("bool");
  }

  public String toString() {
    return "bool";
  }

  /**
   * {@inheritdoc}
   */
  public String encoding() {
    return "b";
  }
}
