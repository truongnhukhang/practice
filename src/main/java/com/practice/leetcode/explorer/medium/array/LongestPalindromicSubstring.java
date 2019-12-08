package com.practice.leetcode.explorer.medium.array;

public class LongestPalindromicSubstring {
  public static void main(String[] args) {
//    System.out.println(longestPalindrome("aacdeeeeefcaa"));
    System.out.println(longestPalindromeDP("aacdedcaa"));
    System.out.println(longestPalindromeDP("aacdeeeeefcaa"));
    System.out.println(longestPalindromeDP("ababababa"));
    System.out.println(longestPalindromeDP("dcdddddddd"));
    System.out.println(longestPalindromeDP("aaaaaaa"));
    System.out.println(longestPalindromeDP("aaaefcaaa"));
  }


  public static String longestPalindromeDP(String s) {
    int len = s.length();
    char[] chars = s.toCharArray();
    boolean[][] mem = new boolean[len][len];
    int max = 0; int left = 0 ; int right =0;
    for (int i = 0; i < len; i++) {
      for (int j = 0; j <= i; j++) {
        if(i-j<2) {
          mem[i][j] = chars[i]==chars[j];
        } else {
          if(mem[i-1][j+1] && chars[i]==chars[j]) {
            mem[i][j] = true;
          }
        }
        if(max < i-j && mem[i][j]) {
          max = i-j;
          left= j;
          right=i;
        }
      }
    }
    return s.substring(left,right+1);
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
