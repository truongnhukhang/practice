package com.practice.dynamicPrograming.knapsack01;

/**
 * Created by truongnhukhang on 3/10/20.
 */
public class EqualSubsetSumPartition {
  public static void main(String[] args) {
    int[] nums = {1,2,3,5};
    EqualSubsetSumPartition equalSubsetSumPartition = new EqualSubsetSumPartition();
    System.out.println(equalSubsetSumPartition.existEqualSubset(0,nums));
  }

  public boolean existEqualSubset(int index,int[] nums) {
    return existEqualSubsetByTarget(nums[index],index+1,nums);
  }

  public boolean existEqualSubsetByTarget(int target, int index, int[] nums) {
    if(index>nums.length-1) {
      return false;
    }
    if(target<0){
      return false;
    }
    if(target==nums[index]) {
      return true;
    }
    boolean case1 = false;
    boolean case2 = false;
    case1 = existEqualSubsetByTarget(target-nums[index],index+1,nums);
    if(case1) {
      return true;
    }
    case2 = existEqualSubsetByTarget(target+nums[index],index+1,nums);
    if(case2) {
      return true;
    }
    return false;
  }
}
