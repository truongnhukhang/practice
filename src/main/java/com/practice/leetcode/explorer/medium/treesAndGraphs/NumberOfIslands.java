package com.practice.leetcode.explorer.medium.treesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfIslands {
  public static void main(String[] args) {
    char[][] grid = {
        {'0','0','0','0','0'},
        {'0','0','0','0','0'},
        {'0','0','0','0','0'},
        {'0','0','0','0','0'}};
    System.out.println(new NumberOfIslands().numIslands(grid));
  }

  public int numIslands(char[][] grid) {
    List<Vertex> vertices = new ArrayList<>();
    Map<String,Vertex> vertexMap = new HashMap<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if(grid[i][j]=='1') {
          Vertex vertex = new Vertex(i+"_"+j,"white");
          vertices.add(vertex);
          vertexMap.put(i+"_"+j,vertex);
        }
      }
    }
    Map<Vertex,List<Vertex>> edges = new HashMap<>();
    for (int i = 0; i < vertices.size(); i++) {
      Vertex vertex = vertices.get(i);
      int y = Integer.parseInt(vertex.val.split("_")[0]);
      int x = Integer.parseInt(vertex.val.split("_")[1]);
      char left = x-1 >=0 ? grid[y][x-1] : '0';
      char right = x+1 <= grid[0].length-1 ? grid[y][x+1] : '0';
      char above = y-1 >=0 ? grid[y-1][x] : '0';
      char below = y+1 <= grid.length-1 ? grid[y+1][x] : '0';
      List<Vertex> vertexEdges = new ArrayList<>();
      if(left!='0') {
        vertexEdges.add(vertexMap.get(y+"_"+(x-1)));
      }
      if(right!='0') {
        vertexEdges.add(vertexMap.get(y+"_"+(x+1)));
      }
      if(above!='0') {
        vertexEdges.add(vertexMap.get((y-1)+"_"+(x)));
      }
      if(below!='0') {
        vertexEdges.add(vertexMap.get((y+1)+"_"+(x)));
      }
      edges.put(vertex,vertexEdges);
    }
    int count = 0;
    for (int i = 0; i < vertices.size(); i++) {
      if(vertices.get(i).color.equals("white")) {
        count++;
        dfs(vertices.get(i),edges);
      }
    }
    return count;
  }

  public void dfs(Vertex vertex,Map<Vertex,List<Vertex>> edges) {
    vertex.color = "gray";
    for (Vertex v : edges.get(vertex)) {
      if(v.color.equals("white")) {
        dfs(v,edges);
      }
    }
    vertex.color= "black";
  }

  class Vertex {
    String val;
    String color;

    public Vertex(String val, String color) {
      this.val = val;
      this.color = color;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Vertex)) return false;

      Vertex vertex = (Vertex) o;

      return val != null ? val.equals(vertex.val) : vertex.val == null;
    }

    @Override
    public int hashCode() {
      return val != null ? val.hashCode() : 0;
    }
  }
}
