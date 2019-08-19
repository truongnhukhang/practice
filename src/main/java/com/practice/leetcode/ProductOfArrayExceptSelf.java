package com.practice.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductOfArrayExceptSelf {

  public static void main(String[] args) {
    int[] nums = {1,2,3,4};
    int[] result = productExceptSelf(nums);
    System.out.println(Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(",")));
  }

  public static  int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];
    int maxIndex = nums.length - 1;
    int[] increaseIndexArrayProduct = new int[nums.length];
    int[] decreaseIndexArrayProduct = new int[nums.length];
    increaseIndexArrayProduct[0] = nums[0];
    increaseIndexArrayProduct[maxIndex] = nums[maxIndex];
    decreaseIndexArrayProduct[0] = nums[maxIndex];
    decreaseIndexArrayProduct[maxIndex] = nums[0];
    for (int i = 1; i <= maxIndex-1; i++) {
      increaseIndexArrayProduct[i] = increaseIndexArrayProduct[i-1]*nums[i];
      decreaseIndexArrayProduct[i] = decreaseIndexArrayProduct[i-1]*nums[maxIndex-i];
    }
    result[0] = decreaseIndexArrayProduct[maxIndex - 1];
    result[maxIndex] = increaseIndexArrayProduct[maxIndex-1];
    for (int i = 1; i <= maxIndex-1; i++) {
      result[i] = increaseIndexArrayProduct[i-1]*decreaseIndexArrayProduct[maxIndex-(i+1)];
    }
    return result;
  }
}
