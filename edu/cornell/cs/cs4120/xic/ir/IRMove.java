package edu.cornell.cs.cs4120.xic.ir;

import java.util.HashSet;
import java.util.Set;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import edu.cornell.cs.cs4120.xic.ir.visit.AggregateVisitor;
import edu.cornell.cs.cs4120.xic.ir.visit.IRVisitor;

/** An intermediate representation for a move statement MOVE(target, expr) */
public class IRMove extends IRStmt {
    private IRExpr target;
    private IRExpr src;

    /**
     * @param target the destination of this move
     * @param src the expression whose value is to be moved
     */
    public IRMove(IRExpr target, IRExpr src) {
        this.target = target;
        this.src = src;
    }

    public IRExpr target() {
        return target;
    }

    public IRExpr source() {
        return src;
    }

    @Override
    public String label() {
        return "MOVE";
    }

    @Override
    public IRNode visitChildren(IRVisitor v) {
        IRExpr target = (IRExpr) v.visit(this, this.target);
        IRExpr expr = (IRExpr) v.visit(this, src);

        if (target != this.target || expr != src) return v.nodeFactory().IRMove(target, expr);

        return this;
    }

    @Override
    public <T> T aggregateChildren(AggregateVisitor<T> v) {
        T result = v.unit();
        result = v.bind(result, v.visit(target));
        result = v.bind(result, v.visit(src));
        return result;
    }

    @Override
    public void printSExp(SExpPrinter p) {
        p.startList();
        p.printAtom("MOVE");
        target.printSExp(p);
        src.printSExp(p);
        p.endList();
    }

    @Override
    public Set<IRExpr> availableExpressions() {
        Set<IRExpr> exprs = new HashSet<>();
        exprs.addAll(target.availableExpressions().part1());
        exprs.addAll(src.availableExpressions().part1());
        return exprs;
    }

    @Override
    public IRStmt replaceSubexprs(IRExpr sub, IRTemp t) { 
        return new IRMove(target.replaceSubexprs(sub, t), src.replaceSubexprs(sub, t));
    }
}
