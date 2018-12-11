package com.practice.stack;

public class StackImplementSimple {
  public Node top;

  public void add(String data) {
    Node temp = new Node();
    temp.data = data;
    temp.next = top;
    top = temp;
  }

  public String get() {
    String data = top.data;
    top = top.next;
    return data;
  }
}
