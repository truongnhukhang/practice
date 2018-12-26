package com.practice.bit;

import java.util.Arrays;

public class PlusTwoNumber {
  public static void main(String[] args) {
    int[] num1 = {1,1,1,1};
    int[] num2 = {1,1,1,1};
    Arrays.stream(plusTwoNumber(num1,num2)).forEach(System.out::print);
  }

  static int[] plusTwoNumber(int[] num1,int[] num2) {
    int[] result = new int[num1.length+1];
    int carry = 0;
    int orginalResultAndCarry;
    for( int i = num1.length-1;i > -1;i--) {
      orginalResultAndCarry = num1[i]+num2[i]+carry;
      result[i+1] = orginalResultAndCarry%2;
      carry = orginalResultAndCarry/2;
    }
    result[0]=carry;
    return result;
  }
}
