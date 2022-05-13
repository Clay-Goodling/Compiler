package src_jcg284_shg64_hos7_wc523.ast;

import java.util.*;
import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;

public class MethodInterface extends Node {

  public Identifier id;
  public List<Decl> params;
  public List<Type> types;

  public MethodInterface(
    Identifier id, List<Decl> params, List<Type> types) {
      super(id.line, id.column);
      this.id = id;
      this.params = params;
      this.types = types;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.startUnifiedList();
    id.pprint(printer);

    printer.startUnifiedList();
    for (Decl p : params) {
      p.pprint(printer);
    }
    printer.endList();
    
    printer.startUnifiedList();
    for (Type t : types) {
        t.pprint(printer);
    }
    printer.endList();
    printer.endList();
  }

  public String toString() {
    String s = "(" + id + " (";

    for (Decl p : params) {
      s += p;
    }
    s += ") (";

    for (Type t : types) {
      s += t;
    }

    return s + "))";
  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception {
    v.enterMethodInterface(this);
    id.accept(v);
    for (Decl p : params) p.accept(v);
    v.exitMethodInterface(this);
  }
}
