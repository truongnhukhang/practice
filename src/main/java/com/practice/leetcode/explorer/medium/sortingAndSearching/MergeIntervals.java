package com.practice.leetcode.explorer.medium.sortingAndSearching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeIntervals {
  public static void main(String[] args) {
    int[][] intervals = {{1,8},{2,6},{8,10},{10,18}};
    MergeIntervals mergeIntervals = new MergeIntervals();
    Stream.of(mergeIntervals.merge(intervals)).forEach(ints -> System.out.println("["+ints[0]+','+ints[1]+']'));
  }
  public int[][] merge(int[][] intervals) {
    if(intervals.length==0) {
      return intervals;
    }
    List<int[]> intervalSorts = Stream.of(intervals).sorted((o1, o2) -> o1[0]-o2[0]).collect(Collectors.toList());
    int min = intervalSorts.get(0)[0];
    int max = intervalSorts.get(0)[1];
    List<int[]> result = new ArrayList<>();
    for (int i = 1; i < intervalSorts.size(); i++) {
      int[] interval = intervalSorts.get(i);
      if(interval[0] <= max) {
        max = interval[1] > max ? interval[1] : max;
      } else {
        result.add(new int[]{min,max});
        min = interval[0];
        max = interval[1];
      }
    }
    result.add(new int[]{min,max});
    int[][] resultArray = new int[result.size()][2];
    for (int i = 0; i < result.size(); i++) {
      resultArray[i] = result.get(i);
    }
    return resultArray;
  }
}
