package com.practice.leetcode.explorer.medium.array;

public class LongestPalindromicSubstring {
  public static void main(String[] args) {
    System.out.println(longestPalindrome("ee"));
  }

  public static String longestPalindrome(String s) {
    if(s.length()<=1) {
      return s;
    }
    int start=0,end = 0;
    for (int j=s.length()-1; j >=0; j--) {
      for (int i = 0; i < j; i++) {
        if(isValidPalindrome(s,i,j)) {
          if(end-start < j-i) {
            start = i;
            end = j;
          }
        }
      }
    }
    return s.substring(start,end+1);
  }

  public static boolean isValidPalindrome(String s,int startIndex,int endIndex) {
    for (int i = startIndex,j=endIndex; i<j; i++,j--) {
      if(s.charAt(i)!=s.charAt(j)){
        return false;
      }
    }
    return true;
  }
}
