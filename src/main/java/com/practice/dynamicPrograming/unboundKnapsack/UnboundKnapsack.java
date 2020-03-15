package com.practice.dynamicPrograming.unboundKnapsack;

import java.util.HashMap;
import java.util.Map;

public class UnboundKnapsack {
  /*
   * Items: { Apple, Orange, Banana, Melon }
   * Weights: { 2, 3, 1, 4 }
   * Profits: { 4, 5, 3, 7 }
   * Knapsack capacity: 5
   * Find Max profits that we can carry which weights is not greater than knapsack capacity. Each item can select many time.
   */
  public static void main(String[] args) {
    int[] weights = {2, 3, 1, 4};
    int[] profits = {4, 5, 3, 7 };
    UnboundKnapsack unboundKnapsack = new UnboundKnapsack();
    Map<String,Integer> map = new HashMap<>();
    System.out.println(unboundKnapsack.findMax(0,5,weights,profits,map));
    System.out.println(unboundKnapsack.findMaxBottomUp(5,weights,profits));
    System.out.println(unboundKnapsack.findMaxBottomUpSaveMem(5,weights,profits));
  }

  public int findMax(int index,int cap,int[] weight,int[] profit,Map<String,Integer> map) {
    String key = index+"|"+cap;
    if(map.get(key)!=null) {
      return map.get(key);
    }
    if(index>weight.length-1) {
      return 0;
    }
    int max1 = 0;
    for (int i = 1; i*weight[index] <= cap ; i++) {
      int tempMax = findMax(index+1,cap-i*weight[index],weight,profit,map) + profit[index]*i;
      if(tempMax > max1) {
        max1 = tempMax;
      }
    }

    int max2 = findMax(index+1,cap,weight,profit,map);
    int max = Math.max(max1, max2);
    map.put(key,max);
    return max;
  }

  public int findMaxBottomUpSaveMem(int cap,int[] weight,int[] profit) {
    int[] dp = new int[cap+1];
    for (int i = 1; i <= cap; i++) {
      if(i > weight[0]) {
        int count=1;
        while (i-weight[0]*count>=0) {
          dp[i]=profit[0]*count;
          count++;
        }
      } else {
        dp[i]=dp[i-1];
      }
    }

    for (int i = 1; i < weight.length; i++) {
      for (int j = cap; j >=0; j--) {
        if(j>=weight[i]) {
          int count=1;
          while (j-weight[i]*count>=0) {
            dp[j]= Math.max(dp[j],profit[i]*count+dp[j-weight[i]*count]);
            count++;
          }
        }
      }
    }
    return dp[cap];
  }

  public int findMaxBottomUp(int cap,int[] weight,int[] profit) {
    int[][] dp = new int[weight.length][cap+1];
    for (int i = 1; i <= cap; i++) {
      if(i > weight[0]) {
        int count=1;
        while (i-weight[0]*count>=0) {
          dp[0][i]=profit[0]*count;
          count++;
        }
      } else {
        dp[0][i]=dp[0][i-1];
      }
    }

    for (int i = 1; i < weight.length; i++) {
      for (int j = 1; j <= cap; j++) {
        if(j>=weight[i]) {
          int count=1;
          while (j-weight[i]*count>=0) {
            dp[i][j]= Math.max(dp[i-1][j],profit[i]*count+dp[i-1][j-weight[i]*count]);
            count++;
          }
        } else {
          dp[i][j]=dp[i-1][j];
        }
      }
    }
    return dp[weight.length-1][cap];
  }
}
