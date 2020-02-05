package com.practice.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {
  public List<Node> vertices;
  public Map<Node,List<Node>> edgesMap;
  public List<Edge> edgeList;

  public Graph() {
    vertices = new LinkedList<>();
    edgesMap = new HashMap<>();
    edgeList = new LinkedList<>();
  }

  public Node addVertex(String val) {
    Node node = new Node();
    node.color="white";
    node.val=val;
    vertices.add(node);
    return node;
  }

  public void addEdge(Node source,Node des) {
    List<Node> nodes = edgesMap.computeIfAbsent(source, k->new LinkedList<>());
    nodes.add(des);
    Edge edge = new Edge();
    edge.source=source;
    edge.des=des;
    edgeList.add(edge);
  }


}
