package com.practice.dynamicPrograming.palindromicSubsequence;

public class LongestPalindromicSubString {
  public static void main(String[] args) {
    String s = "cbbd";
    System.out.println(new LongestPalindromicSubString().findMaxTopDown(0,s.length()-1,s,new Integer[s.length()][s.length()]));
    System.out.println(new LongestPalindromicSubString().findMaxBottomUp(s));
  }

  public int findMaxTopDown(int start,int end,String s,Integer[][] table) {
    if(start==end) {
      return 1;
    }
    if(end < start) {
      return 0;
    }
    if(table[start][end]!=null) {
      return table[start][end];
    }
    int max = 0;
    if(s.charAt(start)==s.charAt(end)) {
      max = findMaxTopDown(start+1,end-1,s,table);
      if(max + 2==end-start+1) {
        return max + 2;
      }
    }
    int max1 = findMaxTopDown(start+1,end,s,table);
    int max2 = findMaxTopDown(start,end-1,s,table);
    max = Math.max(max1,max2);
    table[start][end] = max;
    return max;
  }

  public int findMaxBottomUp(String s) {
    int max = 1;
    int maxI=0,maxJ = 0;
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int i = 0; i < s.length() ; i++) {
      for (int j = i; j >= 0; j--) {
        if(i==j) {
          dp[i][j]=true;
        } else {
          if(i-j==1) {
            if(s.charAt(j)==s.charAt(i)) {
              dp[i][j]=true;
              if(max < i-j+1) {
                max = i-j+1;
                maxI = i;
                maxJ = j;
              }
            }
          } else {
            if(s.charAt(j)==s.charAt(i)) {
              dp[i][j] = dp[i-1][j+1];
              if(dp[i][j] && max < i-j+1) {
                max = i-j+1;
                maxI = i;
                maxJ = j;
              }
            }

          }
        }
      }
    }
    System.out.println(s.substring(maxJ,maxI+1));
    return max;
  }
}
