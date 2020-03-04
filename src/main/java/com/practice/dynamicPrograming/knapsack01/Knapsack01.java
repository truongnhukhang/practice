package com.practice.dynamicPrograming.knapsack01;

/**
 * Created by truongnhukhang on 2/27/20.
 */
public class Knapsack01 {
  /*
   * Items: { Apple, Orange, Banana, Melon }
   * Weights: { 2, 3, 1, 4 }
   * Profits: { 4, 5, 3, 7 }
   * Knapsack capacity: 5
   * Find Max profits that we can carry which weights is not greater than knapsack capacity. Each item only selected once.
   */


  public static void main(String[] args) {
    Knapsack01 knapsack01 = new Knapsack01();
    int[] weights = {2,3,1,4};
    int[] profits = {4,5,3,7};
    int capacity = 7;
    System.out.println(knapsack01.bruteForce(weights,profits,capacity,0));
    Integer[][] cache = new Integer[weights.length][capacity+1];
    System.out.println(knapsack01.topDown(weights,profits,capacity,0,cache));
    System.out.println(knapsack01.bottomUp(weights,profits,capacity));
  }


  public int bruteForce(int[] weight,int[] profit,int capacity,int index) {
    if(index > profit.length-1 || capacity <= 0) {
      return 0;
    }
    if(weight[index] <= capacity) {
      int set1 = profit[index] + bruteForce(weight,profit,capacity-weight[index],index+1);
      int set2 = bruteForce(weight,profit,capacity,index+1);
      return Math.max(set1,set2);
    }
    return 0;
  }

  public int topDown(int[] weight,int[] profit,int capacity,int index,Integer[][] cache) {
    if(index > profit.length-1 || capacity <= 0) {
      return 0;
    }
    if(cache[index][capacity]!=null) {
      System.out.println("use cache");
      return cache[index][capacity];
    }
    if(weight[index] <= capacity) {
      int set1 = profit[index] + topDown(weight,profit,capacity-weight[index],index+1,cache);
      int set2 = topDown(weight,profit,capacity,index+1,cache);
      int max = Math.max(set1, set2);
      cache[index][capacity] = max;
      return max;
    }
    return 0;
  }

  public int bottomUp(int[] weight,int[] profit,int capacity) {
    int curMax = 0;
    int[][] dp = new int[weight.length][capacity+1];
    for(int i=1;i<=capacity;i++) {
      if(i>=weight[0])
      dp[0][i] = profit[0];
    }
    for (int i = 1; i < weight.length; i++) {
      for(int j = 1; j<= capacity;j++) {
        if(j>=weight[i]) {
          dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+profit[i]);

        } else {
          dp[i][j] = dp[i-1][j];
        }
      }
    }
    return dp[weight.length-1][capacity];
  }
}
