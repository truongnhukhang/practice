package com.practice.leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class CourseSchedule2 {

  public static void main(String[] args) {
    int numCourse = 4;
    int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
    CourseSchedule2 courseSchedule2 = new CourseSchedule2();
    IntStream.of(courseSchedule2.findOrder(numCourse,prerequisites)).forEach(value -> System.out.println(value));
  }


  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<Vertex> vertices = new ArrayList<>();
    Map<String,Vertex> vertexMap = new HashMap<>();
    createVertexInformationFromNumCourse(numCourses, vertices, vertexMap);
    Map<String,List<Vertex>> edges = createEdgesFromPrequisites(prerequisites,vertices,vertexMap);
    List<Integer> orders = new LinkedList<>();
    for (int i = 0; i < vertices.size(); i++) {
      Vertex vertex = vertices.get(i);
      if(vertex.color.equals("white")) {
        List<Integer> courses = findOrder(vertex,edges);
        if(courses.size()==0) {
          return new int[]{};
        }
        orders.addAll(courses);
      }
    }
    int[] results = new int[orders.size()];
    for (int i = 0; i < results.length; i++) {
      results[i] = orders.get(i);
    }
    return results;
  }

  private List<Integer> findOrder(Vertex vertex, Map<String, List<Vertex>> edges) {
    vertex.color="gray";
    List<Vertex> vertices = edges.get(vertex.val);
    List<Integer> results = new LinkedList<>();
    if(vertices !=null) {
      for (int i = 0; i < vertices.size(); i++) {
        Vertex vertexTemp = vertices.get(i);
        if(vertexTemp.color.equals("white")) {
          List<Integer> courses = findOrder(vertexTemp,edges);
          if(courses.size()==0) {
            return new LinkedList<>();
          }
          results.addAll(courses);
        } else if(vertexTemp.color.equals("gray")) {
          return new LinkedList<>();
        }
      }
    }
    vertex.color="black";
    results.add(Integer.valueOf(vertex.val));
    return results;
  }

  private Map<String, List<Vertex>> createEdgesFromPrequisites(int[][] prerequisites, List<Vertex> vertices, Map<String, Vertex> vertexMap) {
    Map<String,List<Vertex>> edges = new HashMap<>();
    for (int i = 0; i < prerequisites.length; i++) {
      int[] edge = prerequisites[i];
      String vertexFrom = String.valueOf(edge[0]);
      String vertexTo = String.valueOf(edge[1]);
      List<Vertex> verticesTo = edges.computeIfAbsent(vertexFrom,key->new ArrayList<>());
      verticesTo.add(vertexMap.get(vertexTo));
    }
    return edges;
  }

  private void createVertexInformationFromNumCourse(int numCourses, List<Vertex> vertices, Map<String, Vertex> vertexMap) {
    for (int i = 0; i < numCourses; i++) {
      Vertex vertex = new Vertex("" + i);
      vertices.add(vertex);
      vertexMap.put(vertex.val,vertex);
    }
  }



  public class Vertex {
    String val;
    String color = "white";
    public Vertex(String val) {
      this.val = val;
    }
  }
}
