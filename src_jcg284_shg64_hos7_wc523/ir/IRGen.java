package src_jcg284_shg64_hos7_wc523.ir;

import src_jcg284_shg64_hos7_wc523.ast.*;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;
import src_jcg284_shg64_hos7_wc523.typechecker.*;
import java.util.*;
import edu.cornell.cs.cs4120.xic.ir.*;

public class IRGen extends Visitor {

  Context env;
  private long labelState;
  public long tempState;

  private String filename;

  private static String malloc = "_xi_alloc";
  private static String lerror = "_xi_out_of_bounds";

  public IRGen(Context env, String filename) {
    this.env = env;
    this.filename = filename;
    this.labelState = 0;
  }
  
  /**
   * Generate a fresh label.
   * @return a fresh label.
   */
  private String labelGen() {
    String result = "_label" + this.labelState;
    labelState++;
    return result;
  }

   /**
   * Generate a fresh temp.
   * @return a fresh temp.
   */
  private IRTemp tempGen() {
    String result = "_temp" + this.tempState;
    tempState++;
    return new IRTemp(result);
  }

  private String mangleFunctionName(String name, FunctionType type) {
    String s = "_I";
    s += name.replace("_", "__");
    s += "_";
    s += type.encoding();
    return s;
  }

  //helper functions for easier writing
  private IRConst CONST(long v) {
    return new IRConst(v);
  }
  private IRTemp TEMP(String x) {
    return new IRTemp(x);
  }
  private IRName NAME(String x) {
    return new IRName(x);
  }
  private IRLabel LABEL(String name) {
    return new IRLabel(name);
  }
  private IRMove MOVE(IRExpr target, IRExpr src) {
    return new IRMove(target, src);
  }
  private IRMem MEM(IRExpr e) {
    return new IRMem(e);
  }
  private IRJump JUMP(IRExpr e) {
    return new IRJump(e);
  }
  private IRCall CALL(IRExpr target, IRExpr... args) {
    return new IRCall(target, args);
  }
  private IRCJump CJUMP(IRExpr guard, String lt) {
    return new IRCJump(guard, lt);
  }
  private IRBinOp ADD(IRExpr e1, IRExpr e2) {
    return new IRBinOp(IRBinOp.OpType.ADD, e1, e2);
  }
  private IRBinOp SUB(IRExpr e1, IRExpr e2) {
    return new IRBinOp(IRBinOp.OpType.SUB, e1, e2);
  }
  private IRBinOp MUL(IRExpr e1, IRExpr e2) {
    return new IRBinOp(IRBinOp.OpType.MUL, e1, e2);
  }
  private IRBinOp HMUL(IRExpr e1, IRExpr e2) {
    return new IRBinOp(IRBinOp.OpType.HMUL, e1, e2);
  }
  private IRBinOp DIV(IRExpr e1, IRExpr e2) {
    return new IRBinOp(IRBinOp.OpType.DIV, e1, e2);
  }
  private IRBinOp MOD(IRExpr e1, IRExpr e2) {
    return new IRBinOp(IRBinOp.OpType.MOD, e1, e2);
  }
  private IRBinOp NOT(IRExpr e) {
    return new IRBinOp(IRBinOp.OpType.XOR, CONST(1), e);
  }
  private IRBinOp EQ(IRExpr e1, IRExpr e2) {
    return new IRBinOp(IRBinOp.OpType.EQ, e1, e2);
  }
  private IRBinOp NEQ(IRExpr e1, IRExpr e2) {
    return new IRBinOp(IRBinOp.OpType.NEQ, e1, e2);
  }
  private IRBinOp LT(IRExpr e1, IRExpr e2) {
    return new IRBinOp(IRBinOp.OpType.LT, e1, e2);
  }
  private IRBinOp ULT(IRExpr e1, IRExpr e2) {
    return new IRBinOp(IRBinOp.OpType.ULT, e1, e2);
  }
  private IRBinOp GT(IRExpr e1, IRExpr e2) {
    return new IRBinOp(IRBinOp.OpType.GT, e1, e2);
  }
  private IRBinOp LEQ(IRExpr e1, IRExpr e2) {
    return new IRBinOp(IRBinOp.OpType.LEQ, e1, e2);
  }
  private IRBinOp GEQ(IRExpr e1, IRExpr e2) {
    return new IRBinOp(IRBinOp.OpType.GEQ, e1, e2);
  }
  
  /**
   * Exit an ArrayAccess node.
   * @param node the ArrayAccess node to be exited.
   */
  public void exitArrayAccess(ArrayAccess node) {
    Expr array = node.array;
    Expr index = node.index;

    IRTemp ta = tempGen();
    IRTemp ti = tempGen();
    String lt = labelGen();

    node.ir = new IRESeq(
      new IRSeq(
        MOVE(ta, array.ir),
        MOVE(ti, index.ir),
        CJUMP(ULT(ti, MEM(SUB(ta, CONST(8)))), lt),
        new IRCallStmt(NAME(lerror)),
        LABEL(lt)
      ), 
      MEM(ADD(ta, MUL(CONST(8), ti)))
    );
  }

  /**
   * Initailize an IR array
   * @param sizes an array of lengths of the array to be initialized.
   * @return
   */
  private IRESeq initArray(List<IRExpr> sizes) {
    List<IRStmt> stmts = new ArrayList<IRStmt>();
    IRTemp tn = tempGen();
    IRTemp tm = tempGen();
    IRExpr size = sizes.get(0);

    stmts.add(MOVE(tn, size));
    stmts.add(MOVE(tm, CALL(NAME(malloc), ADD(MUL(tn, CONST(8)), CONST(8)))));
    stmts.add(MOVE(MEM(tm), tn));

    if (sizes.size() > 1 && sizes.get(1) != null) {
      String loop = labelGen();
      IRTemp tindex = tempGen();

      String lt = labelGen();

      stmts.add(MOVE(tindex, CONST(0)));
      stmts.add(LABEL(loop));
      stmts.add(CJUMP(EQ(tindex, tn), lt));
      IRExpr index = MEM(ADD(ADD(tm, CONST(8)), MUL(tindex, CONST(8))));
      stmts.add(MOVE(index, initArray(sizes.subList(1, sizes.size()))));
      stmts.add(MOVE(tindex, ADD(tindex, CONST(1))));
      stmts.add(JUMP(NAME(loop)));
      stmts.add(LABEL(lt));
    }

    return new IRESeq(new IRSeq(stmts), ADD(tm, CONST(8)));
  }

  /**
   * Exit an ArrayInit node.
   * @param node the ArrayInit node to be exited.
   */
  public void exitArrayInit(ArrayInit node) {
    Identifier x = node.id;
    List<Expr> sizes = node.sizes;
    List<IRExpr> sizeTemps = new ArrayList<>();
    List<IRStmt> stmts = new ArrayList<>();

    for (Expr size : sizes) {
      if (size != null) {
        IRTemp t = tempGen();
        sizeTemps.add(t);
        stmts.add(new IRMove(t, size.ir));
      } else {
        sizeTemps.add(null);
      }
    }

    stmts.add(MOVE(TEMP(x.id), initArray(sizeTemps)));
    node.ir = new IRSeq(stmts);
  }
  
  /**
   * Exit an ArrayLit node.
   * @param node the ArrayLit node to be exited.
   */
  public void exitArrayLit(ArrayLit node) {
    List<Expr> values = node.values;

    IRTemp tm = tempGen();
    List<IRStmt> stmts = new ArrayList<>();

    stmts.add(MOVE(tm, CALL(NAME(malloc), CONST(values.size() * 8 + 8))));
    stmts.add(MOVE(MEM(tm), CONST(values.size())));
    
    for (int i = 0; i < values.size(); i++) {
      IRExpr v = values.get(i).ir;
      stmts.add(MOVE(MEM(ADD(tm, CONST((i + 1) * 8))), v));
    }

    node.ir = new IRESeq(new IRSeq(stmts), ADD(tm, CONST(8)));
  }

  /**
   * Exit an Assignment node.
   * @param node the Assignment node to be exited.
   */
  public void exitAssignment(Assignment node) {
    List<Assignee> assignees = node.assignees;
    Expr e = node.e;

    if (e instanceof MethodCall) {
      IRCall ecall = (IRCall)e.ir;
      List<IRStmt> stmts = new ArrayList<>();

      // this thing puts assignee evaluations before the method call
      List<IRExpr> assigneeIRs = new ArrayList<>();
      for (Assignee assignee : assignees) {
        if (assignee.ir instanceof IRTemp) {
          // if the assignee is a temp, use it
          assigneeIRs.add(assignee.ir);
        } else if (assignee.ir instanceof IRESeq) {
          // eseq representing a memory access
          IRESeq eseq = (IRESeq)assignee.ir;
          IRTemp t = tempGen();
          // do the side effects of the memory access
          stmts.add(eseq.stmt());
          // move the address of the memory access of the array access to a temp
          stmts.add(MOVE(t, ((IRMem)eseq.expr()).expr()));
          // use that temp as an assignee
          assigneeIRs.add(MEM(t));
        }
      }

      // do the call
      stmts.add(new IRCallStmt(ecall.target(), ecall.args()));

      // move the result of the call into the relevent temp or mem location
      for (int i = 0; i < assigneeIRs.size(); i++) {
        stmts.add(MOVE(assigneeIRs.get(i), TEMP("_RET" + i)));
      }
      
      node.ir = new IRSeq(stmts);
    } else {
      node.ir = MOVE(assignees.get(0).ir, e.ir);
    }
  }
  
  /**
   * Exit a Binop node.
   * @param node the Binop node to be exited.
   */
  public void exitBinop(Binop node) {
    IRExpr e1 = node.e1.ir;
    IRExpr e2 = node.e2.ir;
    switch(node.op) {
      case PLUS:
        if (node.e1.t instanceof IntType) {
          node.ir = ADD(e1, e2);
        } else {
          IRTemp tm = tempGen();
          IRTemp tsize1 = tempGen();
          IRTemp tsize2 = tempGen();
          IRTemp tsize = tempGen();
          IRTemp index = tempGen();
          IRTemp array = tempGen();
          IRTemp array1 = tempGen();
          IRTemp array2 = tempGen();
          
          String loop = labelGen();
          String loop2 = labelGen();
          String end = labelGen();
          
          node.ir = new IRESeq(new IRSeq(
            MOVE(array1, e1),
            MOVE(array2, e2),
            MOVE(tsize1, MEM(SUB(array1, CONST(8)))),
            MOVE(tsize2, MEM(SUB(array2, CONST(8)))),
            MOVE(tsize, ADD(tsize1, tsize2)),

            MOVE(tm, CALL(
              NAME(malloc), ADD(MUL(tsize, CONST(8)), CONST(8))
            )),
            MOVE(MEM(tm), tsize),
            MOVE(array, ADD(tm, CONST(8))),

            MOVE(index, CONST(0)),

            LABEL(loop),
            CJUMP(GEQ(index, tsize1), loop2),
            MOVE(
              MEM(ADD(array, MUL(CONST(8), index))),
              MEM(ADD(array1, MUL(CONST(8), index)))
            ),
            MOVE(index, ADD(index, CONST(1))),
            JUMP(NAME(loop)),

            LABEL(loop2),
            CJUMP(EQ(index, tsize), end),
            MOVE(
              MEM(ADD(array, MUL(CONST(8), index))), 
              MEM(ADD(array2, MUL(CONST(8), SUB(index, tsize1))))
            ),
            MOVE(index, ADD(index, CONST(1))),
            JUMP(NAME(loop2)),
            LABEL(end)
          ), array);
        }
        break;
      case MINUS:
        node.ir = SUB(e1, e2);
        break;
      case TIMES:
        node.ir = MUL(e1, e2);
        break;
      case UPPER:
        node.ir = HMUL(e1, e2);
        break;
      case DIVIDE:
        node.ir = DIV(e1, e2);
        break;
      case MODULO:
        node.ir = MOD(e1, e2);
        break;
      case LT:
        node.ir = LT(e1, e2);
        break;
      case LEQ:
        node.ir = LEQ(e1, e2);
        break;
      case GT:
        node.ir = GT(e1, e2);
        break;
      case GEQ:
        node.ir = GEQ(e1, e2);
        break;
      case EQ:
        node.ir = EQ(e1, e2);
        break;
      case NEQ:
        node.ir = NEQ(e1, e2);
        break;
      case AND:
        IRTemp t1 = tempGen();
        String lf1 = labelGen();
        
        node.ir = new IRESeq(new IRSeq(	
          MOVE(t1, CONST(0)), 
          CJUMP(NOT(e1), lf1), 
			    CJUMP(NOT(e2), lf1),
			    MOVE(t1, CONST(1)),
			    LABEL(lf1)
		      ), t1
	      );
        break;
      case OR:
        IRTemp t2 = tempGen();
        String lf2 = labelGen();
      
        node.ir = new IRESeq(new IRSeq(	
        MOVE(t2, CONST(1)), 
        CJUMP(e1, lf2), 
        CJUMP(e2, lf2),
        MOVE(t2, CONST(0)),
        LABEL(lf2)
        ), t2
      );
        break;
    }
  }

  /**
   * Exit a Block node.
   * @param node the Block node to be exited.
   */
  public void exitBlock(Block node) {
    List<IRStmt> stmts = new ArrayList<>();
    for (Stmt s : node.statements) stmts.add(s.ir);
    node.ir = new IRSeq(stmts);
  }
  
  /**
   * Exit a BoolLit node.
   * @param node the BoolLit node to be exited.
   */
  public void exitBoolLit(BoolLit node) {
        node.ir = CONST(node.b ? 1 : 0);
  }
  
  /**
   * Exit a CharLit node.
   * @param node the CharLit node to be exited.
   */
  public void exitCharLit(CharLit node) {
        node.ir = CONST((long)(node.c));
  }
  
  /**
   * Exit a Decl node.
   * @param node the Decl node to be exited.
   */
  public void exitDecl(Decl node) {
    node.ir = TEMP(node.id.id);
  }
  
  /**
   * Exit a DeclStmt node.
   * @param node the DeclStmt node to be exited.
   */
  public void exitDeclStmt(DeclStmt node) {
    node.ir = LABEL(labelGen());
  }
  
  /**
   * Exit an Identifier node.
   * @param node the Identifier node to be exited.
   */
  public void exitIdentifier(Identifier node) {
    node.ir = TEMP(node.id);
  }
  
  /**
   * Exit an IfStatement node.
   * @param node the IfStatement node to be exited.
   */
  public void exitIfStatement(IfStatement node) {
    IRExpr e = node.e.ir;
    IRStmt s1 = node.b1.ir;
    IRStmt s2 = node.b2 != null ? node.b2.ir : LABEL(labelGen());
    if (node.else_exists) s2 = node.b2.ir;

    String lt = labelGen();
    String le = labelGen();

    // Not Optimized
    node.ir = new IRSeq(
      CJUMP(e, lt),
      s2,
      JUMP(NAME(le)),
      LABEL(lt),
      s1,
      LABEL(le)
    );
  }
  
  /**
   * Exit an IntLit node.
   * @param node the IntLit node to be exited.
   */
  public void exitIntLit(IntLit node) {
        node.ir = CONST(node.value);
  }
  
  /**
   * Exit a Len node.
   * @param node the Len node to be exited.
   */
  public void exitLen(Len node) {
    IRExpr e = node.e.ir;
    node.ir = MEM(SUB(e, CONST(8)));
  }
  
  /**
   * Exit a MethodCall node.
   * @param node the MethodCall node to be exited.
   */
  public void exitMethodCall(MethodCall node) {
    Identifier id = node.id;
    List<IRExpr> args = new ArrayList<>();
    for(int i = 0; i < node.arguments.size(); i++) {
      args.add(node.arguments.get(i).ir);
    }
    try{
      node.ir = new IRCall( 
        NAME(mangleFunctionName(id.id, (FunctionType)env.get(id))), args
      );
    } catch (Exception e) { /* Impossible by type checking */ }
  }
  
  /**
   * Exit a Method node.
   * @param node the Method node to be exited.
   */
  public void exitMethod(Method node) {
    String label = mangleFunctionName(node.id.id, node.t);

    List<IRStmt> stmts = new ArrayList<>();
    for (int i = 0; i < node.params.size(); i++) {
      Decl d = node.params.get(i);
      stmts.add(MOVE(TEMP(d.id.id), TEMP("_ARG" + i)));
    }
    stmts.add(node.body.ir);

    node.ir = new IRFuncDecl(label, new IRSeq(stmts));
  }
  
  /**
   * Exit a ProcedureCall node.
   * @param node the ProcedureCall node to be exited.
   */
  public void exitProcedureCall(ProcedureCall node) {
    Identifier id = node.id;
    List<IRExpr> args = new ArrayList<>();
    for(int i = 0; i < node.arguments.size(); i++) {
      args.add(node.arguments.get(i).ir);
    }
    try{
      node.ir = new IRCallStmt(
        NAME(mangleFunctionName(id.id, (FunctionType)env.get(id))), args
      );
    } catch (Exception e) { /* Impossible by type checking */ }
  }
  
  /**
   * Exit a Program node.
   * @param node the Program node to be exited.
   */
  public void exitProgram(Program node) {
    IRCompUnit prog = new IRCompUnit(this.filename);
    for(Method m : node.method_list) prog.appendFunc(m.ir);
    node.ir = prog;
  }
  
  /**
   * Exit a Return node.
   * @param node the Return node to be exited.
   */
  public void exitReturn(Return node) {
    List<IRExpr> rets = new ArrayList<>();
    for(int i = 0; i < node.l.size(); i++) {
      rets.add(node.l.get(i).ir);
    }
    node.ir = new IRReturn(rets);
  }
  
  /**
   * Exit a StrLit node.
   * @param node the StrLit node to be exited.
   */
  public void exitStrLit(StrLit node) {
    //similar to array literal
    String s = node.s;
    IRTemp tm = tempGen();
    List<IRStmt> stmts = new ArrayList<>();
    
    stmts.add(MOVE(tm, CALL(NAME(malloc), CONST(s.length() * 8 + 8))));
    stmts.add(MOVE(MEM(tm), CONST(s.length())));
    
    for(int i = 0; i < s.length(); i++) {
      long c = (long)s.charAt(i);
      stmts.add(MOVE(MEM(ADD(tm, CONST((i + 1) * 8))), CONST(c)));
    }
    
    node.ir = new IRESeq(new IRSeq(stmts), ADD(tm,CONST(8)));
  }
  
  /**
   * Exit an Unop node.
   * @param node the Unop node to be exited.
   */
  public void exitUnop(Unop node) {
    switch (node.op) {
      case NOT:
          node.ir = NOT(node.e.ir);
        break;
      case NEG:
          node.ir = MUL(node.e.ir, CONST(-1));
        break;
    }
  }
  
  /**
   * Exit a While node.
   * @param node the While node to be exited.
   */
  public void exitWhile(While node) {
    IRExpr e = node.e.ir;
    IRStmt s = node.block.ir;

    String lh = labelGen();
    String lt = labelGen();

    //not optimized
    node.ir = new IRSeq(
        LABEL(lh),
        CJUMP(NOT(e), lt),
        s, 
        JUMP(NAME(lh)),
        LABEL(lt)
      );
  }
  
  /**
   * Enter a Wildcard node.
   * @param node the Wildcard node to be entered.
   */
  public void enterWildcard(Wildcard node) {
    node.ir = tempGen();
  }
}
