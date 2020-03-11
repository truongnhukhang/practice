package com.practice.dynamicPrograming.knapsack01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by truongnhukhang on 3/10/20.
 */
public class EqualSubsetSumPartition {
  public static void main(String[] args) {
    int[] nums = {43,87,61,26,73,64,23,9,54,100,14,47,75,49,90,50,62,96,18,86,95,27,87,67,67,92,82,19,53,86,15,37,83,81,59,84,47,11,80,6,14,58,72,13,78,31,56,72,94,79,67,86,25,85,19,54,50,11,52,95,100,37,96,88,71,45,77,58,13,12,49,83,50,20,2,54,84,51,3,25,42,30,92,35,91,68,57,19,4,87,15,17,6,94,84,85,91,31,47,33};
    EqualSubsetSumPartition equalSubsetSumPartition = new EqualSubsetSumPartition();
    long start = System.currentTimeMillis();
    System.out.println(equalSubsetSumPartition.existEqualSubset2(nums));
    System.out.println("Time :" + (System.currentTimeMillis()-start));
  }

  public boolean existEqualSubset2(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum+=nums[i];
    }
    if(sum%2!=0) {
      return false;
    }
    int target = sum/2;
    Map<String,Boolean> subsetMap = new HashMap<>();
    return existEqualSubsetByTarget2(target,0,nums,subsetMap);
  }

  public boolean existEqualSubsetByTarget2(int target,int index,int[] nums,Map<String,Boolean> subsetMap) {
    if(index>nums.length-1) {
      return false;
    }
    String key = target+"|"+index;
    if(subsetMap.get(key)!=null) {
      return subsetMap.get(key);
    }
    if(nums[index]==target) {
      return true;
    }
    boolean case1 = existEqualSubsetByTarget2(target-nums[index],index+1,nums,subsetMap);
    if(!case1) {
      boolean case2 = existEqualSubsetByTarget2(target, index + 1, nums, subsetMap);
      subsetMap.put(key,case2);
      return case2;
    }
    subsetMap.put(key,case1);
    return case1;
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
