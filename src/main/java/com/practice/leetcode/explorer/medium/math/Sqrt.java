package com.practice.leetcode.explorer.medium.math;

public class Sqrt {
  public static void main(String[] args) {
    System.out.println(new Sqrt().mySqrt(2147483647));
  }
  public int mySqrt(int x) {
    int half = x/2 + 1;
    for (int i = 2; i <= half ; i++) {
      int powOfTwo = i * i;
      if(powOfTwo ==x) {
        return i;
      }
      if(powOfTwo >x || powOfTwo < 0) {
        return i-1;
      }
    }
    return 1;
  }
}
