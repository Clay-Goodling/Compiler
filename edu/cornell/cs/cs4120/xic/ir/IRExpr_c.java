package edu.cornell.cs.cs4120.xic.ir;

import java.util.*;

import edu.cornell.cs.cs4120.xic.ir.visit.CheckCanonicalIRVisitor;
import polyglot.util.Pair;
import src_jcg284_shg64_hos7_wc523.codeGen.AsmOp;

/** An intermediate representation for expressions */
public abstract class IRExpr_c extends IRNode_c implements IRExpr {

    private AsmOp asmTarget;

    @Override
    public AsmOp getAsmTarget() {
        return asmTarget;
    }

    @Override
    public void setAsmTarget(AsmOp target) {
        asmTarget = target;
    }

    @Override
    public CheckCanonicalIRVisitor checkCanonicalEnter(CheckCanonicalIRVisitor v) {
        return v.enterExpr();
    }

    @Override
    public boolean isCanonical(CheckCanonicalIRVisitor v) {
        return v.inExpr() || !v.inExp();
    }

    @Override
    public boolean isConstant() {
        return false;
    }

    @Override
    public long constant() {
        throw new UnsupportedOperationException();
    }


    public Pair<Set<IRExpr>, Boolean> availableExpressions() {
        return new Pair<>(new HashSet<>(), false);
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof IRExpr && this.equals((IRExpr)o));
    }
}
