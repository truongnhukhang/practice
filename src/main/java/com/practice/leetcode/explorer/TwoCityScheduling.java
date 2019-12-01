package com.practice.leetcode.explorer;

import java.util.Arrays;


public class TwoCityScheduling {
  public static void main(String[] args) {
    int[][] costs = {{70,311},{74,927},{732,711},{126,583},{857,118},{97,928},{975,843},{175,221},{284,929},{816,602},{689,863},{721,888}};
    System.out.println((new TwoCityScheduling()).twoCitySchedCost(costs));
  }

  public int twoCitySchedCost(int[][] costs) {
    int costsLen = costs.length;
    Cost[] costAs = new Cost[costsLen];
    Cost[] costBs = new Cost[costsLen];
    for (int i = 0; i < costsLen; i++) {
      Cost costA = new Cost();
      costA.cost = costs[i][0];
      costA.index = i;
      costAs[i] = costA;
      Cost costB = new Cost();
      costB.cost = costs[i][1];
      costB.index = i;
      costBs[i] = costB;
    }
    Arrays.sort(costAs);
    Arrays.sort(costBs);
    int[] flag = new int[costsLen];
    int numPer = costsLen;
    int indexA = 0;
    int indexB = 0;
    int sum = 0;
    while (numPer>0) {
      boolean pickA = false;
      boolean pickB = false;
      while (!pickA) {
        Cost tempCostA = costAs[indexA];
        if(flag[tempCostA.index]==0) {
          pickA=true;
          flag[tempCostA.index] = 1;
          sum = sum + tempCostA.cost;
          numPer--;
        }
        indexA++;
      }
      while (!pickB) {
        Cost tempCostB = costBs[indexB];
        if(flag[tempCostB.index]==0) {
          flag[tempCostB.index] = 1;
          pickB=true;
          sum = sum + tempCostB.cost;
          numPer--;
        }
        indexB++;
      }

    }
    return sum;
  }

  public class Cost implements Comparable {
    public int cost;
    public int index;

    @Override
    public int compareTo(Object o) {
      Cost costB = (Cost) o;
      return this.cost-costB.cost;
    }
  }
}
