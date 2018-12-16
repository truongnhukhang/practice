package com.practice.linkedList;

public class LinkedListImplementSimple {
  Node head;
  Node tail;

  public void insert(String data) {
    Node node = new Node();
    node.data = data;
    if(head==null) {
      head = tail = node;
    } else {
      tail.next = node;
      tail = node;
    }
  }

  public void delete(String data) {
    Node tmp = head;
    Node prv = null;
    while(tmp!=null) {
      if(tmp.data.equals(data)) {
        if(prv!=null) {
          prv.next = tmp.next;
        } else {
          head = tmp.next;
        }
      } else {
        prv = tmp;
      }
      tmp = tmp.next;
    }

  }

  public void println() {
    Node tmp = head;
    while(tmp!=null) {
      System.out.println(tmp.data);
      tmp = tmp.next;
    }
  }

  public void removeDuplicateNodeUnsortedlist() {

  }
}
