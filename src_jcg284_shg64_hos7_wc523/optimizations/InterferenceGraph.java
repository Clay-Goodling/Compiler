package src_jcg284_shg64_hos7_wc523.optimizations;

import java.util.*;
import src_jcg284_shg64_hos7_wc523.codeGen.*;
import src_jcg284_shg64_hos7_wc523.cfg.AsmCFG;
import src_jcg284_shg64_hos7_wc523.cfg.AsmCFGNode;

public class InterferenceGraph {
  Map<AsmTemp, Node> nodeMap;
  Map<Node, Set<AsmTemp>> tempMap;
  Set<Node> graph;
  boolean mc;

  public InterferenceGraph(AsmCFG<LiveVarData> cfg, boolean mc){
    this.mc = mc;
    List<AsmCFGNode<LiveVarData>> nodes = cfg.nodes;
    nodeMap = new HashMap<>();
    tempMap = new HashMap<>();

    for (AsmCFGNode<LiveVarData> node : nodes) {
      for (AsmTemp t : node.data.vars){
        if (!nodeMap.keySet().contains(t)) {
          Node n = new Node(nodeMap);
          Set<AsmTemp> temps = new HashSet<>();
          temps.add(t);
          nodeMap.put(t, n);
          tempMap.put(n, temps);
        }
      }
    }

    for (AsmCFGNode<LiveVarData> node : nodes) {
      for (AsmTemp t1 : node.data.vars) {
        for (AsmTemp t2 : node.data.vars) {
          if (!t1.equals(t2)) nodeMap.get(t1).addNeighbor(t2);
        }
      }
    }
    
    for (AsmCFGNode<LiveVarData> node : nodes) {
      if (node.code instanceof AsmMove) {
        AsmMove move = (AsmMove)node.code;
        if (move.dest instanceof AsmTemp && !nodeMap.containsKey(move.dest)) {
          Node destNode = new Node(nodeMap);
          Set<AsmTemp> temps = new HashSet<>();
          temps.add((AsmTemp)move.dest);
          nodeMap.put((AsmTemp)move.dest, destNode);
          tempMap.put(destNode, temps);
          for (AsmTemp t : node.data.vars) {
            destNode.addNeighbor(t);
            nodeMap.get(t).addNeighbor((AsmTemp)move.dest);
          }
        }
        if (mc &&
            move.src instanceof AsmTemp &&
            move.dest instanceof AsmTemp && 
            !move.src.equals(move.dest) &&
            !nodeMap.get(move.dest).neighbors.contains(move.src)
        ) {
          nodeMap.get(move.src).addMoveRelated(nodeMap.get(move.dest));
          nodeMap.get(move.dest).addMoveRelated(nodeMap.get(move.src));
        }
      }
    }
    
    graph = new HashSet<>(nodeMap.values());
  }


  public void Kempe(int k) {
    Stack<Node> removedNodes = new Stack<Node>();
    int spillCount = k;

    // simplify, coalesce, freeze, then spill
    while (!graph.isEmpty()) {
      // simplify, coalesce, and freeze
      while (true) {
        // simplify and coalesce
        while (true) {
          // simplify
          while (true) {
            Node simplified = null;
            for (Node n : graph) {
              if (n.neighbors.size() < k && n.moveRelated.size() == 0) {
                simplified = n;
                removedNodes.push(n);
                break;
              }
            }
            if (simplified != null) {
              graph.remove(simplified);
              for (AsmTemp  neighbor: simplified.neighbors) {
                nodeMap.get(neighbor).neighbors.removeAll(tempMap.get(simplified));
              }
            } else {
              break;
            }
          }

          // coalesce
          Node coalesced1 = null;
          Node coalesced2 = null;
          coalesceLoop : for (Node n : graph) {
            for (Node c : n.moveRelated) {
              if (n.coalescedHighDegreeNeighborCount(c, k) < k) {
                coalesced1 = n;
                coalesced2 = c;
                break coalesceLoop;
              }
            }
          }

          if (coalesced1 != null) {
            Node coalesced = new Node(nodeMap);

            // update neighbors
            coalesced.neighbors.addAll(coalesced1.neighbors);
            coalesced.neighbors.addAll(coalesced2.neighbors);

            // update move related nodes
            for (Node related : coalesced1.moveRelated) {
              related.moveRelated.remove(coalesced1);
              related.moveRelated.remove(coalesced2);
              if (Collections.disjoint(coalesced.neighbors, tempMap.get(related)) && related != coalesced2) {
                coalesced.moveRelated.add(related);
              }
            }
            for (Node related : coalesced2.moveRelated) {
              related.moveRelated.remove(coalesced1);
              related.moveRelated.remove(coalesced2);
              if (Collections.disjoint(coalesced.neighbors, tempMap.get(related)) && related != coalesced1) {
                coalesced.moveRelated.add(related);
              }
            }
            for (Node related : coalesced.moveRelated) {
              related.moveRelated.add(coalesced);
            }

            // update node/temp maps
            for (AsmTemp t : tempMap.get(coalesced1)) nodeMap.put(t, coalesced);
            for (AsmTemp t : tempMap.get(coalesced2)) nodeMap.put(t, coalesced);
            Set<AsmTemp> temps = new HashSet<>(tempMap.get(coalesced1));
            temps.addAll(tempMap.get(coalesced2));
            tempMap.put(coalesced, temps);
            tempMap.remove(coalesced1);
            tempMap.remove(coalesced2);

            // update graph
            graph.remove(coalesced1);
            graph.remove(coalesced2);
            graph.add(coalesced);
          } else {
            // nothing to coalesce
            break;
          }
        }
        // freeze low degree move-related node
        boolean frozen = false;
        if (mc) {
          for (Node n : graph) {
            if (n.neighbors.size() < k && n.moveRelated.size() != 0) {
              for (Node c : n.moveRelated) c.moveRelated.remove(n);
              n.moveRelated.clear();
              frozen = true;
              break;
            }
          }
        }
        if (!frozen) break; // nothing to freeze
      }
      if (graph.isEmpty()) break;
      // spill a node
      Node spillNode = null;
      int maxNeighbors = 0;
      for (Node n : graph) {
        if (n.neighbors.size() > maxNeighbors) {
          spillNode = n;
          maxNeighbors = n.neighbors.size();
        }
      }
      removedNodes.push(spillNode);
      for (Node c : spillNode.moveRelated) c.moveRelated.remove(spillNode);
      for (AsmTemp t : spillNode.neighbors) nodeMap.get(t).neighbors.removeAll(tempMap.get(spillNode));
      graph.remove(spillNode);
    }

    // color nodes
    while (!removedNodes.isEmpty()) {
      Node n = removedNodes.pop();
      boolean[] colors = new boolean[k];
      for (int i = 0; i < k; i++) colors[i] = true;
      for (AsmTemp t : n.neighbors) {
        Node neighbor = nodeMap.get(t);
        if (neighbor.color < k) colors[neighbor.color] = false;
      }
      for (int i = 0; i < k; i++) {
        if (colors[i]) {
          n.color = i;
          break;
        }
      }
      if (n.color == Integer.MAX_VALUE) n.color = spillCount++;
    }
  }

  public Map<AsmTemp, Integer> getColoring(int k) {
    Kempe(k);
    Map<AsmTemp, Integer> coloring = new HashMap<>();
    for (AsmTemp t : nodeMap.keySet()) {
      coloring.put(t, nodeMap.get(t).color);
    }
    return coloring;
  }
}

class Node implements Comparable<Node> {
  public Map<AsmTemp, Node> nodeMap; // map from temps to nodes
  public Set<AsmTemp> neighbors; // nodes that interfere with this one
  public Set<Node> moveRelated; // nodes to prioritize coloring the same
  public int color; // what we assign to this variable after Kempe

  public Node(Map<AsmTemp, Node> nodeMap) {
    this.neighbors = new HashSet<>();
    this.moveRelated = new HashSet<>();
    this.color = Integer.MAX_VALUE;
    this.nodeMap = nodeMap;
  }

  public void addNeighbor(AsmTemp neighbor){
    neighbors.add(neighbor);
  }

  public void addMoveRelated(Node node){
    moveRelated.add(node);
  }

  public int coalescedHighDegreeNeighborCount(Node c, int k) {
    Set<Node> coalescedNeighbors = new HashSet<>();
    for (AsmTemp t : neighbors) {
      Node n = nodeMap.get(t);
      if (n.neighbors.size() > k) coalescedNeighbors.add(n);
    }
    for (AsmTemp t : c.neighbors) {
      Node n = nodeMap.get(t);
      if (n.neighbors.size() > k) coalescedNeighbors.add(n);
    }
    return coalescedNeighbors.size();
  }

  @Override
  public int compareTo(Node n) {
    return neighbors.size() - n.neighbors.size();
  }
}
