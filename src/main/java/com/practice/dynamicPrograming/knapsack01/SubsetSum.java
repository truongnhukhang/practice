package com.practice.dynamicPrograming.knapsack01;

public class SubsetSum {

  public static void main(String[] args) {
    SubsetSum subsetSum = new SubsetSum();
    int[] nums = {1,3,4,8};
    System.out.println(subsetSum.subsetSumBottomUpSaveMem(6,nums));
    System.out.println(subsetSum.subsetSum(9,nums));
  }

  public boolean subsetSumBottomUpSaveMem(int target,int[] nums) {
    boolean[] dp = new boolean[target+1];
    for (int i = 1; i <= target ; i++) {
      if(nums[0]==i) {
        dp[i]=true;
      }
    }
    for (int i = 1; i < nums.length; i++) {
      for (int j = target; j > 0; j--) {
        if(nums[i]==j) {
          dp[j]=true;
        } else {
          if(j-nums[i]>0) {
            dp[j] = dp[j] || dp[j-nums[i]];
          }
        }
      }
    }
    return dp[target];
  }

  public boolean subsetSum(int target,int[] nums) {
    boolean case1 = subsetByTarget(target,0,nums);
    if(case1) {
      return true;
    }
    return subsetByTarget(target,1,nums);
  }

  public boolean subsetByTarget(int target, int index, int[] nums) {
    if(index>nums.length-1) {
      return false;
    }
    if(target<0){
      return false;
    }
    if(target-nums[index]==0) {
      return true;
    }
    boolean case1 = false;
    case1 = subsetByTarget(target-nums[index],index+1,nums);
    if(case1) {
      return true;
    }
    return subsetByTarget(target,index+1,nums);
  }
}
