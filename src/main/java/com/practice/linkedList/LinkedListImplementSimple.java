package com.practice.linkedList;

public class LinkedListImplementSimple<T> {
  Node<T> head;
  Node<T> tail;

  public Node insert(T data) {
    Node node = new Node();
    node.data = data;
    if(head==null) {
      head = tail = node;
    } else {
      tail.next = node;
      tail = node;
    }
    return node;
  }

  public void delete(T data) {
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
    Node tmp = head;
    Node prv = head;
    while(tmp!=null) {
      Node cursor = tmp.next;
      while(cursor!=null) {
        if(!tmp.data.equals(cursor.data)) {
          prv = cursor;
        } else {
          prv.next = cursor.next;
        }
        cursor = cursor.next;
      }
      tmp = tmp.next;
      prv = tmp;
    }
  }

  public T getNthElementFromLastIndex(int indexFromLast) {
    int count = 0;
    Node<T> tmp = head;
    while(tmp!=null) {
      tmp=tmp.next;
      count++;
    }
    tmp = head;
    int index = count-indexFromLast+1;
    count=0;
    while (tmp!=null) {
      count++;
      if(index==count) {
        return tmp.data;
      } else {
        tmp = tmp.next;
      }
    }
    return null;
  }

  public void removeNodeWithoutHeadOnlyAccessRemovedNode(Node<T> node) {
    while (node!=null) {
      if(node.next==null) {
        node.data = null;
        break;
      } else {
        T temp = node.next.data;
        node.next.data = node.data;
        node.data = temp;
      }
      node = node.next;
    }
  }
}
