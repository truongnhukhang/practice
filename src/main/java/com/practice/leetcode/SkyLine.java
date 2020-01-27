package com.practice.leetcode;

import java.util.*;

public class SkyLine {
  public static void main(String[] args) {
//    int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
//    int[][] buildings = {{0,3,3},{1,5,3},{2,4,3},{3,7,3}};
//    int[][] buildings = {{3,7,8},{3,8,7},{3,9,6},{3,10,5},{3,11,4},{3,12,3},{3,13,2},{3,14,1}};
//    int[][] buildings = {{0,5,7},{5,10,7},{5,10,12},{10,15,7},{15,20,7},{15,20,12},{20,25,7}};
//    int[][] buildings = {{0,2,3},{2,5,3}};
//    int[][] buildings = {{2,4,7},{2,4,5},{2,4,6}};
    int[][] buildings = {{2,4,70},{3,8,30},{6,100,41},{7,15,70},{10,30,102},{15,25,76},{60,80,91},{70,90,72},{85,120,59}};
    getSkyLines(buildings).stream().forEach(integers -> System.out.println(integers.get(0) + " - " + integers.get(1)));
  }

  public static List<List<Integer>> getSkyLines(int[][] buildings) {
    if(buildings.length==0) {
      return new ArrayList<>();
    }
    if(buildings.length==1) {
      return Arrays.asList(createPositionFrom2Number(buildings[0][0],buildings[0][2]),createPositionFrom2Number(buildings[0][1],0));
    }
    List<int[]> criticalPoints = new ArrayList<>();
    for (int i = 0; i < buildings.length; i++) {
      int[] building = buildings[i];
      criticalPoints.add(new int[]{building[0],building[2]});
      criticalPoints.add(new int[]{building[1],-building[2]});
    }
    criticalPoints.sort((o1, o2) -> {
      if(o1[0]==o2[0]) {
        return o2[1]-o1[1];
      } else {
        return o1[0]-o2[0];
      }
    });
    List<List<Integer>> skyLines = new ArrayList<>();
    PriorityQueue<Integer> height = new PriorityQueue<>(Collections.reverseOrder());
    int prv = 0;height.offer(0);
    for (int i = 0; i < criticalPoints.size(); i++) {
      int[] point = criticalPoints.get(i);
      if(point[1]>0) {
        height.offer(point[1]);
      } else {
        height.remove(-point[1]);
      }
      int curMax = height.peek();
      if(prv!=curMax) {
        skyLines.add(createPositionFrom2Number(point[0],curMax));
        prv=curMax;
      }
    }
    return skyLines;
  }

  public static List<Integer> createPositionFrom2Number(int x,int h) {
    return Arrays.asList(x,h);
  }


}
