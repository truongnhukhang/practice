package com.practice.dynamicPrograming.fibonacciNumber;

import java.util.HashMap;
import java.util.Map;

public class MinimumJumpToReachTheEnd {
  public static void main(String[] args) {
    int[] nums = {1,1,3,6,9,3,0,1,3};
    System.out.println(new MinimumJumpToReachTheEnd().findMind(nums.length-1,nums,new HashMap<>()));
  }

  public int findMind(int index, int[] nums, Map<Integer,Integer> map) {
    if(index==0) {
      return 0;
    }
    if(map.get(index)!=null) {
      return map.get(index);
    }
    int min = Integer.MAX_VALUE;
    for (int i = index-1; i >= 0 ; i--) {
      if(nums[i]>=index-i) {
        int temp = findMind(i,nums,map);
        if(temp!=Integer.MAX_VALUE && temp+1 < min) {
          min = temp+1;
        }
      }
    }
    map.put(index,min);
    return min;
  }
}
