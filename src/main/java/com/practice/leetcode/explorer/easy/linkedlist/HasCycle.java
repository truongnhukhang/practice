package com.practice.leetcode.explorer.easy.linkedlist;

public class HasCycle {
  public static void main(String[] args) {
    ListNode head = new ListNode(3);
    head.next = head;
//    ListNode next = new ListNode(2);
//    head.next = next;
//    head.next.next = head.next;
//    head.next.next = new ListNode(0);
//    head.next.next.next = new ListNode(-4);
//    head.next.next.next.next = next;
    System.out.println(hasCycle(head));
  }

  public static boolean hasCycle(ListNode head) {
    if(head==null) {
      return false;
    }
    ListNode checkNode = null;
    ListNode nextNode = head;
    while (nextNode.next!=null) {
      checkNode = head;
      nextNode = nextNode.next;
      if(nextNode!=nextNode.next) {
        while (checkNode!=nextNode) {
          if(checkNode==nextNode.next) {
            return true;
          } else {
            checkNode = checkNode.next;
          }
        }
      } else {
        return true;
      }
    }
    return false;
  }
}
