package com.practice.leetcode.explorer.medium.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacter {
  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("dgsdgsdgstewzscbsdg"));
  }

  public static int lengthOfLongestSubstring(String s) {
    if(s.length()==0) {
      return 0;
    }
    Map<Character,Integer> charIndexMap = new HashMap<>(s.length());
    int maxCount = 1;
    int tempCount = 1;
    charIndexMap.put(s.charAt(0),0);
    for (int i = 1; i < s.length(); i++) {
      Integer charIndex = charIndexMap.get(s.charAt(i));
      if(charIndex !=null) {
        i = charIndex +1;
        maxCount = tempCount > maxCount ? tempCount : maxCount;
        charIndexMap.clear();
        tempCount = 1;
        charIndexMap.put(s.charAt(i),i);
      } else {
        charIndexMap.put(s.charAt(i),i);
        tempCount = tempCount + 1;
      }
    }
    maxCount = tempCount > maxCount ? tempCount : maxCount;
    return maxCount;
  }
}
