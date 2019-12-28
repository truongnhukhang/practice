package com.practice.leetcode.mock.PhoneInterview;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxStack {

  LinkedList<Integer> db = null;
  PriorityQueue<Integer> maxDb = null;
  /** initialize your data structure here. */
  public MaxStack() {
    db = new LinkedList<>();
    maxDb = new PriorityQueue<>((o1,o2)->{return o2-o1;});
  }

  public void push(int x) {
    db.addFirst(x);
    maxDb.offer(x);
  }

  public int pop() {
    int result = db.getFirst();
    db.removeFirst();
    maxDb.remove(result);
    return result;
  }

  public int top() {
    return db.getFirst();
  }

  public int peekMax() {
    return maxDb.peek();
  }

  public int popMax() {
    int max = maxDb.poll();
    db.removeFirstOccurrence(max);
    return max;
  }
}
