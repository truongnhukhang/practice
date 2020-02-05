package com.practice.graph;

import com.practice.disjointSet.DisjointSet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by truongnhukhang on 2/5/20.
 */
public class MinimumSpanningTree {
  public static void main(String[] args) {
    Graph graph = new Graph();
    Node a = graph.addVertex("a");
    Node b = graph.addVertex("b");
    Node c = graph.addVertex("c");
    Node d = graph.addVertex("d");
    Node e = graph.addVertex("e");
    Node f = graph.addVertex("f");

    DisjointSet<Node> disjointSet = new DisjointSet<>();
    for(Node vertex : graph.vertices) {
      disjointSet.makeSet(vertex);
    }


    graph.addEdge(a,b,3);
    graph.addEdge(b,a,3);
    graph.addEdge(b,c,2);
    graph.addEdge(c,b,2);
    graph.addEdge(c,a,8);
    graph.addEdge(a,c,8);
    graph.addEdge(c,d,4);
    graph.addEdge(d,c,4);
    graph.addEdge(d,f,2);
    graph.addEdge(f,d,2);
    graph.addEdge(d,e,6);
    graph.addEdge(e,d,6);
    graph.addEdge(f,e,7);
    graph.addEdge(e,f,7);

    List<String> result = new ArrayList<>();
    PriorityQueue<Edge> edgeMinQ = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));

    for(Edge edge : graph.edgeList) {
      edgeMinQ.offer(edge);
    }

    while (edgeMinQ.size()>0) {
      Edge minEdge = edgeMinQ.poll();
      Node source = minEdge.source;
      Node des = minEdge.des;
      if(!disjointSet.findSet(source).val.val.equals(disjointSet.findSet(des).val.val)) {
        disjointSet.union(source,des);
        result.add(minEdge.toString());
      }
    }

    result.stream().sorted().forEach(System.out::println);
  }
}
