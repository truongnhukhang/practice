package com.practice.leetcode.explorer.easy.math;

import java.math.BigDecimal;

public class PowerOfThree {
  public static void main(String[] args) {
    System.out.println(isPowerOfThree(9));
    System.out.println(isPowerOfThree(0));
    System.out.println(isPowerOfThree(243));
  }

  public static boolean isPowerOfThree(int n) {
    return (Math.log10(n)/Math.log10(3))%1==0;
  }
}
