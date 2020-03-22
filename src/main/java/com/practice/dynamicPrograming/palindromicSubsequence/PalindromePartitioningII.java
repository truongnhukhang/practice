package com.practice.dynamicPrograming.palindromicSubsequence;

import java.util.*;

public class PalindromePartitioningII {
  /**
   * https://leetcode.com/problems/palindrome-partitioning-ii/
   * @param args
   */
  public static void main(String[] args) {
    String s = "babadada";
    System.out.println(new PalindromePartitioningII().findMinPartition(s));
  }

  public int findMinPartition(String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j >=0 ; j--) {
        if(i==j) {
          dp[i][j] = true;
        } else {
          if(s.charAt(i)==s.charAt(j)) {
            if(i-j==1) {
              dp[i][j]=true;
            } else {
              dp[i][j] = dp[i-1][j+1];
            }
          }
        }
      }
    }
    return findMinCut(s.length()-1,dp,new HashMap<>());
  }

  public int findMinCut(int index, boolean[][] dp, HashMap<Integer, Integer> map) {
    if(index<0) {
      return -1;
    }
    if(index==0) {
      return 0;
    }
    if(map.get(index)!=null) {
      return map.get(index);
    }
    int min = dp.length;
    for (int i = index; i >=0 ; i--) {
      if(dp[index][i]) {
        int tmp = 1 + findMinCut(i-1,dp,map);
        if(min > tmp) {
          min = tmp;
        }
      }
    }
    map.put(index,min);
    return min;
  }
}
