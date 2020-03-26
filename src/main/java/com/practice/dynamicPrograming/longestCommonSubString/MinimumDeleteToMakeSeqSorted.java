package com.practice.dynamicPrograming.longestCommonSubString;

public class MinimumDeleteToMakeSeqSorted {
  public static void main(String[] args) {
    int[] nums = new int[]{4,2,3,6,10,1,12};
    System.out.println(new MinimumDeleteToMakeSeqSorted().findMin(nums));
    nums = new int[]{3,2,1,0};
    System.out.println(new MinimumDeleteToMakeSeqSorted().findMin(nums));
  }

  public int findMin(int[] nums) {
    int[] dp = new int[nums.length];
    for (int i = 0; i < dp.length; i++) {
      dp[i] = 1;
    }
    int max = 1 ;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j >= 0 ; j--) {
        if(nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i],1+dp[j]);
          if(max<dp[i]) {
            max=dp[i];
          }
        }
      }
    }
    return nums.length-max;
  }
}
