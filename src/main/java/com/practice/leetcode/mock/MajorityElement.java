package com.practice.leetcode.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class MajorityElement {

  public static void main(String[] args) {
    MajorityElement majorityElement = new MajorityElement();
    int[] nums = new int[]{1,1,1,3,3,2,2,2};
    majorityElement.majorityElement(nums).stream().forEach(System.out::println);
  }

  public List<Integer> majorityElement(int[] nums) {
    int majorityVal = nums.length/3;
    Map<Integer,Integer> numMaps = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if(numMaps.get(nums[i])==null) {
        numMaps.put(nums[i],1);
      } else {
        numMaps.put(nums[i],numMaps.get(nums[i])+1);
      }
    }
    List<Integer> result = new ArrayList<>();
    numMaps.forEach((num, count) -> {
      if(count>majorityVal) {
        result.add(num);
      }
    });
    return result;
  }
}
