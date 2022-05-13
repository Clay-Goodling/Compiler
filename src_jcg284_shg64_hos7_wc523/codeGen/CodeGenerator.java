package src_jcg284_shg64_hos7_wc523.codeGen;

import java.util.*;

import edu.cornell.cs.cs4120.xic.ir.*;
import edu.cornell.cs.cs4120.xic.ir.visit.IRVisitor;
import src_jcg284_shg64_hos7_wc523.cfg.AsmCFG;
import src_jcg284_shg64_hos7_wc523.optimizations.CopyProp;
import src_jcg284_shg64_hos7_wc523.optimizations.InterferenceGraph;
import src_jcg284_shg64_hos7_wc523.optimizations.LiveVar;
import src_jcg284_shg64_hos7_wc523.optimizations.LiveVarData;
import polyglot.util.Pair;

public class CodeGenerator extends IRVisitor {
  int tempState;
  int labelState;
  String outFileRoot;
  public boolean reg;
  public boolean mc;
  public boolean copy;
  public boolean dce;

  public CodeGenerator(String outFileRoot) {
    super(new IRNodeFactory_c());

    tempState = 0;
    labelState = 0;
    this.outFileRoot = outFileRoot;
    reg = false;
    mc = false;
    copy = false;
    dce = false;
  }

  public CodeGenerator(String outFileRoot, Set<String> optimizations) {
    super(new IRNodeFactory_c());

    tempState = 0;
    labelState = 0;
    this.outFileRoot = outFileRoot;
    if (optimizations.size() == 0){
      reg = true;
      mc = true;
      copy = true;
      dce = true;
    } else{
      reg = optimizations.contains("reg");
      mc = optimizations.contains("mc");
      copy = optimizations.contains("copy");
      dce = optimizations.contains("dce");
    }
  }

  /**
   * Generate a fresh temp.
   * 
   * @return a fresh temp.
   */
  public AsmTemp tempGen() {
    String result = "_t" + this.tempState;
    tempState++;
    return new AsmTemp(result);
  }

  /**
   * Generate a fresh label.
   * 
   * @return a fresh label.
   */
  private AsmLabel labelGen() {
    String result = ".L" + this.labelState;
    labelState++;
    return new AsmLabel(result);
  }

  @Override
  public IRNode visit(IRNode parent, IRNode n) {
    if (n instanceof IRBinOp)     return visit(parent, (IRBinOp) n);
    if (n instanceof IRCallStmt)  return visit(parent, (IRCallStmt) n);
    if (n instanceof IRCJump)     return visit(parent, (IRCJump) n);
    if (n instanceof IRCompUnit)  return visit(parent, (IRCompUnit) n);
    if (n instanceof IRConst)     return visit(parent, (IRConst) n);
    if (n instanceof IRFuncDecl)  return visit(parent, (IRFuncDecl) n);
    if (n instanceof IRJump)      return visit(parent, (IRJump) n);
    if (n instanceof IRLabel)     return visit(parent, (IRLabel) n);
    if (n instanceof IRMem)       return visit(parent, (IRMem) n);
    if (n instanceof IRMove)      return visit(parent, (IRMove) n);
    if (n instanceof IRName)      return visit(parent, (IRName) n);
    if (n instanceof IRReturn)    return visit(parent, (IRReturn) n);
    if (n instanceof IRSeq)       return visit(parent, (IRSeq) n);
    if (n instanceof IRTemp)      return visit(parent, (IRTemp) n);
    return super.visit(parent, n);
  }

  /**
   * Generate code for a Binop node, utilizing lea instructions for 
   * certain additions and subtractions
   * 
   * @param parent The parent node of the Binop
   * @param node   Binop node to be generated
   * @return node decorated with assembly
   */
  public IRNode visit(IRNode parent, IRBinOp node) {
    node.visitChildren(this);

    node.asm = new ArrayList<>();

    AsmTemp t = tempGen();
    AsmLabel l = labelGen();
    AsmRegister rdx = new AsmRegister("rdx");
    AsmRegister rax = new AsmRegister("rax");

    Tile[] addTiles = {
      new TileAMEPAEC(),
      new TileAAMEPEC(),
      new TileAAMEPCE()
    };

    int bestScore = 1;
    List<Assembly> bestAsm = null;
    AsmOp bestTarget = null;
    for (Tile tile : addTiles) {
      if (tile.matchIRTree(node, this) && tile.score > bestScore) {
        bestScore = tile.score;
        bestAsm = tile.asm;
        bestTarget = tile.asmTarget;
      }
    }

    if (bestScore > 1) {
      node.asm.addAll(bestAsm);
      node.asm.add(new AsmLea(t, (AsmMem)bestTarget));
      node.setAsmTarget(t);
      return node;
    }

    node.asm.addAll(((IRExpr_c) node.left()).asm);
    node.asm.addAll(((IRExpr_c) node.right()).asm);

    switch (node.opType()) {
    case ADD:
      node.asm.add(new AsmMove(t, node.left().getAsmTarget()));
      node.asm.add(new AsmBinop(
        AsmBinop.OpType.ADD, t, node.right().getAsmTarget()
      ));
      node.setAsmTarget(t);
      break;
    case SUB:
      node.asm.add(new AsmMove(t, node.left().getAsmTarget()));
      node.asm.add(new AsmBinop(
        AsmBinop.OpType.SUB, t, node.right().getAsmTarget()
      ));
      node.setAsmTarget(t);
      break;
    case MUL:
      node.asm.add(new AsmMove(t, node.left().getAsmTarget()));
      node.asm.add(new AsmBinop(
        AsmBinop.OpType.MUL, t, node.right().getAsmTarget()
      ));
      node.setAsmTarget(t);
      break;
    case AND:
      node.asm.add(new AsmMove(t, node.left().getAsmTarget()));
      node.asm.add(new AsmBinop(
        AsmBinop.OpType.AND, t, node.right().getAsmTarget()
      ));
      node.setAsmTarget(t);
      break;
    case OR:
      node.asm.add(new AsmMove(t, node.left().getAsmTarget()));
      node.asm.add(new AsmBinop(
        AsmBinop.OpType.OR, t, node.right().getAsmTarget()
      ));
      node.setAsmTarget(t);
      break;
    case XOR:
      node.asm.add(new AsmMove(t, node.left().getAsmTarget()));
      node.asm.add(new AsmBinop(
        AsmBinop.OpType.XOR, t, node.right().getAsmTarget()
      ));
      node.setAsmTarget(t);
      break;
    case LSHIFT:
      node.asm.add(new AsmMove(t, node.left().getAsmTarget()));
      node.asm.add(new AsmBinop(
        AsmBinop.OpType.LSHIFT, t, node.right().getAsmTarget()
      ));
      node.setAsmTarget(t);
      break;
    case RSHIFT:
      node.asm.add(new AsmMove(t, node.left().getAsmTarget()));
      node.asm.add(new AsmBinop(
        AsmBinop.OpType.RSHIFT, t, node.right().getAsmTarget()
      ));
      node.setAsmTarget(t);
      break;
    case ARSHIFT:
      node.asm.add(new AsmMove(t, node.left().getAsmTarget()));
      node.asm.add(new AsmBinop(
        AsmBinop.OpType.ARSHIFT, t, node.right().getAsmTarget()
      ));
      node.setAsmTarget(t);
      break;
    case HMUL:
      node.asm.add(new AsmMove(rax, node.left().getAsmTarget()));
      node.asm.add(new AsmUnop(
        AsmUnop.OpType.MUL, node.right().getAsmTarget()
      ));
      node.asm.add(new AsmMove(t, rdx));
      node.setAsmTarget(t);
      break;
    case DIV:
      node.asm.add(new AsmBinop(AsmBinop.OpType.XOR, rdx, rdx)); // zero rdx
      node.asm.add(new AsmMove(rax, node.left().getAsmTarget()));
      node.asm.add(new AsmUnop(
        AsmUnop.OpType.DIV, node.right().getAsmTarget()
      ));
      node.asm.add(new AsmMove(t, rax));
      node.setAsmTarget(t);
      break;
    case MOD:
      node.asm.add(new AsmBinop(AsmBinop.OpType.XOR, rdx, rdx)); // zero rdx
      node.asm.add(new AsmMove(rax, node.left().getAsmTarget()));
      node.asm.add(new AsmUnop(
        AsmUnop.OpType.DIV, node.right().getAsmTarget()
      ));
      node.asm.add(new AsmMove(t, rdx));
      node.setAsmTarget(t);
      break;
    case EQ:
      node.asm.add(new AsmMove(t, new AsmConst(1)));
      node.asm.add(new AsmCmp(
        node.left().getAsmTarget(), node.right().getAsmTarget()
      ));
      node.asm.add(new AsmJcc(AsmJcc.conds.EQ, l.name));
      node.asm.add(new AsmMove(t, new AsmConst(0)));
      node.asm.add(l);
      node.setAsmTarget(t);
      break;
    case NEQ:
      node.asm.add(new AsmMove(t, new AsmConst(1)));
      node.asm.add(new AsmCmp(
        node.left().getAsmTarget(), node.right().getAsmTarget()
      ));
      node.asm.add(new AsmJcc(AsmJcc.conds.NE, l.name));
      node.asm.add(new AsmMove(t, new AsmConst(0)));
      node.asm.add(l);
      node.setAsmTarget(t);
      break;
    case LT:
      node.asm.add(new AsmMove(t, new AsmConst(1)));
      node.asm.add(new AsmCmp(
        node.left().getAsmTarget(), node.right().getAsmTarget()
      ));
      node.asm.add(new AsmJcc(AsmJcc.conds.LT, l.name));
      node.asm.add(new AsmMove(t, new AsmConst(0)));
      node.asm.add(l);
      node.setAsmTarget(t);
      break;
    case ULT:
      node.asm.add(new AsmMove(t, new AsmConst(1)));
      node.asm.add(new AsmCmp(
        node.left().getAsmTarget(), node.right().getAsmTarget()
      ));
      node.asm.add(new AsmJcc(AsmJcc.conds.ULT, l.name));
      node.asm.add(new AsmMove(t, new AsmConst(0)));
      node.asm.add(l);
      node.setAsmTarget(t);
      break;
    case GT:
      node.asm.add(new AsmMove(t, new AsmConst(1)));
      node.asm.add(new AsmCmp(
        node.left().getAsmTarget(), node.right().getAsmTarget()
      ));
      node.asm.add(new AsmJcc(AsmJcc.conds.GT, l.name));
      node.asm.add(new AsmMove(t, new AsmConst(0)));
      node.asm.add(l);
      node.setAsmTarget(t);
      break;
    case LEQ:
      node.asm.add(new AsmMove(t, new AsmConst(1)));
      node.asm.add(new AsmCmp(
        node.left().getAsmTarget(), node.right().getAsmTarget()
      ));
      node.asm.add(new AsmJcc(AsmJcc.conds.LEQ, l.name));
      node.asm.add(new AsmMove(t, new AsmConst(0)));
      node.asm.add(l);
      node.setAsmTarget(t);
      break;
    case GEQ:
      node.asm.add(new AsmMove(t, new AsmConst(1)));
      node.asm.add(new AsmCmp(
        node.left().getAsmTarget(), node.right().getAsmTarget()
      ));
      node.asm.add(new AsmJcc(AsmJcc.conds.GEQ, l.name));
      node.asm.add(new AsmMove(t, new AsmConst(0)));
      node.asm.add(l);
      node.setAsmTarget(t);
      break;
    }
    return node;
  }

  // helper function to get number of return values
  private int getRetCount(String name) {
    if (name.equals("_xi_alloc")) return 1;
    if (name.equals("_xi_out_of_bounds")) return 0;

    String s = name.substring(name.lastIndexOf('_') + 1);
    // if return is a tuple
    if (s.charAt(0) == 't') {
      // parse out int of tuple
      for(int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if(c == 'a' || c == 'i' || c == 'b') {
          return Integer.parseInt(s.substring(1,i));
        }
      }
    } else if (s.charAt(0) == 'p') {// if procedure with no return
      return 0;
    } 
    return 1;
  }

  /**
   * Generate code for a CallStmt node
   * 
   * @param parent The parent node of the CallStmt
   * @param node   CallStmt node to be generated
   * @return node decorated with assembly
   */
  public IRNode visit(IRNode parent, IRCallStmt node) {
    node.visitChildren(this);

    AsmRegister[] argRegisters = {
      new AsmRegister("rdi"),
      new AsmRegister("rsi"),
      new AsmRegister("rdx"),
      new AsmRegister("rcx"),
      new AsmRegister("r8"),
      new AsmRegister("r9")
    };

    AsmRegister[] retRegisters = {
      new AsmRegister("rax"),
      new AsmRegister("rdx")
    };

    int nRets = getRetCount(((IRName)node.target()).name());

    List<IRExpr> args = new ArrayList<>();
    AsmTemp t = tempGen();
    if (nRets > 2) {
      IRName pointer = new IRName("Pointer"); // IRNode type is irrelevent

      pointer.asm = new ArrayList<>();
      pointer.asm.add(new AsmMove(t, new AsmRegister("rsp")));
      pointer.asm.add(new AsmBinop(AsmBinop.OpType.SUB, t, new AsmConst(8)));
      pointer.setAsmTarget(t);

      args.add(pointer);
    }
    
    args.addAll(node.args());
    int nArgs = args.size();
    
    node.asm = new ArrayList<>();
    for (IRExpr arg : args) {
      node.asm.addAll(((IRExpr_c)arg).asm);
    }

    // first six go into registers rdi, rsi, rdx, rcx, r8, and r9, in that order
    for(int i = 0; i < nArgs && i < 6; i++)
      node.asm.add(new AsmMove(argRegisters[i], args.get(i).getAsmTarget()));

    if (nRets > 2) {
      node.asm.add(new AsmBinop(
        AsmBinop.OpType.SUB,
        new AsmRegister("rsp"),
        new AsmConst((nRets - 2 + (nRets % 2)) * 8)
      ));
    }
    
    // If odd number of spilled args, push 0 to align 16
    if (nArgs >= 6 && nArgs % 2 == 1) {
      node.asm.add(new AsmPush(new AsmConst(0)));
    }
    // more than six go into stack in reverse order
    for(int i = nArgs-1; i >= 6; i--){
      node.asm.add(new AsmPush(args.get(i).getAsmTarget()));
    }
    // call f
    node.asm.add(new AsmCall(node.target().getAsmTarget()));
    // add rsp, 8 * (n - 6) if n > 6)
    if(nArgs > 6) {
      node.asm.add(new AsmBinop(AsmBinop.OpType.ADD,
        new AsmRegister("rsp"), new AsmConst(8 * (nArgs + (nArgs % 2) - 6))
      ));
    }
    
    // first two come from registers rax and rdx
    for(int i = 0; i < nRets && i < 2; i++) {
      node.asm.add(new AsmMove(new AsmTemp("_RET" + i), retRegisters[i]));
    }

    for(int i = 2; i < nRets; i++) {
      node.asm.add(new AsmMove(
        new AsmTemp("_RET" + i), new AsmMem(t, new AsmConst((i - 2) * 8))
      ));
    }

    return node;
  }

  /**
   * Generate code for a CJump node
   * 
   * @param parent The parent node of the CJump
   * @param node   CJump node to be generated
   * @return node decorated with assembly
   */
  public IRNode visit(IRNode parent, IRCJump node) {
    node.visitChildren(this);

    node.asm = new ArrayList<>();
    node.asm.addAll(((IRExpr_c) node.cond()).asm);
    node.asm.add(new AsmCmp(node.cond().getAsmTarget(), new AsmConst(0)));
    node.asm.add(new AsmJcc(AsmJcc.conds.NE, "." + node.trueLabel()));

    return node;
  }

  /**
   * Generate code for a CompUnit node
   * 
   * @param parent The parent node of the CompUnit; should always be null
   * @param node   CompUnit node to be generated
   * @return node decorated with assembly
   */
  public IRNode visit(IRNode parent, IRCompUnit node) {
    node.visitChildren(this);

    node.asm = new ArrayList<>();

    node.asm.add(new AsmDirective("intel_syntax", "noprefix"));

    for (IRFuncDecl f : node.functions().values()) {
      node.asm.addAll(f.asm);
    }

    return node;
  }

  /**
   * Generate code for a Const node
   * 
   * @param parent The parent node of the Const
   * @param node   Const node to be generated
   * @return node decorated with assembly
   */
  public IRNode visit(IRNode parent, IRConst node) {
    node.visitChildren(this);

    node.asm = new ArrayList<>();

    AsmTemp t = tempGen();
    node.asm.add(new AsmMove(t, new AsmConst(node.value())));
    node.setAsmTarget(t);

    return node;
  }

  // returns number of arguments from a mangled method name
  private int getArgCount(String name) {
    int count = 0;
    String s = name.substring(name.lastIndexOf('_') + 1);
    // if return is a tuple
    if (s.charAt(0) == 't') {
      // parse out int of tuple
      for(int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if(c == 'a' || c == 'i' || c == 'b') {
          count = -Integer.parseInt(s.substring(1,i));
          break;
        }
      }
    } else if (s.charAt(0) == 'p') {// if procedure with no return
      count = 0;
    } else { // if returns a single value
      count = -1;
    }
    // count every argument and return value
    for(char c : s.toCharArray()) {
      if (c == 'b' || c == 'i') count++; 
    }

    return count;
  }

  /**
   * Generate code for a FuncDecl node
   * 
   * @param parent The parent node of the FuncDecl
   * @param node   FuncDecl node to be generated
   * @return node decorated with assembly
   */
  public IRNode visit(IRNode parent, IRFuncDecl node) {
    node.visitChildren(this);
    int SPILL_OFFSET = 8;

    node.asm = new ArrayList<>();

    node.asm.add(new AsmDirective("text"));
    node.asm.add(new AsmDirective("globl", node.name()));
    node.asm.add(new AsmDirective("type", node.name(), "@function"));

    node.asm.add(new AsmLabel(node.name()));

    AsmRegister[] argRegisters = {
      new AsmRegister("rdi"),
      new AsmRegister("rsi"),
      new AsmRegister("rdx"),
      new AsmRegister("rcx"),
      new AsmRegister("r8"),
      new AsmRegister("r9")
    };

    AsmRegister[] spillRegisters = {
      new AsmRegister("r10"),
      new AsmRegister("r11"),
      new AsmRegister("r12")
    };

    AsmRegister[] tempRegisters = {
      new AsmRegister("r13"),
      new AsmRegister("r14"),
      new AsmRegister("r15"),
      new AsmRegister("rbx"),
    };

    node.asm.add(new AsmPush(new AsmRegister("rbp")));
    node.asm.add(new AsmPush(new AsmRegister("r12")));
    node.asm.add(new AsmPush(new AsmRegister("r13")));
    node.asm.add(new AsmPush(new AsmRegister("r14")));
    node.asm.add(new AsmPush(new AsmRegister("r15")));
    node.asm.add(new AsmPush(new AsmRegister("rbx")));


    int nArgs = getArgCount(node.name());
    int nRets = getRetCount(node.name());
    int argOffset = (nRets > 2) ? 1 : 0;

    if (nRets > 2) {
      node.asm.add(new AsmPush(argRegisters[0]));
    }

    node.asm.add(new AsmMove(new AsmRegister("rbp"), new AsmRegister("rsp")));
    int stackSizeUpdateIndex = node.asm.size();
    node.asm.add(new AsmComment("placeholder"));

    List<Assembly> body = new ArrayList<>();

    for (int i = argOffset; i < (nArgs + argOffset) && i < 6; i++) {
      body.add(new AsmMove(
        new AsmTemp("_ARG" + (i - argOffset)),
        argRegisters[i]
      ));
    }

    for (int i = 6; i < (nArgs + argOffset); i++) {
      body.add(new AsmMove(
        new AsmTemp("_ARG" + (i - argOffset)),
        new AsmMem(new AsmRegister("rbp"), new AsmConst((i - 6 + argOffset) * 8 + 56))
      ));
    }

    body.addAll(node.body().asm);

    // copy propagation
    if (copy) {
      boolean changed = true;
      while (changed) {
        changed = false;
        Pair<List<Assembly>, Boolean> copy_result = CopyProp.optimize(body);
        body = copy_result.part1();
        changed = copy_result.part2();
        if (dce) {
          Pair<List<Assembly>, Boolean> dce_result = LiveVar.deadCodeElimination(body);
          body = dce_result.part1();
          changed = changed || dce_result.part2();
        }
      }
    }

    // dead code elimination
    if (dce) body = LiveVar.deadCodeElimination(body).part1();

    if (!reg) { // naive register allocation (all on stack)
      HashMap<AsmTemp, Integer> tempSet = new HashMap<>();

      for (Assembly ins : body) {
        node.asm.addAll(ins.toConcrete(tempSet, spillRegisters, SPILL_OFFSET));
      }
      
      node.asm.set(stackSizeUpdateIndex, new AsmBinop(
        AsmBinop.OpType.SUB,
        new AsmRegister("rsp"),
        new AsmConst((tempSet.size()) * 8)
      ));
    } else { // fancy register allocation
      int k = tempRegisters.length;
      AsmCFG<LiveVarData> cfg = LiveVar.analyze(body);
      InterferenceGraph graph = new InterferenceGraph(cfg, mc);
      Map<AsmTemp, Integer> registerAllocation = graph.getColoring(k);

      for (Assembly asm : body) {
        for (Assembly ins : asm.toConcrete(registerAllocation, tempRegisters, spillRegisters, SPILL_OFFSET - 8 * k)) {
          if (!mc || !(ins instanceof AsmMove) || !((AsmMove)ins).src.equals(((AsmMove)ins).dest)) node.asm.add(ins);
        }
      }

      int spillCount = 0;
      try {
        spillCount = Collections.max(registerAllocation.values()) - k + 1;
      } catch (NoSuchElementException e) {/* no temps */}
      spillCount = spillCount > 0 ? spillCount : 0;

      node.asm.set(stackSizeUpdateIndex, new AsmBinop(
        AsmBinop.OpType.SUB,
        new AsmRegister("rsp"),
        new AsmConst(spillCount * 8)
      ));
    }
    
    node.asm.add(new AsmDirective("size", node.name(), ".-" + node.name()));
    return node;
  }
  

  /**
   * Generate code for a Jump node
   * 
   * @param parent The parent node of the Jump
   * @param node   Jump node to be generated
   * @return node decorated with assembly
   */
  public IRNode visit(IRNode parent, IRJump node) {
    node.visitChildren(this);

    node.asm = new ArrayList<>();
    node.asm.add(new AsmJump("." + ((IRName) node.target()).name()));

    return node;
  }

  /**
   * Generate code for a Label node
   * 
   * @param parent The parent node of the Label
   * @param node   Label node to be generated
   * @return node decorated with assembly
   */
  public IRNode visit(IRNode parent, IRLabel node) {
    node.visitChildren(this);

    node.asm = new ArrayList<>();
    node.asm.add(new AsmLabel("." + node.name()));

    return node;
  }

  /**
   * Generate code for a Mem node
   * 
   * @param parent The parent node of the Mem
   * @param node   Mem node to be generated
   * @return node decorated with assembly
   */
  public IRNode visit(IRNode parent, IRMem node) {
    node.visitChildren(this);

    node.asm = new ArrayList<>();

    Tile[] addTiles = {
      new TileAMEPAEC(),
      new TileAAMEPEC(),
      new TileAAMEPCE()
    };

    int bestScore = 0;
    List<Assembly> bestAsm = null;
    AsmOp bestTarget = null;
    for (Tile tile : addTiles) {
      if (tile.matchIRTree(node.expr(), this) && tile.score > bestScore) {
        bestScore = tile.score;
        bestAsm = tile.asm;
        bestTarget = tile.asmTarget;
      }
    }

    AsmMem mem;
    if (bestScore > 0) {
      node.asm.addAll(bestAsm);
      mem = (AsmMem)bestTarget;
    } else {
      node.asm.addAll(((IRExpr_c) node.expr()).asm);
      mem = new AsmMem((AsmTemp)node.expr().getAsmTarget());
    }

    if (((parent instanceof IRMove && ((IRMove)parent).source() == node) ||
        (parent instanceof IRBinOp && ((IRBinOp)parent).right() == node))) {
          AsmTemp t = tempGen();
          node.asm.add(new AsmMove(t, mem));
          node.setAsmTarget(t);
    } else {
      node.setAsmTarget(mem);
    }

    return node;
  }

  /**
   * Generate code for a Move node
   * 
   * @param parent The parent node of the Move
   * @param node   Move node to be generated
   * @return node decorated with assembly
   */
  public IRNode visit(IRNode parent, IRMove node) {
    node.visitChildren(this);

    node.asm = new ArrayList<>();

    node.asm.addAll(((IRExpr_c) node.source()).asm);
    node.asm.addAll(((IRExpr_c) node.target()).asm);
    if (!node.target().getAsmTarget().equals(node.source().getAsmTarget())) {
      node.asm.add(new AsmMove(
        node.target().getAsmTarget(), node.source().getAsmTarget()
      ));
    }

    return node;
  }

  /**
   * Generate code for a Name node
   * 
   * @param parent The parent node of the Name
   * @param node   Name node to be generated
   * @return node decorated with assembly
   */
  public IRNode visit(IRNode parent, IRName node) {
    node.visitChildren(this);

    node.asm = new ArrayList<>();
    node.setAsmTarget(new AsmName(node.name()));

    return node;
  }

  /**
   * Generate code for a Return node
   * 
   * @param parent The parent node of the Return
   * @param node   Return node to be generated
   * @return node decorated with assembly
   */
  public IRNode visit(IRNode parent, IRReturn node) {
    node.visitChildren(this);

    node.asm = new ArrayList<>();
    
    int n = node.rets().size();
    for (IRExpr ret : node.rets()) {
      node.asm.addAll(((IRExpr_c)ret).asm);
    }

    AsmRegister[] registers = {
      new AsmRegister("rax"),
      new AsmRegister("rdx")
    };

    // first two go into registers rax and rdx in that order
    for(int i = 0; i < n && i < 2; i++) {
      node.asm.add(new AsmMove(
        registers[i], node.rets().get(i).getAsmTarget()
      ));
    }
    
    node.asm.add(new AsmMove(new AsmRegister("rsp"), new AsmRegister("rbp")));

    if (n > 2) {
      AsmTemp t = tempGen();
      node.asm.add(new AsmPop(t));
    
      for(int i = 2; i < n; i++) {
        AsmOp src;
        if (node.rets().get(i).getAsmTarget() instanceof AsmMem) {
          AsmTemp t2 = tempGen();
          node.asm.add(new AsmMove(t2, node.rets().get(i).getAsmTarget()));
          src = t2;
        } else {
          src = node.rets().get(i).getAsmTarget();
        }

        node.asm.add(new AsmMove(new AsmMem(
          t, new AsmConst((i - 2) * 8)
        ), src));
      }
    }

    node.asm.add(new AsmPop(new AsmRegister("rbx")));
    node.asm.add(new AsmPop(new AsmRegister("r15")));
    node.asm.add(new AsmPop(new AsmRegister("r14")));
    node.asm.add(new AsmPop(new AsmRegister("r13")));
    node.asm.add(new AsmPop(new AsmRegister("r12")));
    node.asm.add(new AsmPop(new AsmRegister("rbp")));

    node.asm.add(new AsmRet());
    return node;
  }

  /**
   * Generate code for a Seq node
   * 
   * @param parent The parent node of the Seq
   * @param node   Seq node to be generated
   * @return node decorated with assembly
   */
  public IRNode visit(IRNode parent, IRSeq node) {
    node.visitChildren(this);

    node.asm = new ArrayList<>();
    for (IRStmt stmt : node.stmts()) {
      node.asm.addAll(stmt.asm);
    }

    return node;
  }

  /**
   * Generate code for a Temp node
   * 
   * @param parent The parent node of the Temp
   * @param node   Temp node to be generated
   * @return node decorated with assembly
   */
  public IRNode visit(IRNode parent, IRTemp node) {
    node.visitChildren(this);

    node.asm = new ArrayList<>();
    node.setAsmTarget(new AsmTemp(node.name()));

    return node;
  }

  public String pprint() {
    return "";
  }
}
