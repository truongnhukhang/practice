package com.practice.dynamicPrograming.longestCommonSubString;

public class MaxSumLongestIncreasingSubSequence {
  public static void main(String[] args) {
    int[] nums = {4,2,3,1,6};
    System.out.println(new MaxSumLongestIncreasingSubSequence().maxSum(0,-1,0,nums,new Integer[nums.length][nums.length+1]));
    nums = new int[]{4,1,2,6,10,1,12};
    System.out.println(new MaxSumLongestIncreasingSubSequence().maxSum(0,-1,0,nums,new Integer[nums.length][nums.length+1]));
    nums = new int[]{-4,10,3,7,15};
    System.out.println(new MaxSumLongestIncreasingSubSequence().maxSum(0,-1,0,nums,new Integer[nums.length][nums.length+1]));
  }

  public int maxSum(int index,int prv,int curMaxSum,int[] nums,Integer[][] dp) {
    if(index>dp.length-1){
      return curMaxSum;
    }
    if(dp[index][prv+1]!=null) {
      return dp[index][prv+1];
    }
    int sum1 = 0;
    if(prv==-1 || nums[index] > nums[prv]  ) {
      int tmpSum = curMaxSum + nums[index] > curMaxSum ?  curMaxSum + nums[index] : curMaxSum;
      sum1 = maxSum(index+1,index, tmpSum,nums,dp);
    }
    int sum2 = maxSum(index+1,prv,curMaxSum,nums,dp);
    int maxSum = Math.max(sum1,sum2);
    dp[index][prv+1] = maxSum;
    return maxSum;
  }
}
