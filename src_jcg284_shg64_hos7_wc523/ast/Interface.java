package src_jcg284_shg64_hos7_wc523.ast;

import java.util.*;
import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;

public class Interface extends Node{

  public List<MethodInterface> method_list;

  public Interface(List<MethodInterface> ml) {
    super(ml.get(0).line, ml.get(0).column);
    this.method_list = ml;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.startUnifiedList();
    printer.startUnifiedList();
    for(MethodInterface method : method_list) {
      method.pprint(printer);
    }
    printer.endList();
    printer.endList();
  }

  public String toString() {
    String s = "((";

    for(MethodInterface method : method_list) {
      s += method ;
    }

    return  s + "))";
  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception {
    v.enterInterface(this);
    for (MethodInterface ml : method_list) ml.accept(v);
    v.exitInterface(this);
  }
}
