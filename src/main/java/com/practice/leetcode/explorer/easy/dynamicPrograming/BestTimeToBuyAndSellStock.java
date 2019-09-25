package com.practice.leetcode.explorer.easy.dynamicPrograming;

public class BestTimeToBuyAndSellStock {
  public static void main(String[] args) {
    int[] prices = {1,1,5,3,5,1,4,2,7};
    System.out.println(maxProfit(prices));
  }

  public static int maxProfit(int[] prices) {
    if(prices.length==0) {
      return 0;
    }
    int min = prices[0];
    int maxProfix = 0;
    for (int i = 0; i < prices.length; i++) {
      if(prices[i] < min) {
        min = prices[i];
      }
      maxProfix = Math.max(maxProfix,prices[i]-min);
    }
    return Math.max(0,maxProfix);
  }
}
