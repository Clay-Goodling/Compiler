package src_jcg284_shg64_hos7_wc523.ir;

import edu.cornell.cs.cs4120.xic.ir.visit.IRVisitor;
import edu.cornell.cs.cs4120.xic.ir.*;

import java.util.*;

public class LowerIR extends IRVisitor {

  public long tempState;

  public LowerIR(long tempState) {
    super(new IRNodeFactory_c());
    this.tempState = tempState;
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

  @Override
  public IRNode visit(IRNode parent, IRNode n){
    if (n instanceof IRBinOp)    return visit(parent, (IRBinOp)    n);
    if (n instanceof IRCall)     return visit(parent, (IRCall)     n);
    if (n instanceof IRCallStmt) return visit(parent, (IRCallStmt) n);
    if (n instanceof IRCJump)    return visit(parent, (IRCJump)    n);
    if (n instanceof IRCompUnit) return visit(parent, (IRCompUnit) n);
    if (n instanceof IRConst)    return visit(parent, (IRConst)    n);
    if (n instanceof IRESeq)     return visit(parent, (IRESeq)     n);
    if (n instanceof IRExp)      return visit(parent, (IRExp)      n);
    if (n instanceof IRFuncDecl) return visit(parent, (IRFuncDecl) n);
    if (n instanceof IRJump)     return visit(parent, (IRJump)     n);
    if (n instanceof IRLabel)    return visit(parent, (IRLabel)    n);
    if (n instanceof IRMem)      return visit(parent, (IRMem)      n);
    if (n instanceof IRMove)     return visit(parent, (IRMove)     n);
    if (n instanceof IRName)     return visit(parent, (IRName)     n);
    if (n instanceof IRReturn)   return visit(parent, (IRReturn)   n);
    if (n instanceof IRSeq)      return visit(parent, (IRSeq)      n);
    if (n instanceof IRTemp)     return visit(parent, (IRTemp)     n);
    return super.visit(parent, n);
  }

  /**
   * Lower a Binop node
   * @param parent The parent node of the Binop
   * @param node Binop node to be lowered
   * @return ESeq of statements and Binop node with no side effects
   */
  public IRExpr visit(IRNode parent, IRBinOp node) {
    IRBinOp lowered = (IRBinOp)node.visitChildren(this);
    IRESeq left = (IRESeq)lowered.left();
    IRESeq right = (IRESeq)lowered.right();
    IRExpr e1 = left.expr();
    IRExpr e2 = right.expr();
    IRStmt s1 = left.stmt();
    IRStmt s2 = right.stmt();

    GetAssigned assignedVisitor = new GetAssigned();
    GetUsed usedVisitor = new GetUsed();

    assignedVisitor.visit(s2);
    usedVisitor.visit(e1);
    

    if (
      (!(assignedVisitor.memAssign || usedVisitor.memUse)) && 
      Collections.disjoint(assignedVisitor.assigned, usedVisitor.used)
    ) {
      return new IRESeq(new IRSeq(s1, s2), new IRBinOp(node.opType(), e1, e2));
    }

    List<IRStmt> se_list = new ArrayList<>();
    
    //left side effects
    se_list.add(s1);

    //store left expression in temp
    IRTemp t = tempGen();
    se_list.add(new IRMove(t, e1));
  
    //right side effects
    se_list.add(s2);

    //op
    IRBinOp op = new IRBinOp(node.opType(), t, e2);
    
    return new IRESeq(new IRSeq(se_list), op);
  }

  /**
   * Lower a Call node
   * @param parent The parent node of the Call
   * @param node Call node to be lowered
   * @return ESeq of statements and Call node with no side effects
   */
  public IRExpr visit(IRNode parent, IRCall node) {
    IRCall lowered = (IRCall)node.visitChildren(this);
    List<IRStmt> se_list = new ArrayList<>();
    List<IRExpr> args = new ArrayList<>();
    
    //target
    IRESeq target = (IRESeq)lowered.target();
    se_list.add(target.stmt());
    
    //args
    for(IRExpr e : lowered.args()) {
      IRTemp t1 = tempGen();
      se_list.add(((IRESeq)e).stmt());
      se_list.add(new IRMove(t1, ((IRESeq)e).expr()));
      args.add(t1);
    }
    se_list.add(new IRCallStmt(target.expr(), args));

    IRTemp t = tempGen();
    se_list.add(new IRMove(t, new IRTemp("_RET0")));
    
    return new IRESeq(new IRSeq(se_list), t);
  }

  /**
   * Lower a CallStmt node
   * @param parent The parent node of the CallStmt
   * @param node CallStmt node to be lowered
   * @return Seq of statements and CallStmt node with no side effects
   */
  public IRStmt visit(IRNode parent, IRCallStmt node) {
    IRCallStmt lowered = (IRCallStmt)node.visitChildren(this);
    List<IRStmt> se_list = new ArrayList<>();
    List<IRExpr> args = new ArrayList<>();
    
    //target
    IRESeq target = (IRESeq)lowered.target();
    se_list.add(target.stmt());
    
    //args
    for(IRExpr e : lowered.args()) {
      IRTemp t1 = tempGen();
      se_list.add(((IRESeq)e).stmt());
      se_list.add(new IRMove(t1, ((IRESeq)e).expr()));
      args.add(t1);
    }
    
    se_list.add(new IRCallStmt(target.expr(), args));

    return new IRSeq(se_list);
  }

  /**
   * Lower a CJump node
   * @param parent The parent node of the CJump
   * @param node CJump node to be lowered
   * @return Seq of statements and CJump node with no side effects
   */
  public IRStmt visit(IRNode parent, IRCJump node) {
    // get lowered jump condition as eseq containing side effects, then cond
    IRESeq cond = (IRESeq)((IRCJump)node.visitChildren(this)).cond();
    // extract side effects
    IRStmt target_se = cond.stmt();
    // create a new side effect of jumping
    IRCJump new_se = new IRCJump(
      cond.expr(), node.trueLabel(), node.falseLabel()
    );
    // return a seq of the side effects
    return new IRSeq(target_se, new_se);
  }

  /**
   * Lower a CompUnit node
   * @param parent The parent node of the CompUnit; should always be null
   * @param node CompUnit node to be lowered
   * @return Seq of statements and CompUnit node with no side effects
   */
  public IRNode visit(IRNode parent, IRCompUnit node) {
    return node.visitChildren(this);
  }

  /**
   * Lower a Const node
   * @param parent The parent node of the Const
   * @param node Const node to be lowered
   * @return node
   */
  public IRExpr visit(IRNode parent, IRConst node) {
    return new IRESeq(new IRSeq(), node);
  }

  /**
   * Lower a Data node
   * @param parent The parent node of the Data
   * @param node Data node to be lowered
   * @return node
   */
  public IRData visit(IRNode parent, IRData node) {
    return node;
  }

  /**
   * Lower a ESeq node
   * @param parent The parent node of the ESeq
   * @param node ESeq node to be lowered
   * @return ESeq of statements and the expression of the ESeq node
   */
  public IRExpr visit(IRNode parent, IRESeq node) {
    IRESeq lowered = (IRESeq)node.visitChildren(this);
    IRESeq expr = (IRESeq)lowered.expr();

    return new IRESeq(new IRSeq(lowered.stmt(), expr.stmt()), expr.expr());
  }

  public IRStmt visit(IRNode parent, IRExp node) {
    IRESeq lowered = (IRESeq)((IRExp)node.visitChildren(this)).expr();
    IRStmt se = lowered.stmt();

    return se;
  }

  /**
   * Lower a FuncDecl node
   * @param parent The parent node of the FuncDecl
   * @param node FuncDecl node to be lowered
   * @return node with all of its children lowered
   */
  public IRNode visit(IRNode parent, IRFuncDecl node) {
    return node.visitChildren(this);
  }

  /**
   * Lower a Jump node
   * @param parent The parent node of the Jump
   * @param node Jump node to be lowered
   * @return Seq of statements and Jump node with no side effects
   */
  public IRStmt visit(IRNode parent, IRJump node) {
    // get lowered jump target as eseq containing side effects, then target
    IRESeq target = (IRESeq)((IRJump)node.visitChildren(this)).target();
    // extract side effects
    IRStmt target_se = target.stmt();
    // add the side effect of jumping to the list of side effects
    IRJump new_se = new IRJump(target.expr());
    // return a seq of the side effects
    return new IRSeq(target_se, new_se);
  }  

  /**
   * Lower a Label node
   * @param parent The parent node of the Label
   * @param node Label node to be lowered
   * @return node
   */
  public IRStmt visit(IRNode parent, IRLabel node) {
    return node;
  }

  /**
   * Lower a Mem node
   * @param parent The parent node of the Mem
   * @param node Mem node to be lowered
   * @return ESeq of statements and Mem node with no side effects
   */
  public IRExpr visit(IRNode parent, IRMem node) {
    IRESeq address = (IRESeq)((IRMem)node.visitChildren(this)).expr();
    return new IRESeq(address.stmt(), new IRMem(address.expr()));
  }


  public IRStmt visit(IRNode parent, IRMove node) {
    IRMove lowered = (IRMove)node.visitChildren(this);
    List<IRStmt> se_list = new ArrayList<>();
    
    IRESeq target = (IRESeq)lowered.target();
    IRESeq source = (IRESeq)lowered.source();
    
    if (target.expr() instanceof IRTemp){
      se_list.add(source.stmt());
      se_list.add(new IRMove(target.expr(), source.expr()));
    }
    //if the destination is defined by an IRMem expression
    else {
      IRMem target_mem = (IRMem)target.expr();

      GetAssigned assignedVisitor = new GetAssigned();
      GetUsed usedVisitor = new GetUsed();

      assignedVisitor.visit(source.stmt());
      usedVisitor.visit(target_mem.expr());

      if (
        (!(assignedVisitor.memAssign && usedVisitor.memUse)) && 
        Collections.disjoint(assignedVisitor.assigned, usedVisitor.used)
      ) {
        se_list.add(target.stmt());
        se_list.add(source.stmt());
        se_list.add(new IRMove(target_mem, source.expr()));
      } else {
        IRTemp t = tempGen();
        se_list.add(target.stmt());
        se_list.add(new IRMove(t, target_mem.expr()));
        
        se_list.add(source.stmt());
        se_list.add(new IRMove(new IRMem(t), source.expr()));
      }
      
    }

    return new IRSeq(se_list);
  }

  /**
   * Lower a Name node
   * @param parent The parent node of the Name
   * @param node Name node to be lowered
   * @return ESeq of statements and Name node with no side effects
   */
  public IRExpr visit(IRNode parent, IRName node) {
    return new IRESeq(new IRSeq(), node);
  }         

  /**
   * Lower a Return node
   * @param parent The parent node of the Return
   * @param node Return node to be lowered
   * @return Seq of statements and Return node with no side effects
   */
  public IRStmt visit(IRNode parent, IRReturn node) {
    IRReturn lowered = (IRReturn)node.visitChildren(this);
    List<IRStmt> se_list = new ArrayList<>();
    List<IRExpr> ret_values = new ArrayList<>();
    for (IRExpr e : lowered.rets()){
      se_list.add(((IRESeq)e).stmt());
      ret_values.add(((IRESeq)e).expr());
    }
    se_list.add(new IRReturn(ret_values));
    
    return new IRSeq(se_list);
  }

  /**
   * Lower a Seq node
   * @param parent The parent node of the Seq
   * @param node Seq node to be lowered
   * @return Seq of statements
   */
  public IRStmt visit(IRNode parent, IRSeq node) {
    return (IRStmt)node.visitChildren(this);
  } 

  /**
   * Lower a Temp node
   * @param parent The parent node of the Temp
   * @param node Temp node to be lowered
   * @return ESeq of statements and Temp node with no side effects
   */
  public IRExpr visit(IRNode parent, IRTemp node) {
    return new IRESeq(new IRSeq(), node);
  }
}
