package com.practice.dynamicPrograming.fibonacciNumber;

public class NumberFactor {
  public static void main(String[] args) {
    System.out.println(new NumberFactor().countWaysBottomUp(4));
    System.out.println(new NumberFactor().countWaysBottomUpMem(4));
  }

  public int countWaysBottomUp(int number) {
    int[] dp = new int[number+1];
    dp[0]=1;
    dp[1]=1;
    int[] factor = {1,3,4};
    for (int i = 2; i <= number; i++) {
      for (int j = 0; j < factor.length; j++) {
        if(i-factor[j]>=0) {
          dp[i] = dp[i] + dp[i-factor[j]];
        }
      }
    }
    return dp[number];
  }

  public int countWaysBottomUpMem(int stairs) {
    int[] dp = new int[stairs+1];
    dp[0]=1;
    dp[1]=1;
    dp[2]=1;
    dp[3]=2;
    for (int i = 4; i <= stairs; i++) {
      dp[i] = dp[i-1] + dp[i-3] + dp[i-4];
    }
    return dp[stairs];
  }
}
