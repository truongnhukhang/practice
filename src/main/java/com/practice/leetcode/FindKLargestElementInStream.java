package com.practice.leetcode;

import java.util.PriorityQueue;

public class FindKLargestElementInStream {
  public static void main(String[] args) {
    int[] arr = new int[]{4, 5, 8, 2};
    KthLargest kthLargest = new FindKLargestElementInStream.KthLargest(3, arr);
    System.out.println(kthLargest.add(3));
    System.out.println(kthLargest.add(5));
    System.out.println(kthLargest.add(10));
    System.out.println(kthLargest.add(9));
    System.out.println(kthLargest.add(4));
  }

  private static class KthLargest {
    int k;
    PriorityQueue<Integer> minQueue = null;

    public KthLargest(int k, int[] arr) {
      this.k = k;
      minQueue = new PriorityQueue<>();
      for (int i = 0; i < arr.length; i++) {
        add(arr[i]);
      }

    }

    public int add(int val) {
      if (minQueue.size() == k) {
        if (minQueue.peek() < val) {
          minQueue.poll();
          minQueue.offer(val);
        }
        return minQueue.peek();
      }
      minQueue.offer(val);
      return minQueue.peek();
    }
  }
}

