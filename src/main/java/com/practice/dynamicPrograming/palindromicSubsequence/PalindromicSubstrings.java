package com.practice.dynamicPrograming.palindromicSubsequence;

public class PalindromicSubstrings {
  /**
   * https://leetcode.com/problems/palindromic-substrings/
   */
  public static void main(String[] args) {
    String s = "aaa";
    System.out.println(new CountPalindromicSubString().countPalindromicSubString(s));
  }

  public int countNumPalindromicSub(String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j >=0 ; j--) {
        if(i==j) {
          dp[i][j] = true;
          count++;
        } else {
          if(s.charAt(i)==s.charAt(j)) {
            if(i-j==1) {
              dp[i][j]=true;
              count++;
            } else {
              dp[i][j] = dp[i-1][j+1];
              if(dp[i][j]) {
                count++;
              }
            }
          }
        }
      }
    }
    return count;
  }
}
