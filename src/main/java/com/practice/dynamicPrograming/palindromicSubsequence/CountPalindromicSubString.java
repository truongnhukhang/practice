package com.practice.dynamicPrograming.palindromicSubsequence;

public class CountPalindromicSubString {
  public static void main(String[] args) {
    System.out.println(new CountPalindromicSubString().countPalindromicSubString("abdbca"));
  }

  public int countPalindromicSubString(String s) {
    int count = 0;
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int i = 0; i < s.length() ; i++) {
      for (int j = i; j >= 0; j--) {
        if(i==j) {
          dp[i][j]=true;
          count++;
        } else {
          if(i-j==1) {
            if(s.charAt(j)==s.charAt(i)) {
              dp[i][j]=true;
              count++;
            }
          } else {
            if(s.charAt(j)==s.charAt(i)) {
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
