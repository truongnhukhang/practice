package com.practice.leetcode;

public class ProductOfArrayExceptSelf {

  public static void main(String[] args) {

  }

  public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];
    int product  = 1;
    for (int i = 0; i < nums.length; i++) {
      product = product*nums[i];
    }

  }
}
