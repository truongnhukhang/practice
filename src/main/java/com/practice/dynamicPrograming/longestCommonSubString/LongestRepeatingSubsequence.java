package com.practice.dynamicPrograming.longestCommonSubString;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingSubsequence {
  public static void main(String[] args) {
    String s = "avtocvatobnc";
    System.out.println(new LongestRepeatingSubsequence().findMax(0,"",0,s,new HashMap<>()));
    System.out.println(new LongestRepeatingSubsequence().findMax(0,"",0,"tomorrow",new HashMap<>()));
    System.out.println(new LongestRepeatingSubsequence().findMax(0,"",0,"aabdbcec",new HashMap<>()));
    System.out.println(new LongestRepeatingSubsequence().findMax(0,"",0,"fmff",new HashMap<>()));
  }

  public int findMax(int index, String curRe,int curMax, String s, Map<String,Integer> map) {
    if(index>s.length()-1) {
      return curMax;
    }
    String key = index+"|"+curRe;
    if(map.get(key)!=null) {
      return map.get(key);
    }

    int max1=0;
    if(curRe.equals("") || s.charAt(index)==curRe.charAt(0)) {
      if(curRe.equals("")) {
        max1 = findMax(index+1,String.valueOf(s.charAt(index)),curMax,s,map);
      } else {
        if(curRe.length()==1) {
          max1 =findMax(index,"",curMax+1,s,map);
        } else {
          max1 = findMax(index+1,curRe.substring(1),curMax+1,s,map);
        }
      }
    }
    int max2=0;
    max2 = findMax(index+1,curRe+s.charAt(index),curMax,s,map);
    int max3 = findMax(index+1,curRe,curMax,s,map);
    int max = Math.max(max1,Math.max(max2,max3));
    map.put(key,max);
    return max;
  }
}
