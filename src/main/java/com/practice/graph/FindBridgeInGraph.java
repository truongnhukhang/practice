package com.practice.graph;

import java.util.List;

public class FindBridgeInGraph {

  public List<String> findBridge(Graph graph) {
    Node root = graph.vertices.get(0);
    List<Node> connectNode = graph.edgesMap.get(root);
    Integer[] time = new Integer[1];
    time[0]=1;
    root.d=time[0];
    root.low=time[0];
    for (int i = 0; i < connectNode.size(); i++) {
      Node node = connectNode.get(i);
      if(node.color.equals("white")) {

      }
    }
  }

}
