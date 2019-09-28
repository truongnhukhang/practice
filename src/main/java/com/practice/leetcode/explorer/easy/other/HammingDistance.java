package com.practice.leetcode.explorer.easy.other;

public class HammingDistance {
  public static void main(String[] args) {
    System.out.println(hammingDistance(1,4));
  }

  public static int hammingDistance(int x, int y) {
    int temp = x^y;
    int count = 0;
    while (temp!=0) {
      if(temp%2==1) {
        count++;
      }
      temp=temp/2;
    }
    return count;
  }
}
