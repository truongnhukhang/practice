package com.practice.stack;

public class StackImplementSimple<T> {
  public Node<T> top;

  public void add(T data) {
    Node<T> temp = new Node<>();
    temp.data = data;
    temp.next = top;
    top = temp;
  }

  public T get() {
    T data = top.data;
    top = top.next;
    return data;
  }

  public T peek() {
    return top==null ? null : top.data;
  }
}
