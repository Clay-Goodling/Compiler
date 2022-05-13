package src_jcg284_shg64_hos7_wc523.cfg;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edu.cornell.cs.cs4120.xic.ir.IRStmt;
import src_jcg284_shg64_hos7_wc523.optimizations.*;

public class IRCFGNode<D extends Data<D>> {
  public List<IRStmt> code;

  public String defaultEdgeID;
  public String trueEdgeID;
  public String falseEdgeID;

  public IRCFGNode<D> defaultEdge;
  public IRCFGNode<D> trueEdge;
  public IRCFGNode<D> falseEdge;

  public Set<IRCFGNode<D>> predecessors;
  public Set<IRCFGNode<D>> successors;

  public D data;

  public String id;
  public int idNum;

  int idState = -1;

  private int idGen(){
    idState++;
    return idState;
  }

  public IRCFGNode(){
    this.idNum = idGen();
  }

  public IRCFGNode(List<IRStmt> code, String id, D data) {
    this.code = code;
    this.id = id;
    this.predecessors = new HashSet<>();
    this.successors = new HashSet<>();
    this.data = data;
    this.idNum = idGen();
  }

  public IRCFGNode(List<IRStmt> code, String defaultEdge, String id, D data) {
    this(code, id, data);
    this.defaultEdgeID = defaultEdge;
    this.idNum = idGen();
  }

  public IRCFGNode(List<IRStmt> code, String trueEdge, String falseEdge, String id, D data) {
    this(code, id, data);
    this.trueEdgeID = trueEdge;
    this.falseEdgeID = falseEdge;
    this.idNum = idGen();
  }

  public String getBody() {
    String s = "";
    for (int i = 0; i < code.size(); i++) {
      s += code.get(i).toString();
    }
    return s;
  }

  public boolean equals(Object o) {
    try {
      IRCFGNode<D> target = (IRCFGNode<D>)o;
      return id.equals(target.id);
    } catch (ClassCastException e) {
      return false;
    }
  }
}
