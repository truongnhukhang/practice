package com.practice.graph;

import java.util.ArrayList;
import java.util.List;

public class FindBridgeInGraph {

  public static void main(String[] args) {
    Graph graph = new Graph();

    Node a = graph.addVertex("a");
    Node b = graph.addVertex("b");
    Node c = graph.addVertex("c");
    Node d = graph.addVertex("d");
    Node e = graph.addVertex("e");
    Node f = graph.addVertex("f");
    Node g = graph.addVertex("g");

    graph.addEdge(a,b);
    graph.addEdge(a,g);
    graph.addEdge(b,c);
    graph.addEdge(c,a);
    graph.addEdge(b,d);
    graph.addEdge(d,e);
    graph.addEdge(e,f);
    graph.addEdge(f,d);

    FindBridgeInGraph findBridgeInGraph = new FindBridgeInGraph();
    findBridgeInGraph.findBridge(graph).stream().forEach(System.out::println);
  }


  public List<String> findBridge(Graph graph) {
    Node root = graph.vertices.get(0);
    List<Node> connectNode = graph.edgesMap.get(root);
    List<String> results = new ArrayList<>();
    Integer[] time = new Integer[1];
    time[0]=1;
    root.d=time[0];
    root.low=time[0];
    root.color="gray";
    for (int i = 0; i < connectNode.size(); i++) {
      Node node = connectNode.get(i);
      if(node.color.equals("white")) {
        time[0]++;
        DFS_FindBridge(node,time,graph,results);
        if(node.low>root.d) {
          results.add(root.val+"->"+node.val);
        }
      }
    }
    time[0]++;
    root.f=time[0];
    return results;
  }

  private void DFS_FindBridge(Node node, Integer[] time, Graph graph, List<String> results) {
    node.d=time[0];
    node.low=time[0];
    node.color="gray";
    List<Node> connectNode = graph.edgesMap.get(node);
    if(connectNode!=null && connectNode.size()>0) {
      for (int i = 0; i < connectNode.size(); i++) {
        Node n = connectNode.get(i);
        if(n.color.equals("white")) {
          time[0]++;
          DFS_FindBridge(n,time,graph,results);
          if(n.low < node.low) {
            node.low = n.low;
          }
          if(n.low>node.d) {
            results.add(node.val+"->"+n.val);
          }
        } else {
          node.low = Math.min(node.d,n.d);
        }

      }
    }
    time[0]++;
    node.f=time[0];
  }

}
