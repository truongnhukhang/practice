package com.practice.leetcode.explorer.medium.sortingAndSearching;

public class SearchInRotatedSortedArray {
  public static void main(String[] args) {
    int[] nums ={4,5,6,7,0,1,2};
    int target = 3;
    SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
    System.out.println(searchInRotatedSortedArray.search(nums,target));
  }

  public int search(int[] nums, int target) {
    if(nums.length==0) {
      return -1;
    }
    int min=0;
    int max=nums.length-1;
    int guess = 0;
    int minP1=nums[0];
    int maxP2=nums[max];
    if(target >= minP1) {
      // target in P1
      while(min<=max) {
        guess = (min+max)/2;
        if(nums[guess]==target) {
          return guess;
        } else if(nums[guess] < target) {
          if(nums[guess] < minP1) {
            // guess in p2;
            max = guess-1;
          } else {
            min = guess+1;
          }
        } else {
          max = guess-1;
        }

      }
    } else {
      // target in P2
      while(min<=max) {
        guess = (min+max)/2;
        if(nums[guess]==target) {
          return guess;
        } else if(nums[guess] < target) {
          // guess in p2
          min = guess + 1;
        } else {
          if(nums[guess] > maxP2) {
            // guess in p1;
            min = guess+1;
          } else {
            max = guess-1;
          }
        }

      }
    }
    return -1;
  }
}
