package com.practice.stack;

import java.util.LinkedList;

public class SetOfStacks<T> {
  LinkedList<StackImplementSimple<T>> stackList = new LinkedList<>();

  public void push(T data) {
    if(stackList.size()==0 || stackList.getLast().emptySlots==0) {
      StackImplementSimple<T> stackImplementSimple = new StackImplementSimple<>();
      stackList.add(stackImplementSimple);
      stackImplementSimple.put(data);
    } else {
      stackList.getLast().put(data);
    }
  }

  public T pop() {
    if(stackList.size()!=0) {
      T result = stackList.getLast().pop();
      if(stackList.getLast().top==null) {
        stackList.removeLast();
      }
      return result;
    }
    return null;
  }
}
