package com.practice.leetcode;

import java.util.*;

public class SkyLine {
  public static void main(String[] args) {
    int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
    getSkyline(buildings).stream().forEach(integers -> System.out.println(integers.get(0) + " - " + integers.get(1)));
  }
  public static List<List<Integer>> getSkyline(int[][] buildings) {
    // Group tower block
    if(buildings.length==0) {
      return new ArrayList<>();
    }
    if(buildings.length==1) {
      List<Integer> position = new ArrayList<>();
      position.add(buildings[0][0]);
      position.add(buildings[0][2]);
      return Arrays.asList(position);
    }
    List<List<int[]>> groupBuilding = new ArrayList<>();
    List<int[]> tempGroup = new ArrayList<>();
    tempGroup.add(buildings[0]);
    groupBuilding.add(tempGroup);
    int mostRight = buildings[0][1];
    for (int i = 1; i < buildings.length; i++) {
      if(buildings[i][0] < mostRight) {
        tempGroup.add(buildings[i]);
      } else {
        tempGroup = new ArrayList<>();
        tempGroup.add(buildings[i]);
        groupBuilding.add(tempGroup);
      }
      if(buildings[i][1] >= mostRight) {
        mostRight = buildings[i][1];
      }
    }
    PriorityQueue<int[]> minHQueue = new PriorityQueue<>(Comparator.comparingInt(value -> value[2]));
    PriorityQueue<int[]> maxYQueue = new PriorityQueue<>((b1,b2) -> b2[1]-b1[1]);
    PriorityQueue<List<Integer>> minXQueue = new PriorityQueue<>(Comparator.comparingInt(value -> value.get(0)));
    for (int i = 0; i < groupBuilding.size(); i++) {
      List<int[]> group = groupBuilding.get(i);
      for (int j = 0; j < group.size(); j++) {
        minHQueue.offer(group.get(j));
        maxYQueue.offer(group.get(j));
      }
      int countLeftMost = 0;
      while (!minHQueue.isEmpty()) {
        int leftMost = group.get(countLeftMost)[0];
        int[] buildingMinH = minHQueue.poll();
        if(buildingMinH[0] == leftMost) {
          List<Integer> position = new ArrayList<>();
          position.add(leftMost);
          position.add(buildingMinH[2]);
          minXQueue.offer(position);
          countLeftMost++;
        } else {
          int[] buildingMaxY = maxYQueue.poll();
          if(buildingMaxY[0]==buildingMinH[0] && buildingMaxY[1]==buildingMinH[1] && buildingMaxY[2]==buildingMinH[2] ) {
            buildingMaxY = maxYQueue.poll();
          }
          if(buildingMinH[1]-buildingMaxY[1] > 0) {
            List<Integer> position = new ArrayList<>();
            position.add(buildingMinH[1]-buildingMaxY[1]);
            position.add(buildingMinH[2]);
            minXQueue.offer(position);
          }
        }
      }

    }
    List<List<Integer>> skyLines = new ArrayList<>();
    while (!minXQueue.isEmpty()) {
      skyLines.add(minXQueue.poll());
    }
    return skyLines;
  }

}
