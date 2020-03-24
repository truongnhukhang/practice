package com.practice.dynamicPrograming.longestCommonSubString;

public class LongestCommonSubString {
  public static void main(String[] args) {
    String s1 = "passport";
    String s2 = "ppsspt";
    System.out.println(new LongestCommonSubString().findLongest(s1,s2,0,0,0,new Integer[s1.length()][s2.length()][Math.min(s1.length(),s2.length())]));
    System.out.println(new LongestCommonSubString().findLongestBottomUp(s1,s2));
  }

  public int findLongest(String s1,String s2,int idx1,int idx2,int count,Integer[][][] dp) {
    if(idx1==s1.length()-1 || idx2==s2.length()-1) {
      return count;
    }
    if(dp[idx1][idx2][count]!=null) {
      return dp[idx1][idx2][count];
    }
    int max1 = 0;
    if(s1.charAt(idx1)==s2.charAt(idx2)) {
      max1 = findLongest(s1,s2,idx1+1,idx2+1,count+1,dp);
    }
    int max2 = findLongest(s1,s2,idx1+1,idx2,0,dp);
    int max3 = findLongest(s1,s2,idx1,idx2+1,0,dp);
    int max = Math.max(max1,Math.max(max2,max3));
    dp[idx1][idx2][count] = max;
    return max;
  }

  public int findLongestBottomUp(String s1,String s2) {
    int[] dp = new int[s1.length()];
    int max = 0;
    int prv = 0;
    for (int i = 0; i < s2.length(); i++) {
      for (int j = 0; j < s1.length(); j++) {
        if(s2.charAt(i)==s1.charAt(j)) {
          dp[j] =1 + prv;
          if(dp[j]>max) {
            max = dp[j];
          }
          prv=dp[j];
        } else {
          prv = dp[j];
          dp[j] = 0;
        }
      }
    }
    return max;
  }
}
