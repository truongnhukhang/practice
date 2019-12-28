package com.practice.leetcode.explorer.medium.sortingAndSearching;

public class SearchForRange {
  public static void main(String[] args) {
    int[] nums = {5,7,7,8,8,10};
    SearchForRange searchForRange = new SearchForRange();
    int[] result = searchForRange.searchRange(nums, 8);
    System.out.println(result[0] + " - " + result[1]);
  }

  public int[] searchRange(int[] nums, int target) {
    if(nums.length==0) {
      return new int[]{-1,-1};
    }
    int lowerMin = 0;int lowerMax = nums.length-1;
    int lower = (lowerMin+lowerMax)/2;
    int upperMin = 0;int upperMax = nums.length-1;
    int upper = (upperMin+upperMax)/2;
    boolean findLower = false;
    boolean findUpper = false;
    while(!findLower || !findUpper) {
      int lowerVal = nums[lower];
      int upperVal = nums[upper];
      if(lowerMin > lowerMax || upperMin > upperMax) {
        return new int[]{-1,-1};
      }
      if(lowerVal>=target) {
        if(lowerVal==target && (lower==0 || (lower-1>=0 && nums[lower-1] < target))) {
          findLower = true;
        } else {
          lowerMax = lower-1;
          lower = (lowerMin+lowerMax)/2;
        }
      } else {
        lowerMin = lower+1;
        lower = (lowerMin+lowerMax)/2;
      }
      if(upperVal <= target) {
        if(upperVal==target && (upper==nums.length-1 || (upper+1<nums.length && nums[upper+1] > target))) {
          findUpper = true;
        } else {
          upperMin = upper+1;
          upper = (upperMin+upperMax)/2;
        }
      } else {
        upperMax = upper - 1;
        upper = (upperMin+upperMax)/2;
      }
    }
    int[] result = new int[2];
    result[0]=lower;
    result[1]=upper;
    return result;
  }
}
