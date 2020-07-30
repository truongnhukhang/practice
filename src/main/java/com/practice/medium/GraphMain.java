package com.practice.medium;

import java.util.Arrays;

public class GraphMain {
  public static void main(String[] args) {
    Graph graph = new Graph(Arrays.asList("a","b","c","d","e"));
    graph.addEdge("a","b");
    graph.addEdge("b","d");
    graph.addEdge("d","c");
    graph.addEdge("d","e");
    graph.addEdge("c","a");
    graph.print();
  }
}
