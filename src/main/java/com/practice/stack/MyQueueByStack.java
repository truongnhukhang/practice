package com.practice.stack;

public class MyQueueByStack<T> {
  StackImplementSimple<T> stack_put = new StackImplementSimple<>();
  StackImplementSimple<T> stack_pop = new StackImplementSimple<>();

  public void put(T data) {
    stack_put.put(data);
  }

  public T pop() {
    if(stack_pop.peek()==null) {
      while (stack_put.peek()!=null) {
        stack_pop.put(stack_put.pop());
      }
    }
    return stack_pop.pop();
  }
}
