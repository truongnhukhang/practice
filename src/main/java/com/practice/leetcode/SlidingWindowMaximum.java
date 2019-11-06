package com.practice.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class SlidingWindowMaximum {

  public static void main(String[] args) throws IOException {
    SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
    int[] nums = new int[]{9,8,7,6,5,3,2,1};
    int k = 3;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    Integer windowSize = Integer.valueOf(input);
    input = br.readLine();
    LinkedList<Integer> deque = new LinkedList<>();
    deque.add(Integer.valueOf(input));
    int count = 1;
    while (true) {
      input = br.readLine();
      if(input==null) {
        break;
      }
      Integer value = Integer.valueOf(input);
      while (!deque.isEmpty() && deque.size() > windowSize) {
        deque.removeFirst();
      }
      while (!deque.isEmpty() && deque.getLast() < value) {
        deque.removeLast();
      }
      deque.add(value);
      count++;
      if(count>=windowSize) {
        System.out.println(deque.getFirst());
      }
    }
//    IntStream.of(slidingWindowMaximum.maxSlidingWindow(nums,8)).forEach(num->System.out.print(" "+num));
  }


//  public int maxSlidingWindow(int num,int k) {
//    LinkedList<Integer> deque = new LinkedList<>();
//
//  }

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
