package com.practice.leetcode.explorer.medium.backtracking;

import java.util.*;

public class LetterCombinations {
  Map<String,List<String>> phoneCharMap = new HashMap<>();

  public static void main(String[] args) {
    LetterCombinations letterCombinations = new LetterCombinations();
    letterCombinations.letterCombinations("").stream().forEach(s -> {
      System.out.println(s);
    });
  }

  public List<String> letterCombinations(String digits) {
    if(digits.length()==0) {
      return Arrays.asList();
    }
    phoneCharMap.put("2",Arrays.asList("a","b","c"));
    phoneCharMap.put("3",Arrays.asList("d","e","f"));
    phoneCharMap.put("4",Arrays.asList("g","h","i"));
    phoneCharMap.put("5",Arrays.asList("j","k","l"));
    phoneCharMap.put("6",Arrays.asList("m","n","o"));
    phoneCharMap.put("7",Arrays.asList("p","q","r","s"));
    phoneCharMap.put("8",Arrays.asList("t","u","v"));
    phoneCharMap.put("9",Arrays.asList("w","x","y","z"));
    Queue<String> digitsQueue = new ArrayDeque<>();
    List<String> result = new ArrayList<>();
    for (int i = 0; i < digits.length(); i++) {
      digitsQueue.add(String.valueOf(digits.charAt(i)));
    }
    String first = digitsQueue.poll();
    List<String> listChars = phoneCharMap.get(first);
    List<String> restCombination = letterCombinations(digitsQueue);
    for (int i = 0; i < listChars.size(); i++) {
      for (int j = 0; j < restCombination.size(); j++) {
        result.add(listChars.get(i)+restCombination.get(j));
      }
    }
    return result;
  }

  public List<String> letterCombinations(Queue<String> digitsQueue) {
    if(digitsQueue.size()==0) {
      return Arrays.asList("");
    }
    List<String> result = new ArrayList<>();
    String first = digitsQueue.poll();
    List<String> listChars = phoneCharMap.get(first);
    List<String> restCombination = letterCombinations(digitsQueue);
    for (int i = 0; i < listChars.size(); i++) {
      for (int j = 0; j < restCombination.size(); j++) {
        result.add(listChars.get(i)+restCombination.get(j));
      }
    }
    return result;
  }
}
