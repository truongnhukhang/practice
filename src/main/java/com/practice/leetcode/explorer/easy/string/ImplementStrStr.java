package com.practice.leetcode.explorer.easy.string;

public class ImplementStrStr {
  public static void main(String[] args) {
    System.out.println(strStr("1hello","o"));
  }

  public static int strStr(String haystack, String needle) {
    if(needle.equals("")) {
      return 0;
    }
    char[] chars = haystack.toCharArray();
    char firstNeedleChar = needle.charAt(0);
    String temp = "";
    int maxIndex = chars.length-needle.length();
    for (int i = 0; i <= maxIndex; i++) {
      if(firstNeedleChar==chars[i]) {
        temp = haystack.substring(i,i+needle.length());
        if(temp.equals(needle)) {
          return i;
        }
      }
    }
    return -1;
  }
}
