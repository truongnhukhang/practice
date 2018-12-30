package com.practice.queue;


public class QueueImplementSimple<T> {
  public Node<T> first;
  public Node<T> last;

  public void add(T data) {
    Node<T> tmp = new Node<>();
    tmp.data = data;
    if(first==null) {
      first = last = tmp;
    } else {
      last.prv = tmp;
      last = tmp;
    }
  }

  public T get() {
    T data = first.data;
    first = first.prv;
    return data;
  }

}
