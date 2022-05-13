package src_jcg284_shg64_hos7_wc523.ast;

import java.util.*;
import edu.cornell.cs.cs4120.util.SExpPrinter;
import edu.cornell.cs.cs4120.xic.ir.IRFuncDecl;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;

public class Method extends Node{
  public Identifier id;
  public List<Decl> params;
  public List<Type> types;
  public Block body;
  public FunctionType t;
  public IRFuncDecl ir;
  
  public Method(
    Identifier id, List<Decl> params, List<Type> types, Block body) {
      super(id.line, id.column);
      this.id = id;
      this.params = params;
      this.types = types;
      this.body = body;
      this.t = null;
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
    body.pprint(printer);
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
    s += ")" + body + ")";

    return s;
  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception { 
    v.enterMethod(this);
    for (Decl p : params) p.accept(v);
    body.accept(v);
    v.exitMethod(this);
  }
}
