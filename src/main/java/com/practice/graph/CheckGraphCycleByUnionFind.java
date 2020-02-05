package com.practice.graph;

import com.practice.disjointSet.DisjointSet;

/**
 * Created by truongnhukhang on 2/5/20.
 */
public class CheckGraphCycleByUnionFind {
  public static void main(String[] args) {
    Graph graph = new Graph();

    Node a = graph.addVertex("a");
    Node b = graph.addVertex("b");
    Node c = graph.addVertex("c");
    Node d = graph.addVertex("d");
    Node e = graph.addVertex("e");
    Node f = graph.addVertex("f");

    graph.addEdge(a,b);
    graph.addEdge(b,c);
    graph.addEdge(c,a);
    graph.addEdge(c,d);
    graph.addEdge(d,f);
    graph.addEdge(d,e);
    graph.addEdge(f,e);

    DisjointSet<Node> disjointSet = new DisjointSet<>();
    for(Node vertex : graph.vertices) {
      disjointSet.makeSet(vertex);
    }

    for(Edge edge : graph.edgeList) {
      Node source = edge.source;
      Node des = edge.des;
      if(disjointSet.findSet(source).val.val.equals(disjointSet.findSet(des).val.val)) {
        System.out.println("Cycle detected : " + source.val + "->" + des.val);
      } else {
        disjointSet.union(source,des);
      }
    }

  }
}
