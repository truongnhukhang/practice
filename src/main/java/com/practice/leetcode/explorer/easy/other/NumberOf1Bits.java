package com.practice.leetcode.explorer.easy.other;

public class NumberOf1Bits {
  public static void main(String[] args) {
    System.out.println(hammingWeight(-3));
  }

  public static int hammingWeight(int n) {
    if (n < 0) {
      int[] bit = new int[32];
      int[] bit_1 = new int[32];
      bit_1[31] = 1;
      n = n*-1;
      int index = 31;
      while (n != 0) {
        bit[index] = n % 2;
        n = n / 2;
        index--;
      }
      for (int i = 0; i < bit.length; i++) {
        bit[i] = bit[i]==0 ? 1 : 0;
      }
      int carry = 0;
      int temp = 0;
      for (int i = bit.length-1; i >= 0 ; i--) {
        temp = bit[i] + bit_1[i] + carry;
        bit[i] = temp % 2;
        carry = temp / 2;
      }
      int count = 0 ;
      for (int i = 0; i < bit.length; i++) {
        if(bit[i]==1) {
          count++;
        }
      }
      return count;
    } else {
      int count = 0;
      while (n != 0) {
        if (n % 2 == 1) {
          count++;
        }
        n = n / 2;
      }
      return count;
    }
  }

}
