package com.practice.dynamicPrograming.longestCommonSubString;

public class MinDeleteInsertDistance {
  public static void main(String[] args) {

  }

  public int minAction(String s1, String s2) {
    int lcs = findLCS(s1,s2,0,0,new Integer[s1.length()][s2.length()]);
  }

  private int findLCS(String s1, String s2, int idx1, int idx2, Integer[][] dp) {

  }

}
