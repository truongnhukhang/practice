package com.practice.dynamicPrograming.longestCommonSubString;

import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubSequence {
  public static void main(String[] args) {
    int[] nums = {-2,-1};
    System.out.println(new LongestIncreasingSubSequence().findLongest(0,-1,nums,new Integer[nums.length][nums.length]));
  }

  public int findLongest(int index, int prvIndex, int[] nums, Integer[][] dp) {
    if(index==nums.length) {
      return 0;
    }
    if(dp[index][prvIndex+1]!=null) {
      return dp[index][prvIndex+1];
    }
    int max1 = 0;
    if( prvIndex==-1 || nums[index] > nums[prvIndex]) {
      max1 = 1 + findLongest(index+1,index,nums,dp);
    }
    int max2 = findLongest(index+1,prvIndex,nums,dp);
    int max = Math.max(max1, max2);
    dp[index][prvIndex+1] = max;
    return max;
  }

  public int findLongest(int index, int cur, int[] nums, Map<String,Integer> map) {
    if(index>nums.length-1) {
      return 0;
    }
    String key = index+""+cur;
    if(map.get(key)!=null) {
      return map.get(key);
    }
    int max1 = 0;
    if(nums[index] > cur) {
      max1 = 1 + findLongest(index+1,nums[index],nums,map);
    }
    int max2 = findLongest(index+1,cur,nums,map);
    int max = Math.max(max1, max2);
    map.put(key,max);
    return max;
  }
}
