package com.practice.leetcode.explorer.medium.backtracking;

import java.util.*;

public class GenerateParentheses {
  public static void main(String[] args) {
    GenerateParentheses generateParentheses = new GenerateParentheses();
    generateParentheses.generateParenthesis(4).stream().forEach(System.out::println);
  }

  public List<String> generateParenthesis(int n) {
    if(n==0) {
      return Arrays.asList();
    }
    List<String> openQueue = new ArrayList<>();
    List<String> closeQueue = new ArrayList<>();
    List<String> result = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      openQueue.add("(");
      closeQueue.add(")");
    }
    String first = openQueue.get(0);
    int count = 1;
    List<String> parenthesis = generateParenthesis(openQueue,1,closeQueue,0,count);
    for (int i = 0; i < parenthesis.size(); i++) {
      result.add(first+parenthesis.get(i));
    }
    return result;
  }

  public List<String> generateParenthesis(List<String> openList,int openIndex
      ,List<String> closeList,int closeIndex,int count) {
    if(openList.size()==openIndex && closeList.size()-closeIndex==1) {
      return Arrays.asList(")");
    }
    List<String> result = new ArrayList<>();
    if(openList.size()>openIndex) {
      String first = openList.get(openIndex);
      List<String> parenthesis = generateParenthesis(openList,openIndex+1,closeList,closeIndex,count+1);
      for (int i = 0; i < parenthesis.size(); i++) {
        result.add(first+parenthesis.get(i));
      }
    }
    if(closeList.size()>closeIndex && count-1>=0) {
      String first = closeList.get(closeIndex);
      List<String> parenthesis = generateParenthesis(openList,openIndex,closeList,closeIndex+1,count-1);
      for (int i = 0; i < parenthesis.size(); i++) {
        result.add(first+parenthesis.get(i));
      }

    }
    return result;
  }
}
