package com.practice.linkedList;

public class FindBreakElementInLinkedList {
  public static void main(String[] args) {
    CircularLinkedListImplementSimple<String> list = new CircularLinkedListImplementSimple<>();
    list.insert("A");
    list.insert("B");
    list.insert("C");
    list.insert("D");
    list.insert("E");
    System.out.println(findLastElement(list).data);
  }

  static Node<String> findLastElement(CircularLinkedListImplementSimple<String> list ) {
    Node<String> cursor = list.head;
    Node<String> cursorDoubleStep = list.head;
    while(cursor.next!=cursorDoubleStep.next.next) {
      cursor = cursor.next;
      cursorDoubleStep = cursorDoubleStep.next.next;
    }
    return cursor;
  }
}
