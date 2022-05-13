package src_jcg284_shg64_hos7_wc523.typechecker;

import src_jcg284_shg64_hos7_wc523.ast.*;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;
import src_jcg284_shg64_hos7_wc523.lexer.*;
import src_jcg284_shg64_hos7_wc523.parser.*;
import java.util.*;
import java.io.*;

public class TypeChecker extends Visitor {
  Context env;
  String filename;
  String libpath;

  public TypeChecker() {
    this.env = new Context();
    this.filename = "";
    this.libpath = "";
  }

  public TypeChecker(Context c) { 
    this.env = c;
    this.filename = "";
    this.libpath = "";
  }
  
  public TypeChecker(Context c, String libpath) {
    this.env = c;
    this.filename = "";
    this.libpath = libpath;
  }

  public TypeChecker(Context c, String filename, String libpath) {
    this.env = c;
    this.filename = filename;
    this.libpath = libpath;
  }
  
  /**
   * Typecheck an array access.
   * @param node the array access node to be typechecked.
   * Invariant: the array and the index have been typechecked.
   */
  public void exitArrayAccess(ArrayAccess node) throws Exception {
    Expr array = node.array;
    Expr index = node.index;
    Type t1 = array.t;
    Type t2 = index.t;

    // Check the array has an array type.
    if (! (t1 instanceof ArrayType)) {
      throw new TypeException(String.format(
        "Expected Array type but got %s.", t1.toString()
      ), array.line, array.column);
    }

    // Check the index is an int.
    if (!(t2 instanceof IntType)){
      throw new TypeException(String.format(
        "Index must be an int but got %s.", t2.toString()
      ), index.line, index.column);
    }

    // Set the type of the access to the type of the contents of the array.
    node.t = ((ArrayType)t1).t;
  }

  /**
   * Typecheck an array initialization.
   * @param node the array access node to be typechecked.
   */
  public void exitArrayInit(ArrayInit node) throws TypeException {
    Identifier id = node.id;
    for (Expr i : node.sizes) {
      if (i != null && !(i.t instanceof IntType)) {
        throw new TypeException(String.format(
          "Expected int, got %s.", i.t.toString()
        ), i.line, i.column);
      }
    }

    // The type of a declaration is always unit.
    node.t = new UnitType();
    
    // Check that id hasn't already been bound.
    if (!env.bind(id, new ArrayType(node.type, node.sizes.size() - 1))){
      throw new TypeException(String.format(
        "%s has already been declared.", id.toString()
      ), id.line, id.column);
    }
  }
    

  /**
   * Typecheck an array literal.
   * @param node the array literal node to be typechecked.
   * Invariant: the elements of the array have been typechecked.
   */
  public void exitArrayLit(ArrayLit node) throws TypeException {
    List<Expr> values = node.values;

    if (values.size() == 0) {
      // If the array is empty, make it an array of voids.
      node.t = new ArrayType(new VoidType());
    } else {
      Type t = values.get(0).t;
      
      // Check all elements have that same type
      for (Expr e : values) {
        if (!e.t.equals(t)) {
          throw new TypeException(String.format(
            "Expected %s but got %s.", t.toString(), e.t.toString()
          ), e.line, e.column);
        }
      }

      // Make it an array of whatever the first element is.
      node.t = new ArrayType(values.get(0).t);
    }
  }

  /**
   * Typecheck an assignment.
   * @param node the assignment node to be typechecked.
   * Invariant: The assignees and expression have been typechecked.
   */
  public void exitAssignment(Assignment node) throws Exception {
    List<Assignee> assignees = node.assignees;
    Expr e = node.e;
    Type t = e.t;

    // Single assignment
    if (assignees.size() == 1) {
      Assignee x = assignees.get(0);

      // Ensure single assignment wildcards are only used with methods.
      if (x instanceof Wildcard && !(e instanceof MethodCall)) {
        throw new TypeException("Expected method call.", e.line, e.column);
      }

      // Check that t is not a typelist
      if (t instanceof TypeList) {
        throw new TypeException(
          "Expected 1 value, got multiple", e.line, e.column
        );
      }

      // Check e can be assigned to x.
      if (t.subtypeof(x.t)) {
        node.t = new UnitType();
        return;
      }
      throw new TypeException(String.format(
        "Cannot assign %s to %s.", t.toString(), x.t.toString()
      ), e.line, e.column);
    }

    // Multiple assignment. Check that t is a typelist.
    if (!(t instanceof TypeList)) {
      throw new TypeException(
        "Fewer values given than expected.", e.line, e.column);
    } 
    TypeList tl = (TypeList)t;

    // Create a typelist to hold the types of the assignees.
    List<Type> xts = new ArrayList<>();
    for (Assignee x : assignees) xts.add(x.t);
    TypeList xtl = new TypeList(xts);
    
    // Check the assignee types match the expression types.
    if (!tl.subtypeof(xtl)){
      throw new TypeException(String.format(
        "Expected %s but got %s.", tl.toString(), assignees.toString()
      ), e.line, e.column);
    }

    // Assignment is always of unit type.
    node.t = new UnitType();
  }
  
  /**
   * Typecheck a binary operation.
   * @param node the binary operation node to be typechecked.
   * Invariant: the operands have been typechecked.
   */
  public void exitBinop(Binop node) throws Exception {
    Expr e1 = node.e1;
    Expr e2 = node.e2;
    Type t1 = e1.t;
    Type t2 = e2.t;
    
    Binop.ops op = node.op;

    switch(op) {
      case PLUS:
        // Can't add bools to anything.
        if(t1 instanceof BoolType) {
          throw new TypeException(String.format(
            "Cannot add to bool."
          ), e1.line, e1.column);
        }
        // Otherwise just need the two operands to have the same type.
        if(t1.equals(t2)) {
          // Type of operation is same as that of operands.
          node.t = t1;
        } else {
          throw new TypeException(String.format(
            "Expected %s but got %s.", t1.toString(), t2.toString()
          ), e2.line, e2.column);
        }
        break;
        
      case MINUS: case TIMES: case UPPER: case DIVIDE: case MODULO:
        // Check first operand is int.
        if(!(t1 instanceof IntType)) {
          throw new TypeException(String.format(
            "Arithmetic operand must be an int but got %s.", t1.toString()
          ), e1.line, e1.column);
        }
        // Check second opperand is int.
        if (!(t2 instanceof IntType)) {
          throw new TypeException(String.format(
            "Arithmetic operand must be an int but got %s.", t2.toString()
          ), e2.line, e2.column);
        }
        // Type of operation is always int.
        node.t = new IntType();
        break;

      case EQ: case NEQ:
        // Check operands are the same type.
        if(t1.equals(t2)) {
          // Type of operation is always bool.
          node.t = new BoolType();
        } else {
          throw new TypeException(String.format(
            "Expected %s but got %s.", t1.toString(), t2.toString()
          ), e2.line, e2.column);
        }
        break;

      case LT: case LEQ: case GT: case GEQ:
        // Check first operand is int.
        if(!(t1 instanceof IntType)) {
          throw new TypeException(String.format(
            "Comparison operand must be an int but got %s.", t1.toString()
          ), e1.line, e1.column);
        }
        // Check second operand is int.
        if (!(t2 instanceof IntType)) {
          throw new TypeException(String.format(
            "Comparison operand must be an int but got %s.", t2.toString()
          ), e2.line, e2.column);
        }
        // Type of operation is always bool.
        node.t = new BoolType();
        break;

      case AND: case OR:
        // Check first operand is bool.
        if(!(t1 instanceof BoolType)) {
          throw new TypeException(String.format(
            "Logical operand must be a bool but got %s.", t1.toString()
          ), e1.line, e1.column);
        } 
        // Check second operand is bool.
        if (!(t2 instanceof BoolType)) {
          throw new TypeException(String.format(
            "Logical operand must be a bool but got %s.", t2.toString()
          ), e2.line, e2.column);
        }
        // Type of operation is always bool.
        node.t = new BoolType();
        break;

      default:
        // Should never happen.
        throw new Exception("Unknown binary operator.");
    }
  }

  /**
   * Start typechecking a new block.
   * @param node the block node to be typechecked.
   */
  public void enterBlock(Block node) throws Exception {
    // Push a new frame onto the context stack.
    env.push();
  }

  /**
   * Typecheck a block.
   * @param node the block node to be typechecked.
   * Invariant: Every statement in the block has been typechecked.
   */
  public void exitBlock(Block node) throws Exception {
    int size = node.statements.size();

    // If the block is empty, it has a unit type.
    if (size == 0) {
      node.t = new UnitType();
      return;
    }

    // Check that every non-final statement is of unit type.
    for (int i = 0; i < size - 1; i++) {
      Stmt s = node.statements.get(i);
      if (s.t instanceof VoidType)  {
        throw new TypeException(
          "void type statment must be last statement in block.",
          s.line, s.column
        );
      }
    }

    // The type of the block is the same as that of the last statement in it.
    node.t = node.statements.get(size - 1).t; 

    // Pop the frame off the context stack.
    env.pop();
  }

  /**
   * Typecheck a bool literal.
   * @param node the bool literal node to be typechecked.
   */
  public void exitBoolLit(BoolLit node) {
    // A bool literal always has type bool.
    node.t = new BoolType();
  }

  // public voidBreak(Break node) {}
  // public void exitBreak(Break node) {}
  
  /**
   * Typecheck a char literal.
   * @param node the char literal node to be typechecked.
   */
  public void exitCharLit(CharLit node) {
    // A char literal always has type int.
    node.t = new IntType();
  }
  
  /**
   * Typecheck a declaration.
   * @param node the declaration node to be typechecked.
   */
  public void exitDecl(Decl node) throws TypeException {
    Identifier id = node.id;
    Type t = node.t;

    // Check that id hasn't already been bound.
    if (!env.bind(id,t)){
      throw new TypeException(String.format(
        "%s has already been declared.", id.toString()
      ), id.line, id.column);
    }

    // The type of the declaration is just t.
    node.t = t;
  }

  /**
   * Typecheck a declaration as a statement.
   * @param node the declaration node to be typechecked.
   */
  public void exitDeclStmt(DeclStmt node) throws TypeException {
    Identifier id = node.id;
    Type t = node.t;

    // Check that id hasn't already been bound.
    if (!env.bind(id,t)){
      throw new TypeException(String.format(
        "%s has already been declared.", id.toString()
      ), id.line, id.column);
    }

    // The type of a declaration is always unit.
    node.t = new UnitType();
  }

  /**
   * Typecheck an identifier.
   * @param node the identifier node to be typechecked.
   */
  public void exitIdentifier(Identifier node) throws TypeException {
    try {
      // Get the type from the context.
      node.t = env.get(node);
    } catch (UnboundIdException e) {
      throw new TypeException(e.getMessage(), node.line, node.column);
    }
  }

  /**
   * Typecheck an if statement.
   * @param node the if statement node to be typechecked.
   * Invariant: the guard and branches have been typechecked.
   */
  public void exitIfStatement(IfStatement node) throws Exception {
    Expr e = node.e;
    Type t = e.t;
    
    // Check the guard is a bool.
    if(!(t instanceof BoolType)) {
      throw new TypeException(String.format(
            "Guard of an if statement must be bool, not %s.", t.toString()
          ), e.line, e.column);
    };
 
    if (!node.else_exists) {
      // If the else block is empty, the type is always unit.
      node.t = new UnitType();
    } else {
      // If there is an else block, the type is the lub of the
      // types of the branches.
      node.t = (node.b1.t instanceof UnitType || node.b2.t instanceof UnitType)
        ? new UnitType() : new VoidType();
    }
  }

  /**
   * Typecheck an int literal.
   * @param node the int node to be typechecked.
   */
  public void exitIntLit(IntLit node) {
    // The type of an int literal is always int.
    node.t = new IntType();
  }

  /**
   * Typecheck a call to the length builtin.
   * @param node the length node to be typechecked.
   * Invariant: the argument has already been typechecked.
   */
  public void exitLen(Len node) throws TypeException{
    Expr e = node.e;
    Type t = e.t;

    // Check the expressing is an array.
    if(!(t instanceof ArrayType)) {
      throw new TypeException(String.format(
        "Expected array but got %s.", t.toString()
      ), e.line, e.column);
    }

    // The length will always be an int.
    node.t = new IntType();
  }

  /**
   * Begin typechecking a method.
   * @param node the method node to be typechecked.
   */
  public void enterMethod(Method node) throws Exception {
    // Push a new context frame to hold the parameters.
    env.push();
    // Set the return type of the function.
    env.setRho(node.types);
  }

  /**
   * Typecheck a method.
   * @param node the method node to be typechecked.
   * Invariant: the method's signature is already in the environment and the
   * body and parameters have already been typechecked.
   */
  public void exitMethod(Method node) throws Exception {
    Block body = node.body;
    FunctionType t = (FunctionType)env.get(node.id);
    Type rettype = t.ret;

    // Check that the body returns a value if it needs to.
    if (!(body.t.subtypeof(rettype))) {
      throw new TypeException(String.format(
        "Method %s must return a %s.", node.id, rettype
      ), node.id.line, node.id.column);
    }

    // Pop the parameter frame off the context stack.
    env.pop();
  }

  /**
   * Typecheck a method call.
   * @param node the call node to be typechecked.
   * Invariant: the arguments have already been typechecked.
   */
  public void exitMethodCall(MethodCall node) throws TypeException {
    FunctionType t;
    try {
      // Get the type of the method from the context.
      Type t1 = env.get(node.id);
      if (!(t1 instanceof FunctionType)) {
        throw new TypeException(String.format(
          "%s is not callable.", t1.toString()
        ), node.line, node.column);
      }
      t = (FunctionType)t1;
    } catch (UnboundIdException e) {
      throw new TypeException(e.getMessage(), node.line, node.column);
    }
    
    List<Expr> args = node.arguments;
    List<Type> argtypes = t.args.types;

    // Check the call passes the correct number of arguments.
    if (args.size() != argtypes.size()) {
      throw new TypeException(
        "Mismatched number of parameters.", 
        node.line, node.column
      );
    }

    // Check each argument is the correct type.
    for (int i = 0; i < args.size(); i++) {
      Expr arg = args.get(i);
      Type argt = argtypes.get(i);
      if (!(argt.subtypeof(arg.t))) {
        throw new TypeException(String.format(
          "Expected %s but got %s.", argt, arg.t
        ), arg.line, arg.column);
      }
    }
    
    // The call has the return type of the method.
    node.t = t.ret;
  }

  /**
   * Typecheck a procedure call.
   * @param node the call node to be typechecked.
   * Invariant: the arguments have already been typechecked.
   */
  public void exitProcedureCall(ProcedureCall node) throws TypeException {
    FunctionType t;
    try {
      // Get the type of the procedure from the context.
      Type t1 = env.get(node.id);
      if (!(t1 instanceof FunctionType)) {
        throw new TypeException(String.format(
          "%s is not callable.", t1.toString()
        ), node.line, node.column);
      }
      t = (FunctionType)t1;
    } catch (UnboundIdException e) {
      throw new TypeException(e.getMessage(), node.line, node.column);
    }
    
    // Check that the procedure does not return.
    if (!(t.ret instanceof UnitType)){
      throw new TypeException(String.format(
        "%s is not a procedure.", t.toString()
      ), node.line, node.column);
    }

    List<Expr> args = node.arguments;
    List<Type> argtypes = t.args.types;

    // Check the call passes the correct number of arguments.
    if (args.size() != argtypes.size()) {
      throw new TypeException(
        "Mismatched number of parameters.", 
        node.line, node.column
      );
    }

    // Check each argument is of the correct type.
    for (int i = 0; i < args.size(); i++) {
      Expr arg = args.get(i);
      Type argt = argtypes.get(i);
      if (!(argt.subtypeof(arg.t))) {
        throw new TypeException(String.format(
          "Expected %s but got %s.", argt, arg.t
        ), arg.line, arg.column);
      }
    }
    
    // The return type of a procedure call is always unit.
    node.t = new UnitType();
  }

  /**
   * Typecheck a return statement.
   * @param node the return statement node to be typechecked.
   * Invariant: each of the returned expressions has been typechecked.
   */
  public void exitReturn(Return node) throws TypeException {
    List<Expr> l = node.l;
    List<Type> rho = env.getRho();

    // Check the statement returns the correct number of results.
    if (rho.size() != l.size()) {
      throw new TypeException("Mismatched number of return values.",
                              node.line, node.column);
    }

    // Check each result is of the correct type.
    for (int i = 0; i < l.size(); i++) {
      Expr e = l.get(i);
      Type t = rho.get(i);
      if (!(t.equals(e.t))) {
        throw new TypeException(String.format(
          "Expected %s but got %s.", t, e.t
        ), e.line, e.column);
      }
    }

    // The type of return is always void.
    node.t = new VoidType();
  }

  /**
   * Typecheck a string literal.
   * @param node the string node to be typechecked.
   */
  public void exitStrLit(StrLit node) {
    // The type of a string is always int[].
    node.t = new ArrayType(new IntType());
  }

  /**
   * Typecheck a unary operation.
   * @param node the operation node to be typechecked.
   * Invariant: the operand has been typechecked.
   */
  public void exitUnop(Unop node) throws TypeException {
    Expr e = node.e;
    Type t = e.t;
    
    // Check the operand is of the correct type.
    if ((t instanceof IntType && node.op == Unop.ops.NEG) ||
        (t instanceof BoolType && node.op == Unop.ops.NOT)) {
      // Both unary operators preserve the type of their operand.
      node.t = t;
    } else {
      throw new TypeException(String.format(
        "Expected %s but got %s.", (node.op == Unop.ops.NEG ? "int" : "bool"), t.toString()
      ), e.line, e.column);
    }
  }

  /**
   * Typecheck a use statement.
   * @param node the use statement node to be typechecked.
   */
  public void exitUse(Use node) throws Exception {
    String interfacename = node.id.id;

    // Create a lexer for the interface being used.
    MyLexer lexer;
    try {
      lexer = new MyLexer(new InputStreamReader(
            new FileInputStream(libpath + interfacename + ".ixi")));
    } catch (FileNotFoundException e) {
      throw new TypeException(
        "File " + libpath + interfacename + ".ixi does not exist.",
        node.id.line, node.id.column
      );
    }

    // Create a parser for the interface being used.
    parser p = new parser(new LexerWrapper(null, lexer, ".ixi"));

    try {
      // Parse the interface file into an ast.
      Node ast = p.parse().value();

      // Extract the signatures from the interface into a context.
      SignatureScanner sig = new SignatureScanner();
      ast.accept(sig);
      Context new_env = sig.getContext();

      if (filename.equals(interfacename)) {
        // Check the signatures in the interface are all implemented.
        env.matchInterface(new_env);
      } else {
        // Update the context with the signatures from the interface.
        env.update(new_env);
      }
    } catch (Exception e) {
      throw new TypeException(String.format(
        "Invalid interface file %s.", libpath + interfacename + ".ixi" 
      ), node.id.line, node.id.column);
    }
  }

  /**
   * Typecheck a while statement.
   * @param node the while node to be typechecked.
   * Invariant: the guard and the body have been typechecked.
   */
  public void exitWhile(While node) throws Exception {
    Expr e = node.e;
    Type t = e.t;

    // CHeck the guard is a bool.
    if(!(t instanceof BoolType)) {
      throw new TypeException(String.format(
        "Guard of a while statement must be bool, got %s.", t.toString()
      ), e.line, e.column);
    }

    // The type of a while loop is always unit.
    node.t = new UnitType();
  }
  
  /**
   * Typecheck a wildcard.
   * @param node the wildcard node to be typechecked.
   */
  public void exitWildcard(Wildcard node) {
    // The type of a wildcard is always unit.
    node.t = new UnitType();
  }
}
