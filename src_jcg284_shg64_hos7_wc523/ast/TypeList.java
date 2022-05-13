package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import java.util.*;

public class TypeList extends Type {
  public List<Type> types;

  public TypeList(List<Type> types){
    this.types = types;
  }

  /**
   * {@inheritDoc}
   */
  public boolean subtypeof(Type t) {
    if (t instanceof UnitType) return true;
    if (!(t instanceof TypeList)) return false;
    TypeList tl = (TypeList)t;

    int size = types.size();
    if (size != tl.types.size()) return false;
    
    for (int i = 0; i < size; i++) {
      if (!types.get(i).subtypeof(tl.types.get(i))) return false;
    }
    return true;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.startUnifiedList();
    for (Type t : types) t.pprint(printer);
    printer.endList();
  }

  public String toString() {
    String s = "( ";
    for (Type t : types) s += t + " ";
    return s + ")";
  }

  /**
   * {@inheritdoc}
   */
  public String encoding() {
    String s = "t" + types.size();
    for (Type t : types) s += t.encoding();
    return s;
  }
}