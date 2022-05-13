package src_jcg284_shg64_hos7_wc523.typechecker;

import src_jcg284_shg64_hos7_wc523.ast.*;
import src_jcg284_shg64_hos7_wc523.ast.visitor.*;
import java.util.*;

public class SignatureScanner extends Visitor {
  Context env;

  public SignatureScanner() {
    env = new Context();
  }

  /**
   * Getter for the context generated by a scan.
   * @return the context.
   */
  public Context getContext() {
    return env;
  }

  /**
   * Scan the signature of a method interface.
   * @param node the method interface node to be scanned.
   */
  public void exitMethodInterface(MethodInterface node) throws Exception {
    try {
      // Check if the method interface has already been declared in this file. 
      env.get(node.id);
      throw new TypeException(String.format(
        "%s has already been declared.", node.id.toString()
      ), node.id.line, node.id.column);
    } catch (UnboundIdException e) {

      // Get the parameter types.
      List<Type> argtypes = new ArrayList<>();
      for (Decl arg : node.params) argtypes.add(arg.t);
      TypeList argtype = new TypeList(argtypes);
  
      // Create the return type.
      Type rettype;
      if (node.types.isEmpty()) rettype = new UnitType();
      else if (node.types.size() == 1) rettype = node.types.get(0);
      else rettype = new TypeList(node.types);
  
      // Create the functiontype to represent this method interface.
      FunctionType t = new FunctionType(argtype, rettype);

      // Bind the identifier to the functiontype in the context.
      env.bind(node.id, t);
    }
  }

  /**
   * Scan the signature of a method.
   * @param node the method node to be scanned.
   */
  public void exitMethod(Method node) throws Exception {
    try {
      // Check if the method has already been declared in this file. 
      env.get(node.id);
      throw new TypeException(String.format(
        "%s has already been declared.", node.id.toString()
      ), node.id.line, node.id.column);
    } catch (UnboundIdException e) {

      // Get the parameter types.
      List<Type> argtypes = new ArrayList<>();
      for (Decl arg : node.params) argtypes.add(arg.t);
      TypeList argtype = new TypeList(argtypes);
  
      // Create the return type.
      Type rettype;
      if (node.types.isEmpty()) rettype = new UnitType();
      else if (node.types.size() == 1) rettype = node.types.get(0);
      else rettype = new TypeList(node.types);
  
      // Create the functiontype to represent this method.
      FunctionType t = new FunctionType(argtype, rettype);

      // Bind the identifier to the functiontype in the context.
      env.bind(node.id, t);

      node.t = t;
    }
  }
}