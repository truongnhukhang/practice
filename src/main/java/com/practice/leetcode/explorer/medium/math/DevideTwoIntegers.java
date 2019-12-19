package com.practice.leetcode.explorer.medium.math;

/**
 * Created by truongnhukhang on 12/19/19.
 */
public class DevideTwoIntegers {
  public static void main(String[] args) {
    System.out.println(new DevideTwoIntegers().divide(-2147483648
        ,-1));
  }

  public int divide(int dividend, int divisor) {
    long newDividend = dividend < 0 ? Long.valueOf(dividend)*-1 : dividend;
    long newDivisor = divisor < 0 ? Long.valueOf(divisor)*-1 : divisor;
    int result = 0;
    while (newDividend>=newDivisor) {
      newDividend = newDividend-newDivisor;
      if(result+1 >= Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      }
      result++;
    }
    if(dividend < 0 ) {
      result = result * -1;
    }
    if(divisor < 0 ) {
      result = result * -1;
    }
    return result;
  }
}
