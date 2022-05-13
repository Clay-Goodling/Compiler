package edu.cornell.cs.cs4120.xic.ir;

import java.util.Set;

import polyglot.util.Pair;
import src_jcg284_shg64_hos7_wc523.codeGen.AsmOp;

public interface IRExpr extends IRNode {

    AsmOp getAsmTarget();
    
    void setAsmTarget(AsmOp target);

    boolean isConstant();

    long constant();

    int hashCode();

    boolean equals(IRExpr e);

    IRExpr replaceSubexprs(IRExpr sub, IRTemp t);

    public Pair<Set<IRExpr>, Boolean> availableExpressions();

    int size();
}
