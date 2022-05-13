package src_jcg284_shg64_hos7_wc523.cfg;

import java.io.*;
import java.util.*;
import edu.cornell.cs.cs4120.xic.ir.*;
import src_jcg284_shg64_hos7_wc523.optimizations.*;

public class IRCFG<D extends Data<D>> {
  
  public List<IRCFGNode<D>> nodes;
  public String functionName;

  public long labelState = 0;
  public String labelGen() {
    return "_cfg_label" + labelState++;
  }

  /**
   * Construct 
   * @param function
   * @param mode
   */
  public IRCFG(IRFuncDecl function, String mode, D initialData) {
    functionName = function.name();
    List<IRStmt> stmts = ((IRSeq)function.body()).stmts();

    List<IRStmt> block = new ArrayList<>();
    String blockID = "start";
    nodes = new ArrayList<>();

    if (mode.equals("block")) {
      boolean newBlock = true;
      for (int i = 0; i < stmts.size(); i++) {
        IRStmt stmt = stmts.get(i);
        if (newBlock) {
          newBlock = false;
          block = new ArrayList<>();
          if (stmt instanceof IRLabel) {
            IRLabel label = (IRLabel)stmt;
            blockID = label.name();
            block.add(label);
            i++;
            continue;
          } else {
            blockID = labelGen();
          }
        }
        if (stmt instanceof IRLabel) {
          IRLabel label = (IRLabel)stmt;
          nodes.add(new IRCFGNode<D>(block, label.name(), blockID, initialData));
          blockID = label.name();
          block = new ArrayList<>();
          block.add(label);
        } else if (stmt instanceof IRJump) {
          IRJump jump = (IRJump)stmt;
          block.add(jump);
          nodes.add(new IRCFGNode<D>(block, ((IRName)jump.target()).name(), blockID, initialData));
          newBlock = true;
        } else if (stmt instanceof IRCJump) {
          IRCJump cjump = (IRCJump) stmt;
          block.add(cjump);
          if (cjump.falseLabel() != null) {
            nodes.add(new IRCFGNode<D>(block, cjump.trueLabel(), cjump.falseLabel(), blockID, initialData));
            newBlock = true;
          } else if (i + 1 < stmts.size() && stmts.get(i + 1) instanceof IRLabel) {
            IRLabel label = (IRLabel) stmts.get(i);
            nodes.add(new IRCFGNode<D>(block, cjump.trueLabel(), label.name(), blockID, initialData));
            newBlock = true;
          } else {
            String label = labelGen();
            nodes.add(new IRCFGNode<D>(block, cjump.trueLabel(), label, blockID, initialData));
            block = new ArrayList<>();
            blockID = label;
          }
        } else if (stmt instanceof IRReturn) {
          IRReturn ret = (IRReturn)stmt;
          block.add(ret);
          nodes.add(new IRCFGNode<D>(block, blockID, initialData));
          block = new ArrayList<>();
          newBlock = true;
        } else {
          block.add(stmt);
        }
      }
    } else if (mode.equals("stmt")) {
      for (int i = 0; i < stmts.size() - 1; i++) {
        IRStmt stmt = stmts.get(i);
        IRStmt nextStmt = stmts.get(i + 1);
        String nextBlockID;
        if (nextStmt instanceof IRLabel) {
          nextBlockID = ((IRLabel)nextStmt).name();
        } else {
          nextBlockID = labelGen();
        }
        if (stmt instanceof IRJump) {
          IRJump jump = (IRJump)stmt;
          block.add(jump);
          nodes.add(new IRCFGNode<D>(block, ((IRName)jump.target()).name(), blockID, initialData));
        } else if (stmt instanceof IRCJump) {
          IRCJump cjump = (IRCJump) stmt;
          block.add(cjump);
          if (cjump.falseLabel() != null) {
            nodes.add(new IRCFGNode<D>(block, cjump.trueLabel(), cjump.falseLabel(), blockID, initialData));
          } else {
            nodes.add(new IRCFGNode<D>(block, cjump.trueLabel(), nextBlockID, blockID, initialData));
          }
        } else if (stmt instanceof IRReturn) {
          IRReturn ret = (IRReturn)stmt;
          block.add(ret);
          nodes.add(new IRCFGNode<D>(block, blockID, initialData));
        } else {
          block.add(stmt);
          nodes.add(new IRCFGNode<D>(block, nextBlockID, blockID, initialData));
        }
        blockID = nextBlockID;
        block = new ArrayList<>();
      }
      block.add(stmts.get(stmts.size() - 1));
      nodes.add(new IRCFGNode<D>(block, blockID, initialData));
    } else {
      System.out.println("Invalid mode parameter to IRCFG.");
      System.exit(1);
    }

    Map<String, IRCFGNode<D>> map = new HashMap<>();
    for (IRCFGNode<D> node : nodes) {
      map.put(node.id, node);
    }

    for (IRCFGNode<D> node : nodes) {
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

  public IRFuncDecl toIR() {
    List<IRStmt> body = new ArrayList<>();
    for (IRCFGNode<D> n : nodes) {
      body.addAll(n.code);
    }
    return new IRFuncDecl(functionName, new IRSeq(body));
  }

  public void render(String outFile) throws IOException {
    FileWriter out = new FileWriter(new File(outFile));
    out.write("digraph G {\n\tn0 [shape=\"none\", label=\"\"]\n");

    for (IRCFGNode<D> node : nodes) {
      out.write(String.format(
        "\t%s [shape=\"rect\", label=\"%s\"]\n", 
        node.id, node.getBody() + (node.data != null ? node.data : "")
      ));
    }

    out.write("\n\tn0 -> start\n");

    for (IRCFGNode<D> node : nodes) {
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