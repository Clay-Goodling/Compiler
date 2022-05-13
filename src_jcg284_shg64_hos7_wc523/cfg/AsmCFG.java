package src_jcg284_shg64_hos7_wc523.cfg;

import java.io.*;
import java.util.*;
import src_jcg284_shg64_hos7_wc523.codeGen.*;
import src_jcg284_shg64_hos7_wc523.optimizations.*;

public class AsmCFG<D extends Data<D>> {
  
  public List<AsmCFGNode<D>> nodes;
  public String functionName;

  public static long labelState = 0;
  public static String labelGen() {
    return "_cfg_label" + labelState++;
  }

  public AsmCFG(List<Assembly> asm, D initialData) {

    String blockID = "start";
    nodes = new ArrayList<>();

    for (int i = 0; i < asm.size() - 1; i++) {
      Assembly stmt = asm.get(i);
      Assembly nextStmt = asm.get(i + 1);
      String nextBlockID;
      if (nextStmt instanceof AsmLabel) {
        nextBlockID = ((AsmLabel)nextStmt).name.replace(".", "dot");
      } else {
        nextBlockID = labelGen();
      }

      if (stmt instanceof AsmJump) {
        AsmJump jump = (AsmJump)stmt;
        nodes.add(new AsmCFGNode<D>(jump, jump.label.replace(".", "dot"), blockID, initialData));
      } else if (stmt instanceof AsmJcc) {
        AsmJcc jump = (AsmJcc)stmt;
        nodes.add(new AsmCFGNode<D>(jump, jump.target.replace(".", "dot"), nextBlockID, blockID, initialData));
      } else if (stmt instanceof AsmRet) {
        AsmRet ret = (AsmRet)stmt;
        nodes.add(new AsmCFGNode<D>(ret, blockID, initialData));
      } else {
        nodes.add(new AsmCFGNode<D>(stmt, nextBlockID, blockID, initialData));
      }
      blockID = nextBlockID;
    }
    nodes.add(new AsmCFGNode<D>(asm.get(asm.size() - 1), blockID, initialData));

    Map<String, AsmCFGNode<D>> map = new HashMap<>();
    for (AsmCFGNode<D> node : nodes) {
      map.put(node.id, node);
    }

    for (AsmCFGNode<D> node : nodes) {
      if (node.defaultEdgeID != null) {
        node.defaultEdge = map.get(node.defaultEdgeID);
        node.defaultEdge.predecessors.add(node);
        node.successors.add(node.defaultEdge);
      }
      if (node.falseEdgeID != null) {
        node.falseEdge = map.get(node.falseEdgeID);
        node.falseEdge.predecessors.add(node);
        node.successors.add(node.falseEdge);
      }
      if (node.trueEdgeID != null) {
        node.trueEdge = map.get(node.trueEdgeID);
        node.trueEdge.predecessors.add(node);
        node.successors.add(node.trueEdge);
      }
    }
  }

  public List<Assembly> toAsm() {
    List<Assembly> asm = new ArrayList<>();
    for (AsmCFGNode<D> node : nodes) {
      asm.add(node.code);
    }
    return asm;
  }

  public void render(String outFile) throws IOException {
    FileWriter out = new FileWriter(new File(outFile));
    out.write("digraph G {\n\tn0 [shape=\"none\", label=\"\"]\n");

    for (AsmCFGNode<D> node : nodes) {
      out.write(String.format(
        "\t%s [shape=\"rect\", label=\"%s\"]\n",
        node.id, node.getBody() + (node.data != null ? node.data : "")
      ));
    }

    out.write("\n\tn0 -> start\n");

    for (AsmCFGNode<D> node : nodes) {
      if (node.defaultEdgeID != null) out.write(String.format(
        "\t%s -> %s\n", node.id, node.defaultEdgeID
      ));
      if (node.trueEdgeID != null) out.write(String.format(
        "\t%s -> %s[taillabel=\"True\"]\n", node.id, node.trueEdgeID
      ));
      if (node.falseEdgeID != null) out.write(String.format(
        "\t%s -> %s[taillabel=\"False\"]\n", node.id, node.falseEdgeID
      ));
    }

    out.write("}\n");
    out.close();
  }
}