package com.practice.dynamicPrograming.longestCommonSubString;

import java.util.Arrays;

public class LongestCommonSubSequence {
  public static void main(String[] args) {
    String s1 = "bsbnkmllk";
    String s2 = "jnimjkb";
    System.out.println(new LongestCommonSubSequence().findLongest(s1,s2,0,0,new Integer[s1.length()][s2.length()]));
    System.out.println(new LongestCommonSubSequence().findLongestBottomUp(s1,s2));
  }

  public int findLongest(String s1,String s2,int idx1,int idx2,Integer[][] dp) {
    if(idx1>s1.length()-1 || idx2>s2.length()-1) {
      return 0;
    }
    if(dp[idx1][idx2]!=null) {
      return dp[idx1][idx2];
    }
    int max1 = 0;
    if(s1.charAt(idx1)==s2.charAt(idx2)) {
      max1 = 1 + findLongest(s1,s2,idx1+1,idx2+1,dp);
    }
    int max2 = findLongest(s1,s2,idx1+1,idx2,dp);
    int max3 = findLongest(s1,s2,idx1,idx2+1,dp);
    int max = Math.max(max1,Math.max(max2,max3));
    dp[idx1][idx2] = max;
    return max;
  }

  public int findLongestBottomUp(String s1,String s2) {
    int[] dp = new int[s1.length()];
    int max = 0;
    for (int i = 0; i < s1.length(); i++) {
      if(s1.charAt(i)==s2.charAt(0)) {
        dp[i] = 1;
      } else {
        dp[i] = i-1>=0 ? dp[i-1] : 0;
      }
    }
    for (int i = 1; i < s2.length() ; i++) {
      int[] temp = Arrays.copyOf(dp,s1.length());
      for (int j = 0; j < s1.length(); j++) {
        if(s1.charAt(j)==s2.charAt(i)) {
          dp[j] = j-1 >=0 ? 1 + temp[j-1] : 1;
          if(max < dp[j]) {
            max = dp[j];
          }
        } else {
          dp[j] =j-1>=0 ? Math.max(dp[j-1],temp[j]) : temp[j];
        }
      }
    }
    return max;
  }
}
