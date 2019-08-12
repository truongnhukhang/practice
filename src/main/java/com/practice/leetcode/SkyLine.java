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
    List<List<int[]>> groupBuilding = groupBuilding(buildings);
    PriorityQueue<int[]> maxHQueue = new PriorityQueue<>((b1,b2) ->  b2[2]-b1[2]);
    PriorityQueue<List<Integer>> minXQueue = new PriorityQueue<>(Comparator.comparingInt(value -> value.get(0)));
    for (int i = 0; i < groupBuilding.size(); i++) {
      List<int[]> group = groupBuilding.get(i);
      for (int j = 0; j < group.size(); j++) {
        maxHQueue.offer(group.get(j));
      }
      int[] higherBuilding = maxHQueue.poll();
      int rightMost = higherBuilding[1];
      minXQueue.offer(createPositionFrom2Number(higherBuilding[0],higherBuilding[2]));
      while (!maxHQueue.isEmpty()) {
        int[] tempBuilding = maxHQueue.poll();
        // check building is cross the higherBuilding or not
        if(tempBuilding[0] >= higherBuilding[0] && tempBuilding[0] < higherBuilding[1] && tempBuilding[1] > higherBuilding[1]) {
          minXQueue.offer(createPositionFrom2Number(higherBuilding[1],tempBuilding[2]));
        } else if(tempBuilding[0] < higherBuilding[0]) {
          minXQueue.offer(createPositionFrom2Number(tempBuilding[0],tempBuilding[2]));
        }
        if(tempBuilding[1] > rightMost) {
          rightMost= tempBuilding[1];
        }
        higherBuilding = tempBuilding;
      }
      minXQueue.offer(createPositionFrom2Number(rightMost,0));
    }
    List<List<Integer>> skyLines = new ArrayList<>();
    while (!minXQueue.isEmpty()) {
      skyLines.add(minXQueue.poll());
    }
    return skyLines;
  }

  private static List<List<int[]>> groupBuilding(int[][] buildings) {
    List<List<int[]>> groupBuilding = new ArrayList<>();
    List<int[]> tempGroup = new ArrayList<>();
    Map<Integer,int[]> heightMap = new HashMap<>();
    tempGroup.add(buildings[0]);
    heightMap.put(buildings[0][2],buildings[0]);
    groupBuilding.add(tempGroup);
    int mostRight = buildings[0][1];
    for (int i = 1; i < buildings.length; i++) {
      if(buildings[i][0] <= mostRight) {
        int[] tempHeightMap = heightMap.get(buildings[i][2]);
        if(tempHeightMap==null) {
          heightMap.put(buildings[i][2],buildings[i]);
          tempGroup.add(buildings[i]);
        } else {
          if(tempHeightMap[1] >= buildings[i][0]) {
            tempHeightMap[1] = buildings[i][1];
          } else {
            tempGroup.add(buildings[i]);
          }
        }
      } else {
        tempGroup = new ArrayList<>();
        tempGroup.add(buildings[i]);
        groupBuilding.add(tempGroup);
        heightMap.clear();
      }
      if(buildings[i][1] > mostRight) {
        mostRight = buildings[i][1];
      }
    }
    return groupBuilding;
  }

  public static List<Integer> createPositionFrom2Number(int x,int h) {
    return Arrays.asList(x,h);
  }


}
