package com.practice.dynamicPrograming.longestCommonSubString;

public class MinDeleteInsertDistance {
  public static void main(String[] args) {
    System.out.println(new MinDeleteInsertDistance().minAction("abcmn","uibomn"));
    System.out.println(new MinDeleteInsertDistance().minAction("passport","ppsspt"));
  }

  public int minAction(String s1, String s2) {
    int lcs = findLCS(s1,s2,0,0,new Integer[s1.length()][s2.length()]);
    return (s1.length()-lcs) + (s2.length()-lcs);
  }

  private int findLCS(String s1, String s2, int idx1, int idx2, Integer[][] dp) {
    if(idx1 > s1.length()-1 || idx2 > s2.length()-1) {
      return 0;
    }

    if(dp[idx1][idx2]!=null) {
      return dp[idx1][idx2];
    }
    int max1 = 0;
    if(s1.charAt(idx1)==s2.charAt(idx2)) {
      max1 = 1 + findLCS(s1,s2,idx1+1,idx2+1,dp);
    }
    int max2 = findLCS(s1,s2,idx1,idx2+1,dp);
    int max3 = findLCS(s1,s2,idx1+1,idx2,dp);
    int max = Math.max(max1, Math.max(max2, max3));
    dp[idx1][idx2] = max;
    return max;
  }

}
