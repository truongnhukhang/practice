package com.practice.queue;

import com.practice.Node.Node;

public class QueueImplementSimple {
  public Node first;
  public Node last;

  public void add(String data) {
    Node tmp = new Node();
    tmp.data = data;
    if(first==null) {
      first = last = tmp;
    } else {
      last.prv = tmp;
      last = tmp;
    }
  }

  public String get() {
    String data = first.data;
    first = first.prv;
    return data;
  }

}
