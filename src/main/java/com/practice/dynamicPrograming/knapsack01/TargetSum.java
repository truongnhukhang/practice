package com.practice.dynamicPrograming.knapsack01;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
  public static void main(String[] args) {
    TargetSum targetSum = new TargetSum();
    int[] nums = {1, 1, 2, 3, 4,-5,1,5,6};
    System.out.println(targetSum.countTargetSum(1,nums));
  }

  public int countTargetSum(int target,int[] nums) {
    Map<String,Integer> countSum = new HashMap<>();
    int count1 = countTargetSum(target+nums[0],1,nums,countSum);
    int count2 = countTargetSum(target-nums[0],1,nums,countSum);
    return count1+count2;
  }

  private int countTargetSum(int target, int index, int[] nums, Map<String,Integer> countSum) {
    String key = target+"|"+index;
    if(countSum.get(key)!=null) {
      System.out.println("Use cache");
      return countSum.get(key);
    }

    if(target==0 && index>nums.length-1) {
      return 1;
    }
    if(target!=0 && index>nums.length-1) {
      return 0;
    }

    int count1 = countTargetSum(target+nums[index],index+1,nums,countSum);
    int count2 = countTargetSum(target-nums[index],index+1,nums,countSum);
    countSum.put(key,count1+count2);
    return count1+count2;
  }


}
