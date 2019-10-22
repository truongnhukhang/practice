package com.practice.leetcode.explorer.medium.sortingAndSearching;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by truongnhukhang on 8/16/19.
 */
public class SortColor {
  public static void main(String[] args) {
    int[] colors = {1,0,0,2,1,0,2,2,1,2,0,1};
    sortColors(colors);
    System.out.println(Arrays.stream(colors).mapToObj(String::valueOf).collect(Collectors.joining(",")));

  }

  public static void sortColors(int[] nums) {
    int maxOfMin = 0;
    int minOfMax = nums.length-1;
    for (int i = 0; i < nums.length; i++) {
      if(nums[i]==0) {
        if(i>maxOfMin) {
          swap(nums,i,maxOfMin);
        }
        maxOfMin++;
      }
    }
    for (int i = nums.length-1; i >= 0; i--) {
      if(nums[i]==2) {
        if(i<minOfMax) {
          swap(nums,i,minOfMax);
        }
        minOfMax--;

      }
    }
  }

  public static void swap(int[] a, int x ,int y) {
    a[x] = a[x] ^ a[y];
    a[y] = a[x] ^ a[y];
    a[x] = a[x] ^ a[y];
  }
}
