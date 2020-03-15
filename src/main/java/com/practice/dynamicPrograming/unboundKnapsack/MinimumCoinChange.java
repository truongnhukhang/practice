package com.practice.dynamicPrograming.unboundKnapsack;

import java.util.HashMap;
import java.util.Map;

public class MinimumCoinChange {
  public static void main(String[] args) {
    int[] coins = {1,2,3};
    int amount = 11;
    System.out.println(new MinimumCoinChange().findMin(amount,coins));
  }

  public int findMin(int amount,int[] coins) {
    Map<String,Integer> map = new HashMap<>();
    return findMin(amount,0,coins,0,map);
  }

  private int findMin(int amount, int index, int[] coins,int curUsed,Map<String,Integer> map) {
    String key = amount+"|"+index;
    if(map.get(key)!=null) {
      return map.get(key);
    }
    if(amount==0) {
      return curUsed;
    }
    if(index>coins.length-1) {
      return Integer.MAX_VALUE;
    }
    int min1 = Integer.MAX_VALUE;
    for (int i = 1; amount-coins[index]*i >=0 ; i++) {
      int tempMin = findMin(amount-coins[index]*i,index+1,coins,curUsed+i,map);
      if(tempMin<min1) {
        min1 = tempMin;
      }
    }
    int min2 = findMin(amount,index+1,coins,curUsed,map);
    int min = Math.min(min1,min2);
    map.put(key,min);
    return min;
  }
}
