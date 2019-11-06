package com.practice.leetcode.mock;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
  public int romanToInt(String s) {
    Map<Character,Integer> numberMap = new HashMap<>();
    numberMap.put('I', 1);
    numberMap.put('V', 5);
    numberMap.put('X', 10);
    numberMap.put('L', 50);
    numberMap.put('C', 100);
    numberMap.put('D', 500);
    numberMap.put('M', 1000);
    int num = 0;
    char prev = '\0';

    for(int i = s.length()-1; i >= 0; i--){
      char c = s.charAt(i);
      int add = numberMap.get(c);

      if (prev != '\0' && numberMap.get(prev) > numberMap.get(c)){
        add = -add;
      }

      num += add;
      prev = c;
    }
    return num;
  }
}
