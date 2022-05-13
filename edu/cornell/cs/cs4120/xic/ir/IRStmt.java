package edu.cornell.cs.cs4120.xic.ir;

import java.util.*;

/** An intermediate representation for statements */
public abstract class IRStmt extends IRNode_c {
  public IRStmt replaceSubexprs(IRExpr sub, IRTemp t) { return this; }
  public Set<IRExpr> availableExpressions() { return new HashSet<>(); }
}
