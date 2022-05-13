package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;
import java.util.*;

public class ArrayInit extends Stmt {
  public Identifier id;
  public Type type;
  public List<Expr> sizes;
  
  public ArrayInit(Identifier id, List<Object> l) {
    super(id.line, id.column);
    this.id = id;
    this.type = (Type)l.get(0);
    this.sizes = (List<Expr>)(Object)(l.subList(1, l.size()));
  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception {
    v.enterArrayInit(this);
    for (Expr i : sizes) {
      if (i != null) i.accept(v);
    }
    v.exitArrayInit(this);
  }
    
  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.startUnifiedList();
    id.pprint(printer);

    for (int i = 0; i < sizes.size(); i++) {
      printer.startUnifiedList();
      printer.printAtom("[]");
    }
    type.pprint(printer);
    for (int i = sizes.size() - 1; i >= 0; i--) {
      Expr e = sizes.get(i);
      if (e != null) e.pprint(printer);
      printer.endList();
    }
    
    printer.endList();
  }

  public String toString() {
    return  t + "[]";
  }
}