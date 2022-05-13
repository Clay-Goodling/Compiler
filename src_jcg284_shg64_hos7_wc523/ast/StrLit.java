package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;

public class StrLit extends Expr {
  
  public String s;

  public StrLit(String s, int line, int column) {
    super(line, column);
    this.s = s;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    String formatted = s.replace("\\", "\\\\")
                        .replace("\n", "\\n")
                        .replace("\'", "\\'")
                        .replace("\"", "\\\"")
                        .replace("\t", "\\t");
    printer.printAtom("\"" + formatted + "\"");
  }

  public String toString() {
    String formatted = s.replace("\\", "\\\\")
                        .replace("\n", "\\n")
                        .replace("\'", "\\'")
                        .replace("\"", "\\\"")
                        .replace("\t", "\\t");
    return "\"" + formatted + "\"";
  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception {
    v.enterStrLit(this);
    v.exitStrLit(this);
  }
}