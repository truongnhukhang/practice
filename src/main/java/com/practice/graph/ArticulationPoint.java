package com.practice.graph;

import java.util.ArrayList;
import java.util.List;

public class ArticulationPoint {

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
    graph.addEdge(f,b);

    ArticulationPoint articulationPoint = new ArticulationPoint();
    articulationPoint.findArticulationPoint(graph).stream().forEach(node -> System.out.println(node.val));

  }
  
  public List<Node> findArticulationPoint(Graph graph) {
    Node root = graph.vertices.get(0);
    List<Node> edges = graph.edgesMap.get(root);
    List<Node> results = new ArrayList<>();
    Integer[] time = new Integer[1];
    time[0]=1;
    root.color="gray";
    root.d = time[0];
    root.low = time[0];
    int childCount = 0;
    for (int i = 0; i < edges.size(); i++) {
      Node n = edges.get(i);
      if (n.color.equals("white")) {
        time[0]++;
        childCount++;
        n.d=time[0];
        n.low=time[0];
        dfs_find(n,time,results,graph);
      }
    }
    root.f = time[0]++;
    if(childCount>1) {
      results.add(root);
    }
    return results;
  }

  private void dfs_find(Node node, Integer[] time, List<Node> results,Graph graph) {
    node.color="gray";
    List<Node> edges = graph.edgesMap.get(node);
    if(edges!=null && edges.size()>0) {
      for (int i = 0; i < edges.size(); i++) {
        Node n = edges.get(i);
        if (n.color.equals("white")) {
          time[0]++;
          n.d=time[0];
          n.low=time[0];
          dfs_find(n,time,results,graph);
          if(n.low<node.low) {
            node.low = n.low;
          }
          if(n.low>=node.d) {
            results.add(node);
          }
        } else {
          // back-edge
          node.low = Math.min(node.d,n.d);
        }
      }
    }
    time[0]++;
    node.f=time[0];
  }
}
