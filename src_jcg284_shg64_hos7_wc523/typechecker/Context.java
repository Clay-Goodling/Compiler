package src_jcg284_shg64_hos7_wc523.typechecker;

import java.util.*;
import src_jcg284_shg64_hos7_wc523.ast.*;

public class Context {
  private LinkedList<Map<String, Type>> context;
  private List<Type> rho;

  public Context() {
    context = new LinkedList<>();
    Map<String, Type> global = new Hashtable<>();
    context.addFirst(global);

    rho = new ArrayList<>();
  }

  /**
   * Push a new context frame onto the stace. 
   */
  public void push() {
    context.addFirst(new Hashtable<>());
  }

  /**
   * Pop a context frame off the stack, clearing all bindings set since the
   * matching push.
   * @throws Exception when trying to pop a frame which has not been pushed.
   */
  public void pop() throws Exception {
    if (context.size() == 0) {
      throw new Exception("Cannot pop out of global scope.");
    }
    context.removeFirst();
  }

  /**
   * Bind the identifier x to the type t in the local context.
   * @param x The identifier to be bound.
   * @param t The type to be bound.
   * @return True if the binding was successful, false if x is already bound.
   */
  public boolean bind(Identifier x, Type t) {
    String id = x.id;
    try {
      get(x);
      return false;
    } catch (UnboundIdException e) {
      context.getFirst().put(id, t);
    }
    return true;
  }
  
  /**
   * Get the type bound to x in the local context.
   * @param x The identifier whose type is being queried.
   * @return The type of x in the local context.
   * @throws UnboundIdException when x is not bound in the context.
   */
  public Type get(Identifier x) throws UnboundIdException {
    String id = x.id;
    for (Map<String, Type> scope : context) {
      Type t = scope.get(id);
      if (t != null) return t;
    }
    throw new UnboundIdException("Unbound identifier: " + id);
  }

  /**
   * Set the return type of the current function.
   * @param t tye return type.
   */
  public void setRho(List<Type> t) {
    rho = t;
  }

  /**
   * Get the return type of the current function.
   * @return the return type of the current function.
   */
  public List<Type> getRho() {
    return rho;
  }

  /**
   * Getter for the list of maps representing the context.
   * @return The list of maps representing the context.
   */
  private LinkedList<Map<String, Type>> getContext() {
    return context;
  }

  /**
   * Update the context with all the bindings in a new context,
   * ignoring those which have already been bound so long as their type matches.
   * @param new_env The context with which to update.
   * @throws BoundIdException When a binding in the new context doesn't match 
   * the binding in this context.
   */
  public void update(Context new_env) throws BoundIdException {
    for (Map<String, Type> table : new_env.getContext()) {
      for (Map.Entry<String, Type> binding : table.entrySet()) {
        Identifier id = new Identifier(binding.getKey(), 0, 0);
        Type type = binding.getValue();
        try {
          if (!get(id).equals(type)) {
            throw new BoundIdException(id.id + " is already bound.");
          }
        } catch (UnboundIdException e) {
          bind(id, type);
        }
      }
    }
  }

  /**
   * Check that the file for which this is a top level context implements all
   * functions required by its interface.
   * @param new_env The context representing the interface.
   * @throws UnboundIdException When the file fails to implement or
   * incorrectly implements a function in the interface.
   */
  public void matchInterface(Context new_env) throws UnboundIdException {
    for (Map<String, Type> table : new_env.getContext()) {
      for (Map.Entry<String, Type> binding : table.entrySet()) {
        Identifier id = new Identifier(binding.getKey(), 0, 0);
        Type type = binding.getValue();
        if (!get(id).equals(type)) {
          throw new UnboundIdException(String.format(
            "%s does not match its required signature.", id.id
          ));
        }
      }
    }
  }
}

class UnboundIdException extends Exception {
  String message;

  public UnboundIdException(String msg){      
    this.message = msg;
  }

  public String getMessage() {
    return message;
  }
}

class BoundIdException extends Exception {
  String message;

  public BoundIdException(String msg){      
    this.message = msg;
  }

  public String getMessage() {
    return message;
  }
}