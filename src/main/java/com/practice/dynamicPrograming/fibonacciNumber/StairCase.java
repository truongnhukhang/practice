package com.practice.dynamicPrograming.fibonacciNumber;

import java.util.HashMap;
import java.util.Map;

public class StairCase {
  /*
   * Given a stair with ‘n’ steps, implement a method to count how many possible ways are there to reach the top of the staircase, given that, at every step you can either take 1 step, 2 steps, or 3 steps.
   *
   * Example 1:
   *
   * Number of stairs (n) : 3
   * Number of ways = 4
   * Explanation: Following are the four ways we can climb : {1,1,1}, {1,2}, {2,1}, {3}
   */
  public static void main(String[] args) {
    int stairs = 5;
    System.out.println(new StairCase().countWays(stairs,new HashMap<>()));
    System.out.println(new StairCase().countWaysBottomUp(stairs));
  }

  public int countWays(int stairs, Map<Integer,Integer> map) {
    if(map.get(stairs)!=null) {
      return map.get(stairs);
    }
    if(stairs==0) {
      return 1;
    }
    if(stairs<0) {
      return 0;
    }
    int sumCount = 0;
    for (int i = 1; i <= 3; i++) {
      sumCount = sumCount+countWays(stairs-i,map);
    }
    map.put(stairs,sumCount);
    return sumCount;
  }

  public int countWaysBottomUp(int stairs) {
    int[] dp = new int[stairs+1];
    dp[0]=1;
    dp[1]=1;
    dp[2]=2;
    for (int i = 3; i <= stairs; i++) {
      dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
    }
    return dp[stairs];
  }
}
