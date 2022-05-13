package src_jcg284_shg64_hos7_wc523.ast;

import java.util.*;
import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;

public class Program extends Node{
  public List<Use> use_list;
  public List<Method> method_list;
  public Program(List<Use> ul, List<Method> ml) {
    super(ul.isEmpty() ? ml.get(0).line : ul.get(0).line, 
          ul.isEmpty() ? ml.get(0).column : ul.get(0).column);
    use_list = ul;
    method_list = ml;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.startUnifiedList();
    printer.startUnifiedList();
    for (Use u : use_list) {
      u.pprint(printer);
    }
    printer.endList();
    
    printer.startUnifiedList();
    for (Method m : method_list) {
      m.pprint(printer);
    }
    printer.endList();
    printer.endList();
  }

  public String toString() {
    String s = "((";
    for (Use u : use_list) {
      s += u;
    }
    s += ") (";
    for (Method m : method_list) {
      s += m;
    }
    return s + "))";
  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception {
    v.enterProgram(this);
    for (Use u : use_list) u.accept(v);
    for (Method m : method_list) m.accept(v);
    v.exitProgram(this);
  }
}
