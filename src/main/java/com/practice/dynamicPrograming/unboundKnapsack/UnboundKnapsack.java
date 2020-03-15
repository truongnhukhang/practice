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
    int[] weights = {1, 2, 3 };
    int[] profits = {15, 20, 50 };
    UnboundKnapsack unboundKnapsack = new UnboundKnapsack();
    Map<String,Integer> map = new HashMap<>();
    System.out.println(unboundKnapsack.findMax(0,5,weights,profits,map));
  }

  public int findMax(int index,int cap,int[] weight,int[] profit,Map<String,Integer> map) {
    String key = index+"|"+cap;
    if(map.get(key)!=null) {
      System.out.println("use cache");
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
}
