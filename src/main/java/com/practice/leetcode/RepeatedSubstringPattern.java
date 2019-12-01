package com.practice.leetcode;

public class RepeatedSubstringPattern {
  public static void main(String[] args) {
    RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
    System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("aa"));
    System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("aba"));
    System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("abcabcd"));
    System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("abcabcabc"));
    System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("bcbcbdc"));
    System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("c"));
    System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("cccccc"));
  }

  public boolean repeatedSubstringPattern(String s) {
    int len = s.length();
    for(int i = 2; i <= len ; i++) {
      if(len%i==0) {
        boolean repeated = true;
        int sublen = len/i;
        String prvSubStr = s.substring(0,sublen);
        for (int j=sublen;j<len;j=j+sublen) {
          String curSubStr = s.substring(j,j+sublen);
          if(!prvSubStr.equals(curSubStr)) {
            repeated = false;
            break;
          }
        }
        if(repeated) {
          return true;
        }
      }
    }
    return false;
  }
}
