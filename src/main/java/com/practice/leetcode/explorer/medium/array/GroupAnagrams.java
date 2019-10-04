package com.practice.leetcode.explorer.medium.array;

import java.util.*;

public class GroupAnagrams {
  public static void main(String[] args) {
    String[] strs = {"eat"};
    groupAnagrams(strs).forEach(strings -> strings.forEach(System.out::println));
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    if(strs==null || strs.length < 1) {
      return Arrays.asList(Arrays.asList(""));
    }
    Map<String,List<String>> db = new HashMap<>();
    String sortString = "";
    char[] tempChars = null;
    for (int i = 0; i < strs.length; i++) {
      tempChars = strs[i].toCharArray();
      Arrays.sort(tempChars);
      sortString = new String(tempChars);
      if(db.get(sortString)!=null) {
        List<String> group = db.get(sortString);
        group.add(strs[i]);
      } else {
        List<String> group = new ArrayList<>();
        group.add(strs[i]);
        db.put(sortString,group);
      }
    }
    List<List<String>> groupAnagrams = new ArrayList<>();
    db.forEach((s, strings) -> groupAnagrams.add(strings));
    return groupAnagrams;
  }
}
