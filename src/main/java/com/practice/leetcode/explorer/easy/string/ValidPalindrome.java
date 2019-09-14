package com.practice.leetcode.explorer.easy.string;

import java.util.ArrayList;
import java.util.List;

public class ValidPalindrome {
  public static void main(String[] args) {
    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
  }

  public static boolean isPalindrome(String s) {
    if(s.equals("")) {
      return true;
    }
    char[] chars = s.toLowerCase().toCharArray();
    List<Character> characters = new ArrayList<>();
    for (int i = 0; i < chars.length; i++) {
      if(Character.isLetterOrDigit(chars[i])) {
        characters.add(chars[i]);
      }
    }
    for (int i = 0,j = characters.size()-1; j-i > 0; i++,j--) {
      if(characters.get(i)!=characters.get(j)) {
        return false;
      }
    }
    return true;
  }
}
