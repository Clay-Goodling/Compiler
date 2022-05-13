package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;

public class ArrayType extends Type {
  public Type t;

  public ArrayType(Type t) {
    this.t = t;
  }
  
  public ArrayType(Type t, int depth) {
    if (depth == 0) this.t = t;
    else this.t = new ArrayType(t, depth - 1);
  }
  

  /**
   * {@inheritDoc}
   */
  public boolean subtypeof(Type t) {
    return t instanceof UnitType ||
          (t instanceof ArrayType && this.t.subtypeof(((ArrayType)t).t));
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.startUnifiedList();
    printer.printAtom("[]");
    t.pprint(printer);
    printer.endList();
  }

  public String toString() {
    return  t + "[]";
  }

  /**
   * {@inheritdoc}
   */
  public String encoding() {
    return "a" + t.encoding();
  }
}
