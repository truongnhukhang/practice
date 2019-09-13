package com.practice.leetcode.explorer.easy.string;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
  public static void main(String[] args) {
    System.out.println(isAnagram("aabbcc","bbaac"));
  }

  static boolean isAnagram(String s, String t) {
    Map<Character,Integer> charCount = new HashMap<>();
    for (Character c : s.toCharArray()) {
     if(charCount.get(c)==null) {
       charCount.put(c,1);
     } else {
       charCount.put(c,charCount.get(c)+1);
     }
    }
    int tempCount = 0;
    for (Character c : t.toCharArray()) {
      if(charCount.get(c)==null) {
        return false;
      } else {
        tempCount = charCount.get(c)-1;
        if(tempCount==0) {
          charCount.remove(c);
        } else {
          charCount.put(c,tempCount);
        }
      }
    }
    if(charCount.size()>0) {
      return false;
    }
    return true;
  }
}
