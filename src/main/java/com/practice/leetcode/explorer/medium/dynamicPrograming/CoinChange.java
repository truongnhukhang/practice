package com.practice.leetcode.explorer.medium.dynamicPrograming;

import java.util.*;
import java.util.stream.Collectors;

public class CoinChange {
  public static void main(String[] args) {
//    int[] coins = {186,419,83,408};
//    int amount = 6249;

    int[] coins = {431,62,88,428};
    int amount = 431*4+62*3+38*2+428;

//    int[] coins = {2,3,5};
//    int amount = 11;
    CoinChange coinChange = new CoinChange();
    System.out.println(coinChange.coinChange(0,coins,amount));
    System.out.println(coinChange.coinChange(coins,amount));
    System.out.println(coinChange.coinChangeBottomUp(coins,amount));
  }

  public int coinChange(int[] coins,int amount) {
    Arrays.sort(coins);
    return coinChangeDFS(coins.length-1,coins,amount);
  }

  private int coinChange(int idxCoin, int[] coins, int amount) {
    if (amount == 0)
      return 0;
    if (idxCoin < coins.length && amount > 0) {
      int maxVal = amount/coins[idxCoin];
      int minCost = Integer.MAX_VALUE;
      for (int x = 0; x <= maxVal; x++) {
        if (amount >= x * coins[idxCoin]) {
          int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
          if (res != -1)
            minCost = Math.min(minCost, res + x);
        }
      }
      return (minCost == Integer.MAX_VALUE)? -1: minCost;
    }
    return -1;
  }

  public int coinChangeTopDown(int[] coins,int amount,int[] cache) {
    if(amount==0) {
      return 0;
    }
    if(amount<0) {
      return -1;
    }
    if(cache[amount]!=0) {
      return cache[amount];
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < coins.length; i++) {
      int tempMin = coinChangeTopDown(coins,amount-coins[i],cache);
      if(min > tempMin+1 && tempMin!=-1) {
        min = tempMin+1;
      }
    }
    if(min==Integer.MAX_VALUE) {
      min = -1;
    }
    cache[amount] = min;
    return min;
  }

  public int coinChangeBottomUp(int[] coins,int amount) {
    int[] cache = new int[amount+1];
    for (int i = 0; i < coins.length; i++) {
      if(coins[i]<=amount) {
        cache[coins[i]] = 1;
      }
    }
    for (int i = 0; i < cache.length; i++) {
      if(cache[i]==0) {
        cache[i] = -1;
      }
    }
    for (int i = 1; i <= amount; i++) {
      if(cache[i]==-1) {
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < coins.length; j++) {
          int tempMin = -1;
          if(i-coins[j]>0) {
            tempMin = cache[i-coins[j]];
          }
          if(min > tempMin + 1 && tempMin!=-1) {
            min = tempMin + 1;
          }
        }
        if(min!=Integer.MAX_VALUE) {
          cache[i] = min;
        }
      }
    }
    return cache[amount];
  }

  public int coinChangeDFS(int index,int[] coins,int amount) {
    if(amount==0) {
      return 0;
    }
    if(index < 0 || amount < coins[index]) {
      return -1;
    }
    int minChance = Integer.MAX_VALUE;
    int tempMin = Integer.MAX_VALUE;
    int maxChance = amount/coins[index];
    int remain = amount-maxChance*coins[index];
    boolean running = true;
    while (running) {
      int minChangeRemain = coinChangeDFS(index-1,coins,remain);
      if(tempMin > minChangeRemain && minChangeRemain!=-1) {
        tempMin = minChangeRemain+maxChance;
        running = false;
      } else {
        maxChance--;
        remain = amount - maxChance*coins[index];
        if(remain < 0) {
          running = false;
        }
      }
    }
    if(minChance > tempMin && tempMin!=-1) {
      minChance = tempMin;
    }
    if(minChance!=Integer.MAX_VALUE) {
      return minChance;
    }
    return -1;
  }

}
