package com.practice.leetcode;

import java.util.*;

public class SkyLine {
  public static void main(String[] args) {
//    int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
//    int[][] buildings = {{0,2,3},{2,5,3},{7,9,3},{11,13,3}};
//    int[][] buildings = {{3,7,8},{3,8,7},{3,9,6},{3,10,5},{3,11,4},{3,12,3},{3,13,2},{3,14,1}};
    int[][] buildings = {{0,5,7},{5,10,7},{5,10,12},{10,15,7},{15,20,7},{15,20,12},{20,25,7}};
    getSkyline(buildings).stream().forEach(integers -> System.out.println(integers.get(0) + " - " + integers.get(1)));
  }
  public static List<List<Integer>> getSkyline(int[][] buildings) {
    // Group tower block
    if(buildings.length==0) {
      return new ArrayList<>();
    }
    if(buildings.length==1) {
      return Arrays.asList(createPositionFrom2Number(buildings[0][0],buildings[0][2]),createPositionFrom2Number(buildings[0][1],0));
    }
    List<List<Integer>> skyLines = new ArrayList<>();
    int[] prvBuilding = buildings[0];
    skyLines.add(createPositionFrom2Number(prvBuilding[0],prvBuilding[2]));
    for (int i = 1; i < buildings.length; i++) {
      int[] nextBuilding = buildings[i];
      // nextBuilding include prvBuilding : next[0]=prv[0] and next[1]>=prv[1] and next[2] >= prv[2]
      // nextBuilding dont affect by prvBuilding : next[0] > prv[0] and next[2] > prv[2]
      // nextBuilding affect by prvBuilding : next[0] <= prv[1] and next[1] > prv[1] and next[2] < prv[2]
      // nextBuilding same and next to prvBuilding : next[0]==prv[1] and next[2]==prv[2]
      // nextBuilding is separate the prvBuilding : next[0] > prv[1]
    }
    return skyLines;
  }



  public static List<Integer> createPositionFrom2Number(int x,int h) {
    return Arrays.asList(x,h);
  }


}
