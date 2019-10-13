package com.practice.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
  public static void main(String[] args) {
    int numCourse = 4;
    int[][] prerequisites = {{2,0},{1,0},{3,1},{3,2},{1,3}};
    CourseSchedule courseSchedule = new CourseSchedule();
    System.out.println(courseSchedule.canFinish(numCourse,prerequisites));
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<Vertex> vertices = new ArrayList<>();
    Map<String, Vertex> vertexMap = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
      Vertex v = new Vertex(""+i,"white");
      vertices.add(v);
      vertexMap.put(""+i,v);
    }
    Map<Vertex,List<Vertex>> edges = new HashMap<>();
    for (int i = 0; i < prerequisites.length; i++) {
      int[] edge = prerequisites[i];
      String key = "" + edge[0];
      String value = "" + edge[1];
      if(edges.get(vertexMap.get(key))==null) {
        List<Vertex> verticesFromEdge = new ArrayList<>();
        verticesFromEdge.add(vertexMap.get(value));
        edges.put(vertexMap.get(key),verticesFromEdge);
      } else {
        List<Vertex> verticesFromEdge = edges.get(vertexMap.get(key));
        verticesFromEdge.add(vertexMap.get(value));
        edges.put(vertexMap.get(key),verticesFromEdge);
      }
    }
    for (int i = 0; i < vertices.size(); i++) {
      if(vertices.get(i).color.equals("white")) {
        if(checkCycle(vertices.get(i),edges)) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean checkCycle(Vertex v, Map<Vertex,List<Vertex>> edges ) {
    v.color = "gray";
    if(edges.get(v)==null) {
      v.color="black";
      return false;
    }
    for (int i = 0; i < edges.get(v).size(); i++) {
      Vertex vertex = edges.get(v).get(i);
      if(vertex.color.equals("white")) {
        if(checkCycle(vertex,edges)) {
          return true;
        }
      } else if(vertex.color.equals("gray")) {
        return true;
      }
    }
    v.color = "black";
    return false;
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
