package com.practice.dynamicPrograming.fibonacciNumber;

import java.util.HashMap;
import java.util.Map;

public class MinimumJumpToReachTheEnd {
  public static void main(String[] args) {
    int[] nums = {1,1,3,0,2,9,3,0,1,3};
    System.out.println(new MinimumJumpToReachTheEnd().findMindTopDown(nums.length-1,nums,new HashMap<>()));
    System.out.println(new MinimumJumpToReachTheEnd().findMinBottomUp(nums));
  }

  public int findMindTopDown(int index, int[] nums, Map<Integer,Integer> map) {
    if(index==0) {
      return 0;
    }
    if(map.get(index)!=null) {
      return map.get(index);
    }
    int min = Integer.MAX_VALUE;
    for (int i = index-1; i >= 0 ; i--) {
      if(nums[i]>=index-i) {
        int temp = findMindTopDown(i,nums,map);
        if(temp!=Integer.MAX_VALUE && temp+1 < min) {
          min = temp+1;
        }
      }
    }
    map.put(index,min);
    return min;
  }

  public int findMinBottomUp(int[] nums) {
    int[] dp = new int[nums.length];
    for (int i = 1; i < dp.length ; i++) {
      if(nums[0]-i >=0) {
        dp[i]=1;
      } else {
        dp[i] = Integer.MAX_VALUE;
      }
    }
    for (int i = 1; i < nums.length; i++) {
      if(dp[i]==Integer.MAX_VALUE) {
        continue;
      }
      for (int j = nums.length-1; j > i ; j--) {
        if(j-i <= nums[i]) {
          if(dp[j] > dp[i]+1) {
            dp[j] = dp[i]+1;
          }
        }
      }
    }
    return dp[nums.length-1];
  }
}
