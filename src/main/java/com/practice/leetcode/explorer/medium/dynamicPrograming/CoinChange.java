package com.practice.leetcode.explorer.medium.dynamicPrograming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CoinChange {
  public static void main(String[] args) {
    int[] coins = {1,2,5};
    int amount = 11;
    CoinChange coinChange = new CoinChange();
    System.out.println(coinChange.coinChange(coins,amount));
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

  public int coinChange(int[] coins, int amount) {
    if(amount==0) {
      return 0;
    }
    List<List<Integer>> coinsSubset = generateSubsetCoins(coins,0);
    coinsSubset.forEach(list -> {
      System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(",")));
    });
    int minChange = -1;
    for (int i = 0; i < coinsSubset.size(); i++) {
      int sumSubset = 0 ;
      List<Integer> subSet = coinsSubset.get(i);
      for (int j = 0; j < subSet.size(); j++) {
        sumSubset = sumSubset + subSet.get(j);
      }
      int curChange = coinChange(coinsSubset, subSet.size(),sumSubset,amount);
      if(curChange!=-1 && (minChange==-1 || curChange < minChange)) {
        minChange = curChange;
      }
    }
    return minChange;
  }

  private int coinChange(List<List<Integer>> coinsSubset,int change,int sumSubset,int amount) {

    if(amount < sumSubset || sumSubset < -1) {
      return -1;
    }
    if(amount==sumSubset) {
      return change;
    }
    int numChange = change * (amount/sumSubset);
    int leftAmount = amount%sumSubset;
    if(leftAmount!=0) {
      int minChange = -1;
      int numThrowSubset = amount/sumSubset;
      for (int i = 1; i <= numThrowSubset; i++) {
        numChange = change * i;
        leftAmount = amount-sumSubset*numChange;
        for (int j = 0; j < coinsSubset.size(); j++) {
          int sumTempSubset = 0 ;
          List<Integer> subSet = coinsSubset.get(j);
          for (int k = 0; k < subSet.size(); k++) {
            sumTempSubset = sumTempSubset + subSet.get(k);
          }
          int curChange = coinChange(coinsSubset,subSet.size(),sumTempSubset,leftAmount);
          if(curChange!=-1 && (minChange==-1 || curChange < minChange)) {
            minChange = curChange;
          }
        }
      }
      if(minChange==-1) {
        return -1;
      } else {
        return numChange+minChange;
      }

    }
    return numChange;
  }

  private List<List<Integer>> generateSubsetCoins(int[] coins, int i) {
    if(i>coins.length-1) {
      return new ArrayList<>();
    }
    List<List<Integer>> coinsSubset = new ArrayList<>();
    List<Integer> firstSubset = new ArrayList<>();
    firstSubset.add(coins[i]);
    coinsSubset.add(firstSubset);
    List<List<Integer>> tempSubset = generateSubsetCoins(coins,i+1);
    for (int j = 0; j < tempSubset.size(); j++) {
      coinsSubset.add(tempSubset.get(j));
      List<Integer> combinSubset = new ArrayList<>();
      combinSubset.add(coins[i]);
      combinSubset.addAll(tempSubset.get(j));
      coinsSubset.add(combinSubset);
    }
    return coinsSubset;
  }
}
