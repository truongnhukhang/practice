package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInNetwork {

  public static void main(String[] args) {
    int n=5;
    List<List<Integer>> connections = new ArrayList<>();
    connections.add(Arrays.asList(1,0));
    connections.add(Arrays.asList(2,0));
    connections.add(Arrays.asList(3,2));
    connections.add(Arrays.asList(4,2));
    connections.add(Arrays.asList(4,3));
    connections.add(Arrays.asList(3,0));
    connections.add(Arrays.asList(4,0));
    CriticalConnectionsInNetwork criticalConnectionsInNetwork = new CriticalConnectionsInNetwork();
    criticalConnectionsInNetwork.criticalConnections(n,connections).stream().forEach(integers -> System.out.println(integers.get(0)+"->"+integers.get(1)));
  }

  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    List<List<Integer>> results = new ArrayList<>();
    List<Integer>[] edges = new ArrayList[n];
    for(int i=0;i<connections.size();i++) {
      List<Integer> connection = connections.get(i);
      if(edges[connection.get(0)]==null) {
        edges[connection.get(0)] = new ArrayList<>();
      }
      edges[connection.get(0)].add(connection.get(1));
      if(edges[connection.get(1)]==null) {
        edges[connection.get(1)] = new ArrayList<>();
      }
      edges[connection.get(1)].add(connection.get(0));
    }

    boolean[] visit = new boolean[n];
    int[] findTime = new int[n];
    int[] low = new int[n];
    int[] time = new int[1];
    time[0]=1;
    // try root first
    visit[0]=true;
    findTime[0] = time[0];
    low[0]=time[0];
    List<Integer> connectNode = edges[0];

    for(int i=0;i<connectNode.size();i++) {
      int node = connectNode.get(i);
      if(!visit[node]) {
        time[0]++;
        dfsFindBridge(visit,findTime,low,time,node,0,edges,results);
        if(low[node] > findTime[0]) {
          List<Integer> connection = new ArrayList<>();
          connection.add(0);
          connection.add(node);
          results.add(connection);
        }
      }
    }
    return results;
  }

  public void dfsFindBridge(boolean[] visit,int[] findTime,int[] low,int[] time,int node,int par,List<Integer>[] edges,List<List<Integer>> results) {
    visit[node] = true;
    findTime[node] = time[0];
    low[node] = time[0];
    List<Integer> connectNode = edges[node];
    if(connectNode!=null) {
      for(int i=0;i<connectNode.size();i++) {
        int n = connectNode.get(i);
        if(n==par) {
          continue;
        }
        if(!visit[n]) {
          time[0]++;
          dfsFindBridge(visit,findTime,low,time,n,node,edges,results);
          if(low[n] < low[node]) {
            low[node]=low[n];
          }

          if(low[n] > findTime[node]) {
            List<Integer> connection = new ArrayList<>();
            connection.add(node);
            connection.add(n);
            results.add(connection);
          }
        } else {
          int minFindTime = Math.min(findTime[node], findTime[n]);
          low[node] = Math.min(minFindTime,low[node]);
        }
      }
    }
  }
}
