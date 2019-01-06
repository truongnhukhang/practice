package com.practice.stack;

public class PopPutMinO1Stack_v2 extends StackImplementSimple<Integer> {
  StackImplementSimple<Integer> minStack = new StackImplementSimple<>();

  @Override
  public void put(Integer data) {
    Integer currentMin = minStack.peek();
    if (currentMin != null && data <= currentMin) {
      minStack.put(data);
    }
    if(currentMin==null) {
      minStack.put(data);
    }
    super.put(data);
  }

  @Override
  public Integer pop() {
    Integer result = super.pop();
    if (result.equals(getMin())) {
      minStack.pop();
    }
    return result;
  }

  public Integer getMin() {
    return minStack.peek();
  }
}
