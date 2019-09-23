package com.practice.leetcode.explorer.easy.dynamicPrograming;

import java.util.HashMap;
import java.util.Map;

public class ClaimbingStair {
  public static void main(String[] args) {
    System.out.println(climbStairs(2));

  }

  public static int climbStairs(int n) {
    Map<Integer,Integer> cache = new HashMap<>();
    return climbStairs(n,cache);
  }

  public static int climbStairs(int n,Map<Integer,Integer> cache) {
    if(n<=1) {
      return 1;
    }
    if(cache.get(n)!=null) {
      return cache.get(n);
    }
    int count = 0;
    count = climbStairs(n-1,cache) + climbStairs(n-2,cache);
    cache.put(n,count);
    return count;
  }
}
