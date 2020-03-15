package com.practice.dynamicPrograming.unboundKnapsack;

import java.util.HashMap;
import java.util.Map;

public class RodCutting {
  /*
     Lengths: [1, 2, 3, 4, 5]
     Prices: [2, 6, 7, 10, 13]
     Rod Length: 5

     Let’s try different combinations of cutting the rod:

     Five pieces of length 1 => 10 price
     Two pieces of length 2 and one piece of length 1 => 14 price
     One piece of length 3 and two pieces of length 1 => 11 price
     One piece of length 3 and one piece of length 2 => 13 price
     One piece of length 4 and one piece of length 1 => 12 price
     One piece of length 5 => 13 price

     This shows that we get the maximum price (14) by cutting the rod into two pieces of length ‘2’ and one piece of length ‘1’.
   */
  public static void main(String[] args) {
    int[] lengths = {1,2,3,4,5};
    int[] prices = {2,6,7,10,13};
    int rodLength = 5;
    System.out.println(new RodCutting().cut(rodLength,lengths,prices));
  }

  public int cut(int rodLength,int[] length,int[] prices) {
    Map<String,Integer> map = new HashMap<>();
    return cutTopDown(0,rodLength,length,prices,map);
  }

  public int cutTopDown(int index, int rodLength, int[] lengths, int[] prices, Map<String,Integer> map) {
    String key = index+"|"+rodLength;
    if(map.get(key)!=null) {
      return map.get(key);
    }
    if(index>lengths.length-1) {
      return 0;
    }
    int max1 = 0;
    for (int i = 1; rodLength-lengths[index]*i >=0 ; i++) {
      int tempMax = prices[index]*i + cutTopDown(index+1,rodLength-lengths[index]*i,lengths,prices,map);
      if(tempMax > max1) {
        max1 = tempMax;
      }
    }
    int max2 = cutTopDown(index+1,rodLength,lengths,prices,map);
    int max = Math.max(max1,max2);
    map.put(key,max);
    return max;
  }
}
