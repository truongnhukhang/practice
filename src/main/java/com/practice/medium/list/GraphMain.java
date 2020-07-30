package com.practice.medium.list;


import java.util.Arrays;

public class GraphMain {
  public static void main(String[] args) {
    Graph graph = new Graph(Arrays.asList("a","b","c","d","e","f","g","h"));
    graph.addEdge("a","c");
    graph.addEdge("a","h");
    graph.addEdge("c","b");
    graph.addEdge("b","a");
    graph.addEdge("c","d");
    graph.addEdge("d","e");
    graph.addEdge("e","g");
    graph.addEdge("g","f");
    graph.addEdge("f","e");
    graph.findAP();
////    graph.print();
////    graph.dfs();
//    System.out.println("----");
//    graph.edgeClassification();

//    graph = new Graph(Arrays.asList("Main app","common-io","web-skeleton","batch","service","repo","model","engine"));
//    graph.addEdge("Main app","common-io");
//    graph.addEdge("Main app","web-skeleton");
//    graph.addEdge("Main app","batch");
//    graph.addEdge("web-skeleton","repo");
//    graph.addEdge("web-skeleton","service");
//    graph.addEdge("service","model");
//    graph.addEdge("repo","model");
//    graph.addEdge("batch","model");
//    graph.addEdge("batch","engine");
//    graph.topologicalSort().stream().forEach(s -> System.out.println(s));
  }
}
