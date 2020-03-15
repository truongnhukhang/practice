package com.practice.dynamicPrograming.unboundKnapsack;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
  public static void main(String[] args) {
    int[] coins = {1,2,3};
    int amount = 5;
    System.out.println(new CoinChange().coinChange(0,amount,coins,new HashMap<>()));
  }

  public int coinChange(int index, int amount, int[] coins, Map<String,Integer> map) {
    String key = index+"|"+amount;
    if(map.get(key)!=null) {
      System.out.println("use cache");
      return map.get(key);
    }
    if(amount==0) {
      return 1;
    }
    if(index>coins.length-1) {
      return 0;
    }
    int count1 = 0;
    for (int i = 1; amount-coins[index]*i>=0; i++) {
      int tempCount = coinChange(index+1,amount-coins[index]*i,coins,map);
      count1+=tempCount;
    }
    int count2 = coinChange(index+1,amount,coins,map);
    int sum = count1 + count2;
    map.put(key,sum);
    return sum;
  }
}
