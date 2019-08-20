package com.practice.leetcode.explorer.easy.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public static void main(String[] args) {
    int[] nums = {7,-2,11,15};
    int target = 9;
    int[] result = twoSum(nums,target);
    System.out.println(result[0] + "," + result[1]);
  }

  public static int[] twoSum(int[] nums,int target) {
    Map<Integer,Integer> numMap = new HashMap<>();
    int firstNum = nums[0];
    numMap.put(target-firstNum,0);
    for (int i = 1; i < nums.length; i++) {
      if(numMap.get(nums[i])!=null) {
        return new int[]{numMap.get(nums[i]),i};
      } else {
        numMap.put(target-nums[i],i);
      }
    }
    return nums;
  }
}
