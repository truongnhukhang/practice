package com.practice.medium;

import java.util.List;

public class Graph {
  List<String> vertices;
  int[][] edges;

  public Graph(List<String> vertices) {
    this.vertices = vertices;
    edges = new int[vertices.size()][vertices.size()];
  }

  public void addEdge(String from,String to) {
    this.edges[this.vertices.indexOf(from)][this.vertices.indexOf(to)] = 1;
  }

  public void print() {
    System.out.print("  ");
    for (int i = 0; i < vertices.size(); i++) {
      System.out.print(vertices.get(i)+" ");
    }
    System.out.println("");
    for (int i = 0; i < vertices.size(); i++) {
      System.out.print(vertices.get(i)+" ");
      for (int j = 0; j < vertices.size() ; j++) {
        System.out.print(this.edges[i][j]+" ");
      }
      System.out.println("");
    }
  }
}
