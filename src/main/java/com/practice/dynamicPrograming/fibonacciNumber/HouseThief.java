package com.practice.dynamicPrograming.fibonacciNumber;

import java.util.HashMap;
import java.util.Map;

public class HouseThief {
  public static void main(String[] args) {
    HouseThief houseThief = new HouseThief();
    int[] nums = {2, 5, 1, 3, 6, 2, 4};
    System.out.println(houseThief.findMax(0,nums,new HashMap<>()));
  }

  public int findMax(int index, int[] nums, Map<Integer,Integer> map) {
    if(index==nums.length-1){
      return nums[index];
    }
    if(map.get(index)!=null) {
      System.out.println("use cache");
      return map.get(index);
    }
    int max = 0;
    for (int i = index; i < nums.length; i++) {
      for (int j = i+2; j < nums.length ; j++) {
        int tmp = nums[i] + findMax(j,nums,map);
        if(tmp>max) {
          max = tmp;
        }
      }
    }
    map.put(index,max);
    return max;
  }
}
