package com.practice.leetcode.explorer.easy.array;

/**
 * Created by truongnhukhang on 8/19/19.
 */
public class BestTimeToBuyAndSellStock2 {
  public static void main(String[] args) {
    int[] prices = {7,1,5,3,6,4};
    System.out.println(maxProfit(prices));
  }

  /**
   * thinking simple :
   * if we have sorted array : a < b < c < d
   * so max distance of array is : d - a
   * b - a + d - c = d - c + b - c < d - a
   * @param prices
   * @return
   */
  public static int maxProfit(int[] prices) {
    int total = 0;
    for (int i = 0; i < prices.length-1; i++) {
      if(prices[i+1] > prices[i]) {
        total = total + prices[i+1] - prices[i];
      }
    }
    return total;
  }
}
