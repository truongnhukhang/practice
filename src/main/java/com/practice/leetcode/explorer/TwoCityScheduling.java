package com.practice.leetcode.explorer;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class TwoCityScheduling {
  public static void main(String[] args) {
    int[][] costs = {{70,311},{74,927},{732,711},{126,583},{857,118},{97,928},{975,843},{175,221},{284,929},{816,602},{689,863},{721,888}};
//    int[][] costs = {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
    System.out.println((new TwoCityScheduling()).twoCitySchedCost(costs));
  }

  public int twoCitySchedCost(int[][] costs) {
    int costsLen = costs.length;
    Cost[] costAs = new Cost[costsLen];
    Cost[] costBs = new Cost[costsLen];
    for (int i = 0; i < costsLen; i++) {
      Cost costA = new Cost();
      costA.costCompare = costs[i][0]-costs[i][1];
      costA.cost = costs[i][0];
      costA.index = i;
      costAs[i] = costA;
      Cost costB = new Cost();
      costB.costCompare = costs[i][1]-costs[i][0];
      costB.cost = costs[i][1];
      costB.index = i;
      costBs[i] = costB;
    }
    Arrays.sort(costAs);
    Arrays.sort(costBs);
    Stream.of(costAs).forEach(cost -> System.out.print(" "+cost.cost+"-"+cost.index));
    System.out.println("");
    Stream.of(costBs).forEach(cost -> System.out.print(" "+cost.cost+"-"+cost.index));
    System.out.println("");
    int[] flag = new int[costsLen];
    int indexA = 0;int countA = costsLen/2;
    int indexB = 0;int countB = costsLen/2;
    int sum = 0;
    while (countA >0 && countB > 0) {
      Cost tempCostA = costAs[indexA];
      Cost tempCostB = costBs[indexB];
      if(tempCostA.cost < tempCostB.cost) {
        tempCostA = costAs[indexA];
        if(flag[tempCostA.index]==0) {
          flag[tempCostA.index] = 1;
          System.out.println("Plus A : " + tempCostA.cost + " index : " +tempCostA.index);
          sum = sum + tempCostA.cost;
          countA--;
        }
        indexA++;
      }
      if(tempCostA.cost >= tempCostB.cost){
        tempCostB = costBs[indexB];
        if(flag[tempCostB.index]==0) {
          flag[tempCostB.index] = 1;
          countB--;
          System.out.println("Plus B : " + tempCostB.cost + " index : " +tempCostB.index);
          sum = sum + tempCostB.cost;
        }
        indexB++;
      }

    }
    if(countA>0) {
      for (int i = 0; i < costAs.length; i++) {
        if(flag[costAs[i].index]==0) {
          System.out.println("Plus A : " + costAs[i].cost + " index : " +costAs[i].index);
          sum = sum + costAs[i].cost;
        }
      }
    }

    if(countB>0) {
      for (int i = 0; i < costBs.length; i++) {
        if(flag[costBs[i].index]==0) {
          System.out.println("Plus B : " + costBs[i].cost + " index : " +costBs[i].index);
          sum = sum + costBs[i].cost;
        }
      }
    }
    return sum;
  }

  public class Cost implements Comparable {
    public int cost;
    public int costCompare;
    public int index;

    @Override
    public int compareTo(Object o) {
      Cost costB = (Cost) o;
      return this.costCompare-costB.costCompare;
    }
  }
}
