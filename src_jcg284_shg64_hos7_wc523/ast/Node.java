package src_jcg284_shg64_hos7_wc523.ast;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;
import edu.cornell.cs.cs4120.xic.ir.IRNode;

public abstract class Node {
  public int line;
  public int column;
  public IRNode ir;

  public Node(int line, int column){
    this.line = line;
    this.column = column;
  }

  /**
   * Print an S-Expression representing this AST node.
   * @param printer The output device.
   */
  public void pprint(SExpPrinter printer) {}

  /**
   * Let the visitor v recursively visit all necesary subnodes, then visit
   * this node.
   * @param v The visitor. 
   */
  public void accept(Visitor v) throws Exception {}

}
