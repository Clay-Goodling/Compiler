package edu.cornell.cs.cs4120.xic.ir;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import edu.cornell.cs.cs4120.xic.ir.visit.AggregateVisitor;
import edu.cornell.cs.cs4120.xic.ir.visit.CheckCanonicalIRVisitor;
import edu.cornell.cs.cs4120.xic.ir.visit.IRVisitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * An intermediate representation for a call statement. 
 * t_1, t_2, _, t_4 = CALL(e_target, e_1, ..., e_n)
 */
public class IRCallStmt extends IRStmt {
    protected IRExpr target;
    protected List<IRExpr> args;

    /**
     * @param target address of the code for this function call
     * @param args arguments of this function call
     */
    public IRCallStmt(IRExpr target, IRExpr... args) {
        this(target, Arrays.asList(args));
    }

    /**
     * @param target address of the code for this function call
     * @param args arguments of this function call
     */
    public IRCallStmt(IRExpr target, List<IRExpr> args) {
        this.target = target;
        this.args = args;
    }

    public IRExpr target() {
        return target;
    }

    public List<IRExpr> args() {
        return args;
    }

    @Override
    public String label() {
        return "CALL_STMT";
    }

    @Override
    public IRNode visitChildren(IRVisitor v) {
        boolean modified = false;

        IRExpr target = (IRExpr) v.visit(this, this.target);
        if (target != this.target) modified = true;

        List<IRExpr> results = new ArrayList<>(args.size());
        for (IRExpr arg : args) {
            IRExpr newExpr = (IRExpr) v.visit(this, arg);
            if (newExpr != arg) modified = true;
            results.add(newExpr);
        }

        if (modified) return v.nodeFactory().IRCallStmt(target, results);

        return this;
    }

    @Override
    public <T> T aggregateChildren(AggregateVisitor<T> v) {
        T result = v.unit();
        result = v.bind(result, v.visit(target));
        for (IRExpr arg : args) result = v.bind(result, v.visit(arg));
        return result;
    }

    @Override
    public boolean isCanonical(CheckCanonicalIRVisitor v) {
        return !v.inExpr();
    }

    @Override
    public void printSExp(SExpPrinter p) {
        p.startList();
        p.printAtom("CALL_STMT");
        target.printSExp(p);
        for (IRExpr arg : args) arg.printSExp(p);
        p.endList();
    }

    @Override
    public Set<IRExpr> availableExpressions() {
        Set<IRExpr> exprs = new HashSet<>();
        for (IRExpr expr : args) {
            exprs.addAll(expr.availableExpressions().part1());
        }
        return exprs;
    }

    @Override
    public IRStmt replaceSubexprs(IRExpr sub, IRTemp t){
        IRExpr new_target = target.replaceSubexprs(sub, t);
        List<IRExpr> new_args = new ArrayList<>();
        for (IRExpr arg : args){
            new_args.add(arg.replaceSubexprs(sub, t));
        }
        return new IRCallStmt(new_target, new_args);
    }
}
