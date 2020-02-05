package com.practice.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {
  List<Node> vertices;
  Map<Node,List<Node>> edges;

  public Graph() {
    vertices = new LinkedList<>();
    edges = new HashMap<>();
  }

  public Node addVertex(String val) {
    Node node = new Node();
    node.color="white";
    node.val=val;
    vertices.add(node);
    return node;
  }

}
