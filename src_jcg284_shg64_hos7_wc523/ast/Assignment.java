package src_jcg284_shg64_hos7_wc523.ast;

import java.util.*;
import edu.cornell.cs.cs4120.util.SExpPrinter;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;

public class Assignment extends Stmt {

  public List<Assignee> assignees;
  public Expr e;

  public Assignment(List<Assignee> assignees, Expr e) {
    super(assignees.get(0).line, assignees.get(0).column);
    this.assignees = assignees;
    this.e = e;
  }

  public Assignment(Assignee assignee, Expr e) {
    super(assignee.line, assignee.column);
    this.assignees = new ArrayList<>();
    this.assignees.add(assignee);
    this.e = e;
  }

  /**
   * {@inheritDoc}
   */
  public void pprint(SExpPrinter printer) {
    printer.startUnifiedList();
    printer.printAtom("=");

    if (assignees.size() > 1) printer.startUnifiedList();
    for (Assignee x : assignees) x.pprint(printer);
    if (assignees.size() > 1) printer.endList();

    e.pprint(printer);
    printer.endList();
  }

  public String toString() {
    String s = "(= ";

    if (assignees.size() > 1) {
      s += "(";
    }

    for (Assignee x : assignees) {
      s += x + " ";
    }

    if (assignees.size() > 1) {
      s += ")";
    }

    s += e + ")";

    return s;
  }

  /**
   * {@inheritDoc}
   */
  public void accept(Visitor v) throws Exception {
    v.enterAssignment(this);
    e.accept(v);
    for (Assignee x : assignees) x.accept(v);
    v.exitAssignment(this);
  }
}
