package com.practice.linkedList;

/**
 * Created by truongnhukhang on 12/28/18.
 */
public class CircularLinkedListImplementSimple<T> {
  public Node<T> head;
  Node<T> current;

  public void insert(T data) {
    Node<T> temp = new Node<>();
    temp.data = data;
    if(head==null) {
      head = current = temp;
    } else {
      current.next = temp;
      current = temp;
    }
    temp.next = head;
  }

  public void println() {
    Node tmp = head;
    while(tmp!=null) {
      System.out.println(tmp.data);
      if(tmp==current) {
        break;
      }
      tmp = tmp.next;

    }
  }
}
