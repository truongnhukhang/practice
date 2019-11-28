package com.practice.leetcode.explorer.medium.dynamicPrograming;

import java.util.*;
import java.util.stream.Collectors;

public class CoinChange {
  public static void main(String[] args) {
    int[] coins = {186,419,83,408};
    int amount = 6249;
    CoinChange coinChange = new CoinChange();
    System.out.println(coinChange.coinChange(0,coins,amount));
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
    SortedMap<Integer,Integer> subSetSum = new TreeMap<>();
    for (int i = 0; i < coinsSubset.size(); i++) {
      int tempSum = 0;
      List<Integer> subset = coinsSubset.get(i);
      for (int j = 0; j < subset.size(); j++) {
        tempSum = tempSum + subset.get(j);
      }
      int chance = 1;
      int subSum = tempSum;
      while (subSum<=amount) {
        if(!subSetSum.containsKey(subSum)) {
          subSetSum.put(subSum,chance * subset.size());
        } else {
          int curSize = subSetSum.get(subSum);
          if(curSize > subset.size()) {
            subSetSum.put(subSum,chance * subset.size());
          }
        }
        subSum = subSum+tempSum;
        chance++;
      }
    }
    int[] sum = new int[subSetSum.size()];
    int index = 0;
    for (Integer key : subSetSum.keySet()) {
      sum[index] = key;
      index++;
    }
    boolean[] memorize = new boolean[sum.length];
    int minChange = Integer.MAX_VALUE;
    for (int i = 0; i < sum.length; i++) {
      int tempMinChance =  groupSum(sum,i,amount,memorize,subSetSum);
      if(tempMinChance!=-1 && minChange > tempMinChance) {
        minChange = tempMinChance;
      }
    }
    if(minChange==Integer.MAX_VALUE) {
      return -1;
    }
    return minChange;
  }

  private int groupSum(int[] sum,int index,int amount,boolean[] memorize,Map<Integer,Integer> sumChange) {
    if(index+1 > sum.length-1 || sum[index] > amount ) {
      return -1;
    }
    if(sum[index]==amount) {
      memorize[index] = true;
      return sumChange.get(sum[index]);
    }
    int minChange = Integer.MAX_VALUE;
    for (int i = index; i < sum.length; i++) {
      int tempGroupChange = 0;
      tempGroupChange = groupSum(sum,i+1,amount-sum[i],memorize,sumChange);
      if(tempGroupChange!=-1 && minChange > tempGroupChange) {
        minChange = tempGroupChange;
      }
      if(amount-sum[i] < sum[index]+1) {
        break;
      }
    }
    if(minChange==Integer.MAX_VALUE) {
      return -1;
    }
    int change = sumChange.get(sum[index]) ;
    memorize[index] = true;
    return change+minChange;
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
