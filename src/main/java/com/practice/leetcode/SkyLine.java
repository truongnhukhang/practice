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
    getSkyline(buildings).stream().forEach(integers -> System.out.println(integers.get(0) + " - " + integers.get(1)));
  }
  public static List<List<Integer>> getSkyline(int[][] buildings) {
    if(buildings.length==0) {
      return new ArrayList<>();
    }
    if(buildings.length==1) {
      return Arrays.asList(createPositionFrom2Number(buildings[0][0],buildings[0][2]),createPositionFrom2Number(buildings[0][1],0));
    }
    List<List<Integer>> skyLines = new ArrayList<>();
    int[] prv = buildings[0];
    int rightMost = prv[1];
    skyLines.add(createPositionFrom2Number(prv[0],prv[2]));
    for (int i = 1; i < buildings.length; i++) {
      int[] next = buildings[i];

      // nextBuilding include prvBuilding : next[0]=prv[0] and next[1]>=prv[1] and next[2] >= prv[2]
      if(next[0]==prv[0] && next[1] >= prv[1]) {
        List<Integer> lastInserted = skyLines.get(skyLines.size()-1);
        lastInserted.set(1,Math.max(next[2],lastInserted.get(1)));
      }
      // nextBuilding dont affect by prvBuilding : next[0] > prv[0] and next[2] > prv[2]
      if(next[0]>prv[0] && next[0] <= prv[1] && next[2] > prv[2]) {
        skyLines.add(createPositionFrom2Number(next[0],next[2]));
      }
      // nextBuilding affect by prvBuilding : next[0] <= prv[1] and next[1] > prv[1] and next[2] < prv[2]
      if(next[0] <= prv[1] && next[1] > prv[1] && next[2] < prv[2]) {
        skyLines.add(createPositionFrom2Number(prv[1],next[2]));
      }
      // nextBuilding same and next to prvBuilding : next[0]==prv[1] and next[2]==prv[2]
      if(next[0]==prv[1] && next[2]==prv[2]) {
        skyLines.add(createPositionFrom2Number(next[0],next[2]));
      }
      // nextBuilding is separate the prvBuilding : next[0] > prv[1]
      if(next[0] > rightMost) {
        skyLines.add(createPositionFrom2Number(rightMost,0));
        skyLines.add(createPositionFrom2Number(next[0],next[2]));
      }
      if(rightMost<next[1]) {
        rightMost = next[1];
      }
      prv = next;
    }
    skyLines.add(createPositionFrom2Number(rightMost,0));
    Iterator<List<Integer>> iterator = skyLines.iterator();
    List<Integer> prvList = iterator.next();
    while (iterator.hasNext()) {
      List<Integer> nextList = iterator.next();
      if(nextList.get(1).equals(prvList.get(1))) {
        iterator.remove();
        continue;
      }
      prvList = nextList;
    }
    return skyLines;
  }



  public static List<Integer> createPositionFrom2Number(int x,int h) {
    return Arrays.asList(x,h);
  }


}
