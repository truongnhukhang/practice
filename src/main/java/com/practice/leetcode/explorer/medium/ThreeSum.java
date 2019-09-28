package com.practice.leetcode.explorer.medium;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
  public static void main(String[] args) {
    int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
    List<List<Integer>> result = threeSum(nums);
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    if(nums.length<3) {
      return new ArrayList<>();
    }
    List<List<Integer>> result = new ArrayList<>();
    Map<Integer, Set<String>> cache = new HashMap<>();
    Set<String> tempSet = new HashSet<>();
    tempSet.add(nums[0]+"_"+nums[1]);
    cache.put(nums[0]+nums[1],tempSet);
    List<Integer> tempResult = null;
    Set<String> history = new HashSet<>();
    for (int i = 2; i < nums.length; i++) {
      int number = 0 - nums[i];
      if(cache.get(number)!=null) {
        tempSet = cache.get(number);
        for (String cacheValue:tempSet) {
          tempResult = new ArrayList<>();
          String[] numbers = cacheValue.split("_");
          tempResult.add(Integer.valueOf(numbers[0]));
          tempResult.add(Integer.valueOf(numbers[1]));
          tempResult.add(nums[i]);
          Collections.sort(tempResult);
          if(history.add(tempResult.stream().map(integer -> String.valueOf(integer)).collect(Collectors.joining("|")))) {
            result.add(tempResult);
          }
        }
      }
      updateCache(cache,nums,i);

    }
    return result;
  }

  private static void updateCache(Map<Integer, Set<String>> cache, int[] nums, int index) {
    Set<String> tempSet = null;
    for (int i = 0; i < index; i++) {
      tempSet = cache.get(nums[index]+nums[i]);
      if(tempSet==null) {
        tempSet = new HashSet<>();
      }
      tempSet.add(nums[i]+"_"+nums[index]);
      cache.put(nums[index]+nums[i],tempSet);
    }
  }
}
