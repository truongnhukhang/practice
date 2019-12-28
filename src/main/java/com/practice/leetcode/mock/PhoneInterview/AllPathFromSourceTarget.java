package com.practice.leetcode.mock.PhoneInterview;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSourceTarget {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    int[] zeroPath = graph[0];
    if(zeroPath.length==0) {
      return new ArrayList<>();
    }
    List<List<Integer>> pathResults = new ArrayList<>();
    for(int i=0;i<zeroPath.length;i++) {
      System.out.println(zeroPath[i]);
      List<List<Integer>> pathToTargets = findPath(zeroPath[i],graph,graph.length-1);
      if(pathToTargets!=null) {
        for(int j=0;j<pathToTargets.size();j++) {
          List<Integer> pathToTarget = pathToTargets.get(j);
          List<Integer> result = new ArrayList<>();
          result.add(0);
          result.addAll(pathToTarget);
          pathResults.add(result);
        }
      }
    }
    return pathResults;
  }

  public List<List<Integer>> findPath(int source,int[][] graph,int target) {
    System.out.println(source + "-" + target);
    if(source==target) {
      List<List<Integer>> pathResults = new ArrayList<>();
      List<Integer> result = new ArrayList<>();
      result.add(target);
      pathResults.add(result);
      return pathResults;
    }
    int[] sourceEdge = graph[source];
    if(sourceEdge!=null && sourceEdge.length>0) {
      List<List<Integer>> pathResults = new ArrayList<>();
      for(int i=0;i<sourceEdge.length;i++) {
        List<List<Integer>> pathToTargets = findPath(sourceEdge[i],graph,target);
        if(pathToTargets!=null) {
          for(int j=0;j<pathToTargets.size();j++) {
            List<Integer> pathToTarget = pathToTargets.get(j);
            List<Integer> result = new ArrayList<>();
            result.add(source);
            result.addAll(pathToTarget);
            pathResults.add(result);
          }
        }
      }
      return pathResults;
    } else {
      return null;
    }
  }
}
