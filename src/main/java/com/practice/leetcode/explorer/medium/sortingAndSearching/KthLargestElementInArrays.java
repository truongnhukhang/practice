package com.practice.leetcode.explorer.medium.sortingAndSearching;

import java.util.PriorityQueue;

public class KthLargestElementInArrays {
  public static void main(String[] args) {
    int[] nums = {1,3,4,2,5,8,7,6};
    int k = 4;
    KthLargestElementInArrays kthLargestElementInArrays = new KthLargestElementInArrays();
    System.out.println(kthLargestElementInArrays.findKthLargest(nums,k));
  }

  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> kQueue = new PriorityQueue<>(k);
    int len = nums.length;
    for(int i=0; i<len; i++) {
      if(kQueue.size()==k) {
        int top = kQueue.peek();
        if(nums[i] > top) {
          kQueue.poll();
          kQueue.offer(nums[i]);
        }
      } else {
        kQueue.offer(nums[i]);
      }
    }
    return kQueue.peek();
  }
}
