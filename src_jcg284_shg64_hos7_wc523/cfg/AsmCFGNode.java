package src_jcg284_shg64_hos7_wc523.cfg;

import java.util.HashSet;
import java.util.Set;

import src_jcg284_shg64_hos7_wc523.codeGen.Assembly;
import src_jcg284_shg64_hos7_wc523.optimizations.*;

public class AsmCFGNode<D extends Data<D>> {
  public Assembly code;

  public String defaultEdgeID;
  public String trueEdgeID;
  public String falseEdgeID;

  public AsmCFGNode<D> defaultEdge;
  public AsmCFGNode<D> trueEdge;
  public AsmCFGNode<D> falseEdge;

  public Set<AsmCFGNode<D>> predecessors;
  public Set<AsmCFGNode<D>> successors;

  public D data;

  public String id;

  public AsmCFGNode(Assembly code, String id, D data) {
    this.code = code;
    this.id = id;
    this.predecessors = new HashSet<>();
    this.successors = new HashSet<>();
    this.data = data;
  }

  public AsmCFGNode(Assembly code, String defaultEdge, String id, D data) {
    this(code, id, data);
    this.defaultEdgeID = defaultEdge;
  }

  public AsmCFGNode(Assembly code, String trueEdge, String falseEdge, String id, D data) {
    this(code, id, data);
    this.trueEdgeID = trueEdge;
    this.falseEdgeID = falseEdge;
  }

  public String getBody() {
    return code.toString();
  }
}
