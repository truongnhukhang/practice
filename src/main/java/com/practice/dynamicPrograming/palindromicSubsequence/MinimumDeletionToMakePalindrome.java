package com.practice.dynamicPrograming.palindromicSubsequence;

public class MinimumDeletionToMakePalindrome {
  public static void main(String[] args) {
    String s = "cddpd";
    System.out.println(new MinimumDeletionToMakePalindrome().findMin(s));
  }

  public int findMin(String s) {
    return s.length()-findMaxPalindromeSubSq(0,s.length()-1,s,new Integer[s.length()][s.length()]);
  }

  private int findMaxPalindromeSubSq(int start, int end, String s, Integer[][] dp) {
    if(start==end) {
      return 1;
    }
    if(end < start) {
      return 0;
    }
    if(dp[start][end]!=null) {
      return dp[start][end];
    }
    int max = 1;
    if(s.charAt(start)==s.charAt(end)) {
      max = 2 + findMaxPalindromeSubSq(start + 1, end - 1, s, dp);
      dp[start][end] = max;
      return max;
    }
    int max1 = findMaxPalindromeSubSq(start+1,end,s,dp);
    int max2 = findMaxPalindromeSubSq(start,end-1,s,dp);
    max = Math.max(max1,max2);
    dp[start][end] = max;
    return max;
  }
}
