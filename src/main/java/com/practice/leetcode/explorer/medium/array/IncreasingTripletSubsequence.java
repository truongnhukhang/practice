package com.practice.leetcode.explorer.medium.array;

public class IncreasingTripletSubsequence {
  public static void main(String[] args) {
    int[] nums = {1,1,1,1,1};
    System.out.println(increasingTriplet(nums));
  }

  public static boolean increasingTriplet(int[] nums) {
    if(nums.length<3) {
      return false;
    }
    int minOne = Integer.MAX_VALUE;
    int minTwo = Integer.MAX_VALUE;
    for(int num : nums) {
      if(minOne >= num) {
        minOne = num;
      } else if(minTwo >= num) {
        minTwo = num;
      } else {
        return true;
      }
    }
    return false;
  }
}
