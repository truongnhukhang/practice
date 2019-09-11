package com.practice.leetcode.explorer.easy.string;

public class ValidAnagram {
  public static void main(String[] args) {
    System.out.println(isAnagram("aa","bb"));
  }

  static boolean isAnagram(String s, String t) {
    char[] sChars = s.toCharArray();
    char[] tChars = t.toCharArray();
    int charsXor = 0;
    for (int i = 0; i < sChars.length; i++) {
      charsXor = charsXor ^ sChars[i];
    }
    for (int i = 0; i < tChars.length; i++) {
      charsXor = charsXor ^ tChars[i];
    }
    return charsXor==0;
  }
}
