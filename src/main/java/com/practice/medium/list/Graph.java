package com.practice.medium.list;

import java.util.*;

public class Graph {
  List<String> vertices;
  List<List<String>> edges;
  public Graph(List<String> vertices) {
    this.vertices = vertices;
    edges = new ArrayList<>();
    for (int i = 0; i < vertices.size() ; i++) {
      edges.add(new ArrayList<>());
    }
  }

  public void addEdge(String from,String to) {
    this.edges.get(this.vertices.indexOf(from)).add(to);
  }

  public void findAP() {
    int WHITE = 0;
    int RED = 1;
    int BLACK = 2;
    int[] colors = new int[vertices.size()];
    int[] discoveryTime = new int[vertices.size()];
    int[] lowTime = new int[vertices.size()];
    String anyVertex = vertices.get(0);
    // mark this vertex is visited but not finished
    colors[0] = RED;
    int[] curTime = new int[1];
    curTime[0]=1;
    discoveryTime[0] = 1;
    lowTime[0] = 1;
    int numberChildOfRoot = 0;
    List<String> adjList = edges.get(this.vertices.indexOf(anyVertex));
    for (int j = 0; j < adjList.size() ; j++) {
      int vertex = this.vertices.indexOf(adjList.get(j));
      if(colors[vertex]==WHITE) {
        numberChildOfRoot++;
        // if root has at least 2 children
        if(numberChildOfRoot>=2) {
          System.out.println(anyVertex + " is an articulation point");
        }
        curTime[0]++;
        findAP(vertex,colors,discoveryTime,lowTime,curTime,1);
      }
    }
    // mark this vertex is finished
    colors[0] = BLACK;
  }

  public void findAP(int vertex,int[] colors,int[] discoveryTime,int[] lowTime,int[] curTime,int parentDiscoveryTime) {
    int WHITE = 0;
    int RED = 1;
    int BLACK = 2;
    // mark this vertex is visited but not finished
    colors[vertex]=RED;
    discoveryTime[vertex]=curTime[0];
    lowTime[vertex]=parentDiscoveryTime;
    String anyVertex = vertices.get(vertex);
    List<String> adjList = edges.get(this.vertices.indexOf(anyVertex));
    for (int j = 0; j < adjList.size() ; j++) {
      int child = this.vertices.indexOf(adjList.get(j));
      if(colors[child]==WHITE) {
        curTime[0]++;
        findAP(child,colors,discoveryTime,lowTime,curTime,discoveryTime[vertex]);
        // update the low value
        lowTime[vertex] = Math.min(lowTime[vertex],lowTime[child]);
        if(lowTime[child] >= discoveryTime[vertex]) {
          System.out.println(anyVertex + " is an articulation point");
        }
      } else if(colors[child]==RED){
        // meet the back edge , update the low Value
        lowTime[vertex] = Math.min(lowTime[vertex],discoveryTime[child]);
      }
    }
    colors[vertex] = BLACK;
  }

  public void dfs() {
    int WHITE = 0;
    int RED = 1;
    int[] colors = new int[vertices.size()];
    String anyVertex = vertices.get(0);
    Stack<String> stack = new Stack<>();
    stack.push(anyVertex);
    while(!stack.empty()) {
      String v = stack.pop();
      colors[this.vertices.indexOf(v)] = RED;
      List<String> adjList = edges.get(this.vertices.indexOf(v));
      for (int j = 0; j < adjList.size() ; j++) {
        if(colors[this.vertices.indexOf(adjList.get(j))]==WHITE) {
          stack.push(adjList.get(j));
        } else {
          System.out.println("graph have cycle at :" + v + "-->" + adjList.get(j));
        }
      }
      System.out.println(v);
    }
  }

  public LinkedList<String> topologicalSort() {
    LinkedList<String> result = new LinkedList<>();
    int WHITE = 0;
    int RED = 1;
    int BLACK = 2;
    int[] colors = new int[vertices.size()];
    String anyVertex = vertices.get(0);
    // mark this vertex is visited but not finished
    colors[0] = RED;
    List<String> adjList = edges.get(this.vertices.indexOf(anyVertex));
    for (int j = 0; j < adjList.size() ; j++) {
      if(colors[this.vertices.indexOf(adjList.get(j))]==WHITE) {
        topologicalSort(this.vertices.indexOf(adjList.get(j)),colors,result);
      }
    }
    // mark this vertex is finished
    colors[0] = BLACK;
    result.addFirst(anyVertex);
    return result;
  }

  public void topologicalSort(int index,int[] colors,LinkedList<String> result) {
    int WHITE = 0;
    int RED = 1;
    int BLACK = 2;
    // mark this vertex is visited but not finished
    colors[index]=RED;
    String anyVertex = vertices.get(index);
    List<String> adjList = edges.get(this.vertices.indexOf(anyVertex));
    for (int j = 0; j < adjList.size() ; j++) {
      if(colors[this.vertices.indexOf(adjList.get(j))]==WHITE) {
        topologicalSort(this.vertices.indexOf(adjList.get(j)),colors,result);
      }
    }
    // mark this vertex is finished
    colors[index] = BLACK;
    result.addFirst(anyVertex);
  }


  public void edgeClassification() {
    int WHITE = 0;
    int RED = 1;
    int BLACK = 2;
    int[] colors = new int[vertices.size()];
    String anyVertex = vertices.get(0);
    // mark this vertex is visited but not finished
    colors[0] = RED;
    List<String> adjList = edges.get(this.vertices.indexOf(anyVertex));
    for (int j = 0; j < adjList.size() ; j++) {
      if(colors[this.vertices.indexOf(adjList.get(j))]==WHITE) {
        System.out.println(anyVertex + "->" + adjList.get(j) + " is Tree Edge");
        edgeClassification(this.vertices.indexOf(adjList.get(j)),colors);
      }
    }
    // mark this vertex is finished
    colors[0] = BLACK;
  }

  public void edgeClassification(int index,int[] colors) {
    int WHITE = 0;
    int RED = 1;
    int BLACK = 2;
    // mark this vertex is visited but not finished
    colors[index]=RED;
    String anyVertex = vertices.get(index);
    List<String> adjList = edges.get(this.vertices.indexOf(anyVertex));
    for (int j = 0; j < adjList.size() ; j++) {
      if(colors[this.vertices.indexOf(adjList.get(j))]==WHITE) {
        System.out.println(anyVertex + "->" + adjList.get(j) + " is Tree Edge");
        edgeClassification(this.vertices.indexOf(adjList.get(j)),colors);
      } else if(colors[this.vertices.indexOf(adjList.get(j))]==RED) {
        System.out.println(anyVertex + "->" + adjList.get(j) + " is Back Edge (Graph has a cycle)");
      } else {
        System.out.println(anyVertex + "->" + adjList.get(j) + " is a forward or cross Edge");
      }
    }
    // mark this vertex is finished
    colors[index] = BLACK;
  }


  public void dfsRecursive() {
    int WHITE = 0;
    int RED = 1;
    int[] colors = new int[vertices.size()];
    String anyVertex = vertices.get(0);
    colors[0] = RED;
    System.out.println(anyVertex);
    List<String> adjList = edges.get(this.vertices.indexOf(anyVertex));
    for (int j = 0; j < adjList.size() ; j++) {
      if(colors[this.vertices.indexOf(adjList.get(j))]==WHITE) {
        System.out.println(adjList.get(j));
        dfsRecursive(this.vertices.indexOf(adjList.get(j)),colors);
      }
    }
  }

  public void dfsRecursive(int index,int[] colors) {
    int WHITE = 0;
    int RED = 1;
    colors[index]=RED;
    String anyVertex = vertices.get(index);
    List<String> adjList = edges.get(this.vertices.indexOf(anyVertex));
    for (int j = 0; j < adjList.size() ; j++) {
      if(colors[this.vertices.indexOf(adjList.get(j))]==WHITE) {
        System.out.println(adjList.get(j));
        dfsRecursive(this.vertices.indexOf(adjList.get(j)),colors);
      }
    }
  }

  public void bfs() {
    int WHITE = 0;
    int RED = 1;
    int[] colors = new int[vertices.size()];
    String anyVertex = vertices.get(0);
    Queue<String> queue = new LinkedList<>();
    queue.add(anyVertex);
    while (!queue.isEmpty()) {
      String v = queue.poll();
      colors[this.vertices.indexOf(v)] = RED;
      System.out.println(v);
      List<String> adjList = edges.get(this.vertices.indexOf(v));
      for (int j = 0; j < adjList.size() ; j++) {
        if(colors[this.vertices.indexOf(adjList.get(j))]==WHITE) {
          queue.offer(adjList.get(j));
        }
      }
    }
  }

  public void print() {

    for (int i = 0; i < vertices.size(); i++) {
      System.out.print(vertices.get(i)+"-->");
      for (int j = 0; j < edges.get(i).size() ; j++) {
        System.out.print(this.edges.get(i).get(j) +" ");
      }
      System.out.println("");
    }
  }
}
