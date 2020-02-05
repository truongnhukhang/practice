package com.practice.graph;

/**
 * Created by truongnhukhang on 2/5/20.
 */
public class GraphMain {
  public static void main(String[] args) {
    Graph graph = new Graph();
    Node a = graph.addVertex("a");
    Node b = graph.addVertex("b");
    Node c = graph.addVertex("c");
    Node d = graph.addVertex("d");
    Node e = graph.addVertex("e");
    Node f = graph.addVertex("f");

    graph.addEdge(a,b);
    graph.addEdge(b,a);
    graph.addEdge(b,c);
    graph.addEdge(c,a);
    graph.addEdge(a,c);
    graph.addEdge(c,d);
    graph.addEdge(d,c);
    graph.addEdge(d,f);
    graph.addEdge(f,d);
    graph.addEdge(d,e);
    graph.addEdge(e,d);
    graph.addEdge(f,e);
    graph.addEdge(e,f);

    EdgePrinter edgePrinter = new EdgePrinter(graph);
    edgePrinter.printEdge();
  }
}
