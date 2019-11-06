package com.practice.leetcode.mock;

import java.util.Stack;

public class MyQueue {
  Stack<Integer> stackPut = null;
  Stack<Integer> stackPop = null;

  public MyQueue() {
    stackPut =  new Stack<>();
    stackPop = new Stack<>();
  }

  public void push(int x) {
    stackPut.push(x);
  }

  public int pop() {
    if(stackPop.isEmpty()) {
      while (!stackPut.isEmpty()) {
        stackPop.push(stackPut.pop());
      }
    }
    return stackPop.pop();
  }

  /** Get the front element. */
  public int peek() {
    if(stackPop.isEmpty()) {
      while (!stackPut.isEmpty()) {
        stackPop.push(stackPut.pop());
      }
    }
    return stackPop.peek();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return stackPut.isEmpty() && stackPop.isEmpty();
  }
}
