package edu.cornell.cs.cs4120.xic.ir;

import java.util.*;
import edu.cornell.cs.cs4120.util.InternalCompilerError;
import edu.cornell.cs.cs4120.util.SExpPrinter;
import edu.cornell.cs.cs4120.xic.ir.visit.AggregateVisitor;
import edu.cornell.cs.cs4120.xic.ir.visit.CheckConstFoldedIRVisitor;
import edu.cornell.cs.cs4120.xic.ir.visit.IRVisitor;
import polyglot.util.Pair;

/** An intermediate representation for a binary operation OP(left, right) */
public class IRBinOp extends IRExpr_c {

    /** Binary operators */
    public enum OpType {
        ADD,
        SUB,
        MUL,
        HMUL,
        DIV,
        MOD,
        AND,
        OR,
        XOR,
        LSHIFT,
        RSHIFT,
        ARSHIFT,
        EQ,
        NEQ,
        LT,
        ULT,
        GT,
        LEQ,
        GEQ;

        @Override
        public String toString() {
            switch (this) {
                case ADD:
                    return "ADD";
                case SUB:
                    return "SUB";
                case MUL:
                    return "MUL";
                case HMUL:
                    return "HMUL";
                case DIV:
                    return "DIV";
                case MOD:
                    return "MOD";
                case AND:
                    return "AND";
                case OR:
                    return "OR";
                case XOR:
                    return "XOR";
                case LSHIFT:
                    return "LSHIFT";
                case RSHIFT:
                    return "RSHIFT";
                case ARSHIFT:
                    return "ARSHIFT";
                case EQ:
                    return "EQ";
                case NEQ:
                    return "NEQ";
                case LT:
                    return "LT";
                case ULT:
                    return "ULT";
                case GT:
                    return "GT";
                case LEQ:
                    return "LEQ";
                case GEQ:
                    return "GEQ";
            }
            throw new InternalCompilerError("Unknown op type");
        }
    };

    private OpType type;
    private IRExpr left, right;

    public IRBinOp(OpType type, IRExpr left, IRExpr right) {
        this.type = type;
        this.left = left;
        this.right = right;
    }

    public OpType opType() {
        return type;
    }

    public IRExpr left() {
        return left;
    }

    public IRExpr right() {
        return right;
    }

    @Override
    public String label() {
        return type.toString();
    }

    @Override
    public IRNode visitChildren(IRVisitor v) {
        IRExpr left = (IRExpr) v.visit(this, this.left);
        IRExpr right = (IRExpr) v.visit(this, this.right);

        if (left != this.left || right != this.right)
            return v.nodeFactory().IRBinOp(type, left, right);

        return this;
    }

    @Override
    public <T> T aggregateChildren(AggregateVisitor<T> v) {
        T result = v.unit();
        result = v.bind(result, v.visit(left));
        result = v.bind(result, v.visit(right));
        return result;
    }

    @Override
    public boolean isConstFolded(CheckConstFoldedIRVisitor v) {
        if (isConstant()) {
            switch (type) {
                case DIV:
                case MOD:
                    return right.constant() == 0;
                default:
                    return false;
            }
        }
        return true;
    }

    @Override
    public boolean isConstant() {
        return left.isConstant() && right.isConstant();
    }

    @Override
    public void printSExp(SExpPrinter p) {
        p.startList();
        p.printAtom(type.toString());
        left.printSExp(p);
        right.printSExp(p);
        p.endList();
    }

    public boolean equals(IRExpr e) {
        if (!(e instanceof IRBinOp)) {
            //System.out.println("Not a binop");
            return false;
        }
        IRBinOp n = (IRBinOp)e;
        if (opType() != n.opType()) {
            // System.out.println("Binops not equal");
            return false;
        }
        switch (opType()) {
            case ADD: //commutative
            case MUL:
            case HMUL:
            case AND:
            case OR:
            case XOR:
            case EQ:
            case NEQ:
                if (left().equals(n.right()) && right().equals(n.left())) {
                    // System.out.println("Binops equal!");
                    return true;
                }
            default: // non-commutative
                if (left().equals(n.left()) && right().equals(n.right())){
                    // System.out.println("Binops equal");
                }
                return left().equals(n.left()) && right().equals(n.right());
        }
    }

    @Override
    public int hashCode() {
      int leftHash = left().hashCode();
      int rightHash = right().hashCode();
      switch (opType()) {
        case ADD: //commutative
        case MUL:
        case HMUL:
        case AND:
        case OR:
        case XOR:
        case EQ:
        case NEQ:
          if (leftHash < rightHash) {
            int temp = leftHash;
            leftHash = rightHash;
            rightHash = temp;
          }
        default: // non-commutative
          return ("" + opType().hashCode() + leftHash + rightHash).hashCode();
      }
    }

    @Override
    public Pair<Set<IRExpr>, Boolean> availableExpressions(){
        Pair<Set<IRExpr>, Boolean> leftExprs = left.availableExpressions();
        Pair<Set<IRExpr>, Boolean> rightExprs = right.availableExpressions();
        Set<IRExpr> availExprs = new HashSet<>();
        availExprs.addAll(leftExprs.part1());
        availExprs.addAll(rightExprs.part1());
        if (!leftExprs.part2() && !rightExprs.part2()) availExprs.add(this);
        return new Pair<>(availExprs, leftExprs.part2() || rightExprs.part2());
    }

    @Override
    public IRExpr replaceSubexprs(IRExpr sub, IRTemp t) {
        if (this.equals(sub)) return t;
        return new IRBinOp(type, left().replaceSubexprs(sub, t), right().replaceSubexprs(sub,t));
    }

    @Override
    public int size() {
        return 1 + left.size() + right.size();
    }

    //    public IRExpr negate() {
    //        IRBinOp expr = (IRBinOp) copy();
    //        switch (type) {
    //        case LT:
    //            expr.type = OpType.GE;
    //            break;
    //        case GT:
    //            expr.type = OpType.LE;
    //            break;
    //        case LE:
    //            expr.type = OpType.GT;
    //            break;
    //        case GE:
    //            expr.type = OpType.LT;
    //            break;
    //        case ULT:
    //            expr.type = OpType.UGE;
    //            break;
    //        case UGT:
    //            expr.type = OpType.ULE;
    //            break;
    //        case ULE:
    //            expr.type = OpType.UGT;
    //            break;
    //        case UGE:
    //            expr.type = OpType.ULT;
    //            break;
    //        case EQ:
    //            expr.type = OpType.NEQ;
    //            break;
    //        case NEQ:
    //            expr.type = OpType.EQ;
    //            break;
    //        default:
    //            return super.negate();
    //        }
    //        return expr;
    //    }
    //
    //    public IRBinOp swapArgs() {
    //        IRBinOp expr = (IRBinOp) copy();
    //        expr.left = right;
    //        expr.right = left;
    //        switch (type) {
    //        case LT:
    //            expr.type = OpType.GT;
    //            break;
    //        case GT:
    //            expr.type = OpType.LT;
    //            break;
    //        case LE:
    //            expr.type = OpType.GE;
    //            break;
    //        case GE:
    //            expr.type = OpType.LE;
    //            break;
    //        case ULT:
    //            expr.type = OpType.UGT;
    //            break;
    //        case UGT:
    //            expr.type = OpType.ULT;
    //            break;
    //        case ULE:
    //            expr.type = OpType.UGE;
    //            break;
    //        case UGE:
    //            expr.type = OpType.ULE;
    //            break;
    //        case EQ:
    //            expr.type = OpType.EQ;
    //            break;
    //        case NEQ:
    //            expr.type = OpType.NEQ;
    //            break;
    //        case ADD:
    //            expr.type = OpType.ADD;
    //            break;
    //        case MUL:
    //            expr.type = OpType.MUL;
    //            break;
    //        case AND:
    //            expr.type = OpType.AND;
    //            break;
    //        case OR:
    //            expr.type = OpType.OR;
    //            break;
    //        case LOGAND:
    //            expr.type = OpType.LOGAND;
    //            break;
    //        case LOGOR:
    //            expr.type = OpType.LOGOR;
    //            break;
    //        default:
    //            return null;
    //        }
    //        return expr;
    //    }
    //
    //    public boolean isComparison() {
    //        switch (type) {
    //        case EQ:
    //        case NEQ:
    //        case LT:
    //        case GT:
    //        case LE:
    //        case GE:
    //        case ULT:
    //        case UGT:
    //        case ULE:
    //        case UGE:
    //            return true;
    //        default:
    //            return false;
    //        }
    //    }
    //
    //    // eval the value based on op type
    //    public static long eval(OpType opType, long leftVal, long rightVal) {
    //        switch (opType) {
    //        case ADD:
    //            return leftVal + rightVal;
    //        case AND:
    //        case LOGAND:
    //            return leftVal & rightVal;
    //        case DIV:
    //            if (rightVal == 0)
    //                throw new InternalCompilerException("Division by zero "
    //                        + "during constant folding -- please fix your program!");
    //            return leftVal / rightVal;
    //        case EQ:
    //            return leftVal == rightVal ? 1 : 0;
    //        case GE:
    //            return leftVal >= rightVal ? 1 : 0;
    //        case GT:
    //            return leftVal > rightVal ? 1 : 0;
    //        case LE:
    //            return leftVal <= rightVal ? 1 : 0;
    //        case AR_LSHIFT:
    //            return leftVal << rightVal;
    //        case LSHIFT:
    //            return leftVal << rightVal;
    //        case LT:
    //            return leftVal < rightVal ? 1 : 0;
    //        case MOD:
    //            if (rightVal == 0)
    //                throw new InternalCompilerException("Division by zero "
    //                        + "during constant folding -- please fix your program!");
    //            return leftVal % rightVal;
    //        case MUL:
    //            return leftVal * rightVal;
    //        case NEQ:
    //            return leftVal != rightVal ? 1 : 0;
    //        case OR:
    //        case LOGOR:
    //            return leftVal | rightVal;
    //        case AR_RSHIFT:
    //            return leftVal >> rightVal;
    //        case RSHIFT:
    //            return leftVal >>> rightVal;
    //        case SUB:
    //            return leftVal - rightVal;
    //        case XOR:
    //            return leftVal ^ rightVal;
    //        case UGT:
    //            return leftVal > rightVal ^ leftVal < 0 != rightVal < 0 ? 1 : 0;
    //        case ULT:
    //            return leftVal < rightVal ^ leftVal < 0 != rightVal < 0 ? 1 : 0;
    //        case ULE:
    //            return leftVal == rightVal
    //                    || leftVal < rightVal ^ leftVal < 0 != rightVal < 0 ? 1 : 0;
    //        case UGE:
    //            return leftVal == rightVal
    //                    || leftVal > rightVal ^ leftVal < 0 != rightVal < 0 ? 1 : 0;
    //        default:
    //            throw new InternalCompilerException("Unknow op type "
    //                    + opType.toString());
    //        }
    //    }
}
