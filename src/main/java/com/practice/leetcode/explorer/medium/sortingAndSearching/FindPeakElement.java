package com.practice.leetcode.explorer.medium.sortingAndSearching;

public class FindPeakElement {
  public static void main(String[] args) {
    int[] nums = {1};
    FindPeakElement findPeakElement = new FindPeakElement();
    System.out.println(findPeakElement.findPeakElement(nums));
  }
  /**
   * Binary Search :
   * if nums[middle] < num[middle+1] ->  peak on the right side
   * if nums[middle] < num[middle-1] ->  peak on the Left side
   * if nums[middle] > num[middle-1] && if nums[middle] > num[middle+1] ->  return middle
   */
  public int findPeakElement(int[] nums) {
    int middle = (nums.length-1)/2;
    int prv = middle-1;
    int next = middle+1;
    int valMiddle = nums[middle];
    int valPrv = prv<0 ? Integer.MIN_VALUE : nums[prv];
    int valNext = next>nums.length-1 ? Integer.MIN_VALUE : nums[next];
    if(valMiddle>valNext && valMiddle>valPrv) {
      return middle;
    }
    if(valMiddle<valNext) {
      return findPeakElement(nums,middle+1,nums.length-1);
    }
    if(valMiddle<valPrv) {
      return findPeakElement(nums,0,middle-1);
    }
    return middle;
  }

  public int findPeakElement(int[] nums,int from,int to) {
    int middle = (from+to)/2;
    int prv = middle-1;
    int next = middle+1;
    int valMiddle = nums[middle];
    int valPrv = prv<0 ? Integer.MIN_VALUE : nums[prv];
    int valNext = next>nums.length-1 ? Integer.MIN_VALUE : nums[next];
    if(valMiddle>valNext && valMiddle>valPrv) {
      return middle;
    }
    if(valMiddle<valNext) {
      return findPeakElement(nums,middle+1,to);
    }
    if(valMiddle<valPrv) {
      return findPeakElement(nums,from,middle-1);
    }
    return middle;
  }
}
