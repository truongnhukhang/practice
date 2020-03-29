package com.practice.dynamicPrograming.longestCommonSubString;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingSubsequence {
  public static void main(String[] args) {
    String s = "avtocvatobnc";
    String s2 = "tomorrow";
    String s3 = "aabdbcec";
    String s4 = "fmff";
    LongestRepeatingSubsequence repeatingSubsequence = new LongestRepeatingSubsequence();
    System.out.println(repeatingSubsequence.findMax(0,"",0,s,new HashMap<>()));
    System.out.println(repeatingSubsequence.findMax(0,"",0,"tomorrow",new HashMap<>()));
    System.out.println(repeatingSubsequence.findMax(0,"",0,"aabdbcec",new HashMap<>()));
    System.out.println(repeatingSubsequence.findMax(0,"",0,"fmff",new HashMap<>()));

    System.out.println(repeatingSubsequence.findMaxTopDown(0,0,s,new Integer[s.length()][s.length()]));
    System.out.println(repeatingSubsequence.findMaxTopDown(0,0,s2,new Integer[s.length()][s.length()]));
    System.out.println(repeatingSubsequence.findMaxTopDown(0,0,s3,new Integer[s.length()][s.length()]));
    System.out.println(repeatingSubsequence.findMaxTopDown(0,0,s4,new Integer[s.length()][s.length()]));

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
          max1 = findMax(index,"",curMax+1,s,map);
        } else {
          max1 = findMax(index+1,curRe.substring(1),curMax+1,s,map);
        }
      }
    }
    int max2 = findMax(index+1,curRe+s.charAt(index),curMax,s,map);
    int max3 = findMax(index+1,curRe,curMax,s,map);
    int max = Math.max(max1,Math.max(max2,max3));
    map.put(key,max);
    return max;
  }

  public int findMaxTopDown(int idx1,int idx2,String s,Integer[][] dp) {
    if(idx1>s.length()-1 || idx2>s.length()-1) {
      return 0;
    }
    if(dp[idx1][idx2]!=null) {
      return dp[idx1][idx2];
    }
    int max1=0;
    if(idx1!=idx2 && s.charAt(idx1)==s.charAt(idx2)) {
      max1 = 1 + findMaxTopDown(idx1+1,idx2+1,s,dp);
    }
    int max2 = findMaxTopDown(idx1,idx2+1,s,dp);
    int max3 = findMaxTopDown(idx1+1,idx2,s,dp);
    return Math.max(max1,Math.max(max2,max3));
  }
}
