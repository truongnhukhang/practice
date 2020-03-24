package com.practice.dynamicPrograming.longestCommonSubString;

public class LongestCommonSubSequence {
  public static void main(String[] args) {
    String s1 = "abcde";
    String s2 = "ace";
    System.out.println(new LongestCommonSubSequence().findLongest(s1,s2,0,0,new Integer[s1.length()][s2.length()]));
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

  
}
