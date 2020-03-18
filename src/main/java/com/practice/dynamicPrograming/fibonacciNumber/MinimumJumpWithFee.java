package com.practice.dynamicPrograming.fibonacciNumber;

public class MinimumJumpWithFee {
  public static void main(String[] args) {
    int[] nums = {2,3,4,5};
    MinimumJumpWithFee minimumJumpWithFee = new MinimumJumpWithFee();
    System.out.println(minimumJumpWithFee.findMinTopDown(3,nums,new Integer[nums.length]));
  }

  public int findMinTopDown(int index,int[] nums,Integer[] dp) {
    if(index==0) {
      return 0;
    }

    if(dp[index]!=null) {
      return dp[index];
    }

    int tmp1 =  findMinTopDown(index-1,nums,dp) + nums[index-1];
    int tmp2 = index-2>=0 ? findMinTopDown(index-2,nums,dp) + nums[index-2] : Integer.MAX_VALUE;
    int tmp3 = index-3>=0 ? findMinTopDown(index-3,nums,dp) + nums[index-3] : Integer.MAX_VALUE;
    int min = Math.min(tmp1,Math.min(tmp2,tmp3));
    dp[index] = min;
    return min;
  }
}
