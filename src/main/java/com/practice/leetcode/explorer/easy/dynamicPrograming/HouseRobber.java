package com.practice.leetcode.explorer.easy.dynamicPrograming;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {
  static Map<Integer,Integer> robCache = new HashMap<>();
  public static void main(String[] args) {
    int[] houses = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
    System.out.println(rob(houses));
  }

  public static int rob(int[] nums) {
    if(nums.length==1)
      return nums[0];
    if(nums.length==0)
      return 0;
    return Math.max(rob(nums,nums.length-1),rob(nums,nums.length-2)+nums[nums.length-1]);
  }

  public static int rob(int[] nums,int nextHouse) {
    if(nextHouse<=0) {
      return 0;
    }
    if(robCache.get(nextHouse)!=null) {
      return robCache.get(nextHouse);
    }
    int result = Math.max(rob(nums,nextHouse-1),rob(nums,nextHouse-2)+nums[nextHouse-1]);
    robCache.put(nextHouse,result);
    return result;
  }
}
