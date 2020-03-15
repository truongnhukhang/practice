package com.practice.dynamicPrograming.unboundKnapsack;

import java.util.HashMap;
import java.util.Map;

public class MaxRibbonCut {
  public static void main(String[] args) {
    int[] ribbon = {3,5,7};
    int amount = 13;
    System.out.println(new MaxRibbonCut().maxRibbonCut(amount,ribbon));
  }

  public int maxRibbonCut(int amount,int[] ribbon){
    Map<String,Integer> map = new HashMap<>();
    return maxRibbonCut(amount,0,ribbon,0,map);
  }

  private int maxRibbonCut(int amount, int index, int[] ribbon, int curUsed, Map<String, Integer> map) {
    String key = amount+"|"+index;
    if(map.get(key)!=null) {
      return map.get(key);
    }
    if(amount==0) {
      return curUsed;
    }
    if(index>ribbon.length-1) {
      return Integer.MIN_VALUE;
    }
    int max1 = Integer.MIN_VALUE;
    for (int i = 1; amount-ribbon[index]*i >=0 ; i++) {
      int tempMax = maxRibbonCut(amount-ribbon[index]*i,index+1,ribbon,curUsed+i,map);
      if(tempMax>max1) {
        max1 = tempMax;
      }
    }
    int max2 = maxRibbonCut(amount,index+1,ribbon,curUsed,map);
    int max = Math.max(max1,max2);
    map.put(key,max);
    return max;
  }
}
