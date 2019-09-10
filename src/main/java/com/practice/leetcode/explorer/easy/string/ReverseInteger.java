package com.practice.leetcode.explorer.easy.string;

import java.util.ArrayDeque;
import java.util.Queue;

public class ReverseInteger {
  public static void main(String[] args) {
    System.out.println(reverse(-120));
  }

  public static int reverse(int x) {
    int count = -1;
    Queue<Integer> integerQueue = new ArrayDeque<>();
    while (x!=0) {
      integerQueue.add(x%10);
      x=x/10;
      count++;
    }
    Double result = (double)0;
    while (!integerQueue.isEmpty()) {
      result = result + integerQueue.poll()*Math.pow(10,count);
      count--;
    }
    if(Integer.MAX_VALUE < result || result < Integer.MIN_VALUE) {
      return 0;
    }
    return result.intValue();
  }
}
