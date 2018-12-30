package com.practice.stack;

public class PopPutMinO1Stack_v2 extends StackImplementSimple<Integer> {
  StackImplementSimple<Integer> minStack = new StackImplementSimple<>();

  @Override
  public void add(Integer data) {
    Integer currentMin = minStack.peek();
    if (currentMin != null && data <= currentMin) {
      minStack.add(data);
    }
    if(currentMin==null) {
      minStack.add(data);
    }
    super.add(data);
  }

  @Override
  public Integer get() {
    Integer result = super.get();
    if (result.equals(getMin())) {
      minStack.get();
    }
    return result;
  }

  public Integer getMin() {
    return minStack.peek();
  }
}
