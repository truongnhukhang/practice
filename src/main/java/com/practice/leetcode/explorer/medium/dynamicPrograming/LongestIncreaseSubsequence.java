package com.practice.leetcode.explorer.medium.dynamicPrograming;

public class LongestIncreaseSubsequence {
  public static void main(String[] args) {
    int[] nums = {10,11,12,13,14,9,1,2,8,3,7,101,18};
    LongestIncreaseSubsequence longestIncreaseSubsequence = new LongestIncreaseSubsequence();
    System.out.println(longestIncreaseSubsequence.lengthOfLIS(nums));
  }
  public int lengthOfLIS(int[] nums) {
    int lis = 1;
    int[] LIS_TABLE = new int[nums.length];
    int length = nums.length;
    for (int i = length-1; i>=0; i--) {
      int lis_i = 1;
      for (int j = i; j < length; j++) {
        if(nums[j] > nums[i]) {
          int tempList = LIS_TABLE[j]+1;
          if(lis_i < tempList) {
            lis_i = tempList;
          }
        }
      }
      LIS_TABLE[i] = lis_i;
      if(lis < lis_i) {
        lis = lis_i;
      }
    }
    return lis;
  }
}
