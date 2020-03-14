package com.practice.dynamicPrograming.knapsack01;

public class CountOfSubsetSum {
  public static void main(String[] args) {
    int[] nums = {1, 1, 2, 3};
    nums = new int[]{1, 2, 7, 1, 5};
    CountOfSubsetSum countOfSubsetSum = new CountOfSubsetSum();
    System.out.println(countOfSubsetSum.countSubsetSum(9,nums));
  }

  public int countSubsetSum(int target,int[] nums) {
    int[][] dp = new int[nums.length][target+1];
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < target+1; j++) {
        dp[i][j]=-1;
      }
    }
    int count1 = countSubsetSum(target-nums[0],1,nums,dp);
    int count2 = countSubsetSum(target,1,nums,dp);
    return count1+count2;
  }

  private int countSubsetSum(int target, int index, int[] nums,int[][] dp) {
    if(target==0) {
      return 1;
    }
    if(target<0 || index>nums.length-1) {
      return 0;
    }
    if(dp[index][target]!=-1) {
      return dp[index][target];
    }

    int count1 = countSubsetSum(target-nums[index],index+1,nums,dp);
    int count2 = countSubsetSum(target,index+1,nums,dp);
    dp[index][target]= count1+count2;
    return count1+count2;
  }
}
