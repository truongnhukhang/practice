package com.practice.leetcode.explorer.easy.array;

import java.util.stream.IntStream;

/**
 * Created by truongnhukhang on 8/19/19.
 */
public class RotateArrayByKSteps {
  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6,7};
    int k = 8;
    rotate(nums,k);
    IntStream.of(nums).forEach(System.out::println);
  }

  public static void rotate(int[] nums, int k) {
    while(k>nums.length) {
      k = k - nums.length;
    }
    int[] subRotateArray = new int[k];
    System.arraycopy(nums,nums.length-k,subRotateArray,0,k);
    shiftRightArrayTo(k,nums);
    for (int i = 0; i < k; i++) {
      nums[i] = subRotateArray[i];
    }
  }

  public static void shiftRightArrayTo(int steps, int[] array) {
    int maxIndex = array.length-1;
    for (int i = maxIndex-steps; i > -1; i--) {
      array[i+steps] = array[i];
    }
  }

}
