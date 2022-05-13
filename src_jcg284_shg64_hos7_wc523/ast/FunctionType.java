package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;

public class FunctionType extends Type {
  public TypeList args;
  public Type ret;

  public FunctionType(TypeList args, Type ret) {
    this.args = args;
    this.ret = ret;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.startUnifiedList();
    printer.printAtom("->");
    args.pprint(printer);
    ret.pprint(printer);
    printer.endList();
  }

  public String toString() {
    return "(" + args + " -> " + ret + ")";
  }

  /**
   * {@inheritDoc}
   */
  public boolean subtypeof(Type t) {
    if (t instanceof UnitType) return true;
    if (!(t instanceof FunctionType)) return false;
    
    FunctionType ft = (FunctionType)t;
    return (args.subtypeof(ft.args) && ret.subtypeof(ft.ret));
  }

  /**
   * {@inheritdoc}
   */
  public String encoding() {
    String s = ret.encoding();
    for (Type arg : args.types) s += arg.encoding();
    return s;
  }
}