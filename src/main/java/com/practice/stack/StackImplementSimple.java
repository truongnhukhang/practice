package com.practice.stack;

public class StackImplementSimple<T> {
  public Node<T> top;
  public int emptySlots = 5;
  public void put(T data) {
    Node<T> temp = new Node<>();
    temp.data = data;
    temp.next = top;
    top = temp;
    emptySlots--;
  }

  public T pop() {
    if(top!=null) {
      T data = top.data;
      top = top.next;
      return data;
    }
    return null;
  }

  public T peek() {
    return top==null ? null : top.data;
  }
}
