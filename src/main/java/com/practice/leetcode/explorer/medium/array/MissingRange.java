package com.practice.leetcode.explorer.medium.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by truongnhukhang on 12/19/19.
 */
public class MissingRange {
  public static void main(String[] args) {
//    int[] nums = {2,5,50,73,75};
    int[] nums = {Integer.MIN_VALUE,Integer.MIN_VALUE,0,Integer.MAX_VALUE,Integer.MAX_VALUE};
    MissingRange missingRange = new MissingRange();
    missingRange.findMissingRanges(nums,0,99).stream().forEach(System.out::println);
  }

  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> result = new ArrayList<>();
    long[] numLongs = new long[nums.length];
    for (int i = 0; i < nums.length; i++) {
      numLongs[i] = Long.valueOf(nums[i]);
    }
    if(numLongs.length==0) {
      result.add(lower+"->"+upper);
      return result;
    }
    // check first range
    if(lower < numLongs[0]) {
      if(numLongs[0]-1>lower) {
        result.add((lower)+"->"+(numLongs[0]-1));
      } else {
        result.add(""+lower);
      }
    }
    for (int i = 0; i < numLongs.length-1; i++) {
      if(numLongs[i] < numLongs[i+1]-1) {
        if((numLongs[i+1]-1)>(numLongs[i]+1)) {
          result.add((numLongs[i]+1)+"->"+(numLongs[i+1]-1));
        } else {
          result.add((numLongs[i]+1)+"");
        }
      }
    }
    if(numLongs[numLongs.length-1] < upper) {
      if(upper-1 > numLongs[numLongs.length-1]) {
        result.add((numLongs[numLongs.length-1]+1)+"->"+(upper));
      } else {
        result.add(""+upper);
      }
    }
    
    return result;
  }


}
