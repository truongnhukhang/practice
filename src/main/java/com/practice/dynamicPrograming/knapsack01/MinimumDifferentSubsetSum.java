package com.practice.dynamicPrograming.knapsack01;

public class MinimumDifferentSubsetSum {
  public static void main(String[] args) {
    int[] nums = {1,2,3,9};
    nums = new int[]{1, 2, 7, 1, 5};
    nums = new int[]{1, 3, 100, 4};
    MinimumDifferentSubsetSum minimumDifferentSubsetSum = new MinimumDifferentSubsetSum();
    System.out.println(minimumDifferentSubsetSum.findMinSubset(nums));
  }

  public int findMinSubset(int[] nums) {
    int cap = 0;
    for (int i = 0; i < nums.length; i++) {
      cap+=nums[i];
    }
    int min = findMinSubset(1,nums[0],cap,nums);
    return Math.abs(cap-min-min);
  }

  private int findMinSubset(int index,int subsetSum, int cap, int[] nums) {
    if(index>nums.length-1) {
      return subsetSum;
    }
    int min1 = findMinSubset(index+1,subsetSum+nums[index],cap,nums);
    int min2 = findMinSubset(index+1,subsetSum,cap,nums);
    if(Math.abs(cap-min1-min1) < Math.abs(cap-min2-min2)) {
      return min1;
    }
    return min2;
  }
}
