package src_jcg284_shg64_hos7_wc523.ast;

import java.util.*;
import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;

public class Block extends Stmt {
  
  public List<Stmt> statements;
  Boolean single_statement;

  public Block(List<Stmt> s, int line, int column) {
    super(line, column);
    this.statements = s;
    single_statement = false;
  }

  public Block(Stmt s) {
    super(s.line, s.column);
    statements = new ArrayList<>();
    statements.add(s);
    single_statement = true;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    if (!single_statement) printer.startUnifiedList();
    for (Stmt stmt : statements) {
      stmt.pprint(printer);
    }
    if (!single_statement) printer.endList();
  }

  public String toString() {
    String s = "(";
    for (Stmt stmt : statements) {
      s += stmt;
    }
    return s + ")";
  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception {
    v.enterBlock(this);
    for (Stmt s : statements) {
      s.accept(v);
    }
    v.exitBlock(this);
  }
}
