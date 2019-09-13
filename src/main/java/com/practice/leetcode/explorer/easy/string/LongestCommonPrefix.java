package com.practice.leetcode.explorer.easy.string;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {
  public static void main(String[] args) {
    String[] strs = {"flower","flow","flight"};
    System.out.println(longestCommonPrefix(strs));
  }

  public static String longestCommonPrefix(String[] strs) {
    if(strs.length==0) {
      return "";
    }
    int minLength = strs[0].length();
    for (int i = 1; i < strs.length; i++) {
      if(minLength > strs[i].length()) {
        minLength = strs[i].length();
      }
    }
    String longestCommonPrefix = "";
    for (int i = 0; i < minLength; i++) {
      String tempPrefix = String.valueOf(strs[0].charAt(i));
      for (int j = 1; j < strs.length; j++) {
        if(!String.valueOf(strs[j].charAt(i)).equals(tempPrefix)) {
          return longestCommonPrefix;
        }
      }
      longestCommonPrefix = longestCommonPrefix + tempPrefix;
    }
    return longestCommonPrefix;
  }
}
