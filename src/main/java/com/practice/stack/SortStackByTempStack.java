package com.practice.stack;

public class SortStackByTempStack {
  public static void main(String[] args) {
    StackImplementSimple<Integer> sources = new StackImplementSimple<>();
    sources.put(4);
    sources.put(1);
    sources.put(2);
    sources.put(6);
    StackImplementSimple<Integer> result = sortStack(sources);
    while (result.peek()!=null) {
      System.out.println(result.pop());
    }
  }

  static StackImplementSimple<Integer> sortStack(StackImplementSimple<Integer> source) {
    StackImplementSimple<Integer> result = new StackImplementSimple<>();
    while (source.peek()!=null) {
      Integer tempSource = source.pop();
      if(result.peek()==null) {
        result.put(tempSource);
      } else {
        findTheRightPosition(tempSource,result,source);
      }
    }
    return result;
  }

  private static void findTheRightPosition(Integer tempSource, StackImplementSimple<Integer> result, StackImplementSimple<Integer> source) {
    if(tempSource<result.peek()) {
      result.put(tempSource);
    } else {
      source.put(result.pop());
      findTheRightPosition(tempSource,result,source);
    }
  }
}
