package com.practice.leetcode.explorer.medium.linkedlist;

public class IntersectionOfTwoLinkedLists {
  public static void main(String[] args) {
    ListNode insertionNode = new ListNode(2);
    ListNode l1 = new ListNode(1);
    l1.next = insertionNode;
    l1.next.next = new ListNode(3);
    l1.next.next.next = new ListNode(4);
    l1.next.next.next.next = new ListNode(5);
    l1.next.next.next.next.next = new ListNode(6);
    l1.next.next.next.next.next.next = new ListNode(7);
    l1.next.next.next.next.next.next.next = new ListNode(8);
    ListNode l2 = new ListNode(10);
    l2.next = new ListNode(9);
    l2.next.next = insertionNode;
    System.out.println(getIntersectionNode(l1,l2).val);

  }

  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA==null || headB==null) {
      return null;
    }
    ListNode lastA = headA;
    ListNode lastB = headB;
    while (lastA.next!=null) {
      lastA = lastA.next;
    }
    while (lastB.next!=null) {
      lastB = lastB.next;
    }
    if(lastA!=lastB) {
      return null;
    }
    ListNode tempA = headA;
    ListNode tempB = headB;
    while (true) {
      if(tempA==tempB) {
        return tempA;
      }
      if(tempA==lastA) {
        tempA = headB;
      } else {
        tempA=tempA.next;
      }
      if(tempB==lastB) {
        tempB = headA;
      } else {
        tempB=tempB.next;
      }

    }
  }
}
