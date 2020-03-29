package com.practice.dynamicPrograming.longestCommonSubString;

public class SubSequencePatternMatching {
  public static void main(String[] args) {
    String s = "abrdcabdd";
    String p = "abd";
    System.out.println(new SubSequencePatternMatching().count(0,0, s, p,new Integer[s.length()][p.length()]));

    s = "tomorrow";
    p = "tor";
    System.out.println(new SubSequencePatternMatching().count(0,0, s, p,new Integer[s.length()][p.length()]));

    s = "baxmx";
    p = "ax";
    System.out.println(new SubSequencePatternMatching().count(0,0, s, p,new Integer[s.length()][p.length()]));
  }

  public int count(int idx1,int idx2,String s,String p,Integer[][] dp) {
    if(idx2>p.length()-1) {
      return 1;
    }
    if(idx1>s.length()-1) {
      return 0;
    }
    if(dp[idx1][idx2]!=null) {
      return dp[idx1][idx2];
    }
    int c1=0;
    if(s.charAt(idx1)==p.charAt(idx2)) {
      c1=count(idx1+1,idx2+1,s,p,dp);
    }
    int c2 = count(idx1+1,idx2,s,p,dp);
    int count = c1+c2;
    dp[idx1][idx2]=count;
    return count;
  }
}
