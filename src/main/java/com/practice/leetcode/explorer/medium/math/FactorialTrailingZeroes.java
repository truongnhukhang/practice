package com.practice.leetcode.explorer.medium.math;

/**
 * Created by truongnhukhang on 12/17/19.
 */
public class FactorialTrailingZeroes {
  public static void main(String[] args) {
    FactorialTrailingZeroes factorialTrailingZeroes = new FactorialTrailingZeroes();
    System.out.println(factorialTrailingZeroes.trailingZeroes(101));
  }

  /**
   * https://www.purplemath.com/modules/factzero.htm
   * @param n
   * @return
   */
  public int trailingZeroes(int n) {
    int count = 0;
    while (n>0) {
      n = n/5;
      count = count+n;
    }
    return count;
  }
}
