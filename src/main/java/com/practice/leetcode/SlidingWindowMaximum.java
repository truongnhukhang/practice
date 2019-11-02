package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class SlidingWindowMaximum {

  public static void main(String[] args) {
    SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
    int[] nums = new int[]{9,8,7,6,5,3,2,1};
    int k = 3;
    IntStream.of(slidingWindowMaximum.maxSlidingWindow(nums,8)).forEach(num->System.out.print(" "+num));
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    LinkedList<Integer> deque = new LinkedList<>();
    ArrayList<Integer> resultIndex = new ArrayList<>();
    for (int i = 0; i < nums.length; i=i+1) {
      while (!deque.isEmpty() && deque.getFirst() < i+1-k) {
        deque.removeFirst();
      }
      while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
        deque.removeLast();
      }
      deque.add(i);
      if(i+1-k>=0) {
        System.out.println(deque.size());
        resultIndex.add(deque.getFirst());
      }
    }
    int[] result = new int[resultIndex.size()];
    for (int i = 0; i < resultIndex.size(); i++) {
      result[i] = nums[resultIndex.get(i)];
    }
    return result;
  }

  public int[] maxSlidingWindow(int[] nums, int k,int m) {
    LinkedList<Integer> deque = new LinkedList<>();
    ArrayList<Integer> resultIndex = new ArrayList<>();
    for (int i = 0; i < nums.length; i=i+1) {
      while (!deque.isEmpty() && deque.getFirst() < i+1-k) {
        deque.removeFirst();
      }
      while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
        deque.removeLast();
      }
      deque.add(i);
      if(i+1-k>=0) {
        System.out.println(deque.size());
        resultIndex.add(deque.getFirst());
      }
    }
    int[] result = new int[resultIndex.size()];
    for (int i = 0; i < resultIndex.size(); i++) {
      result[i] = nums[resultIndex.get(i)];
    }
    return result;
  }
}
