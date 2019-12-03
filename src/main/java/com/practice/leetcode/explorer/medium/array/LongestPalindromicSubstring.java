package com.practice.leetcode.explorer.medium.array;

public class LongestPalindromicSubstring {
  public static void main(String[] args) {
    System.out.println(longestPalindrome("baba"));
    System.out.println(longestPalindromeDP("aacdefcaa"));
  }


  public static String longestPalindromeDP(String s) {
    int[][] palindromeTable = new int[s.length()][s.length()];
    char[] sText = s.toCharArray();
    StringBuilder stringBuilder = new StringBuilder(s);
    char[] sTextReverse = stringBuilder.reverse().toString().toCharArray();
    int max = 0; int[] maxIndex = new int[2];
    for (int i = 0; i < s.length() ; i++) {
      for (int j = 0; j < s.length(); j++) {
        if(sTextReverse[i]==sText[j]) {
          int score = 1;
          if(i-1 >= 0 && j-1 >=0 ) {
            score = score + palindromeTable[i-1][j-1];
          }
          palindromeTable[i][j] = score;
          if(max < score) {
            max = score;
            maxIndex[0] = i;
            maxIndex[1] = j;
          }
        } else {
          if(i-1 >= 0 && j-1 >=0) {

          }
        }
      }
    }
    int prv = palindromeTable[maxIndex[0]][maxIndex[1]];
    String longestPalindrome = s.charAt(maxIndex[1]) + "";
    maxIndex[0]--;
    maxIndex[1]--;
    while (maxIndex[0] >=0 && maxIndex[1] >=0) {
      if(palindromeTable[maxIndex[0]][maxIndex[1]] > 0) {
        longestPalindrome = s.charAt(maxIndex[1]) + longestPalindrome;
      }
      maxIndex[0]--;
      maxIndex[1]--;
    }
    return longestPalindrome;
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
