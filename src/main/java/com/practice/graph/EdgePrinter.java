package com.practice.graph;

import java.util.List;

/**
 * Created by truongnhukhang on 2/5/20.
 */
public class EdgePrinter {
  Graph graph;

  public EdgePrinter(Graph graph) {
    this.graph = graph;
  }

  public void printEdge() {
    for (int i = 0; i < graph.vertices.size(); i++) {
      if(graph.vertices.get(i).color.equals("white")) {
        dfs(graph.vertices.get(i));
      }
    }
  }


  private void dfs(Node node) {
    node.color="gray";
    if(graph.edgesMap.get(node)!=null) {
      List<Node> nodes = graph.edgesMap.get(node);
      for (int i = 0; i < nodes.size(); i++) {
        Node tempNode = nodes.get(i);
        if(node.p!=null && tempNode.val.equals(node.p.val)) {
          continue;
        }
        if(tempNode.color.equals("gray")) {
          System.out.println(node.val+"-"+tempNode.val + " : back edge");
        } else if(tempNode.color.equals("white")) {
          System.out.println(node.val+"-"+tempNode.val + " : tree edge");
          tempNode.p = node;
          dfs(tempNode);
        }
      }
    }
    node.color="black";
  }

}
