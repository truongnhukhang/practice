package com.practice.leetcode;

public class ContainerWithMostWater {

  public static void main(String[] args) {
    ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
    int[] height = {1,8,60,6,50,4,8,3,7};
    System.out.println(containerWithMostWater.maxArea(height));
  }

  public int maxArea(int[] height) {
    int maxArea = 0 ;
    int right = height.length-1;
    int left = 0;
    int tempArea = 0;
    while (left!=right) {
      if(height[left] < height[right]) {
        tempArea = height[left]*(right-left);
        left++;
      } else {
        tempArea = height[right]*(right-left);
        right--;
      }
      maxArea = maxArea < tempArea ? tempArea : maxArea;
    }
    return maxArea;
  }

}
