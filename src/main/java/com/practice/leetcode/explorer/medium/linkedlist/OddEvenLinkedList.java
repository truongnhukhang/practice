package com.practice.leetcode.explorer.medium.linkedlist;

public class OddEvenLinkedList {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(3);
    l1.next.next.next = new ListNode(4);
    l1.next.next.next.next = new ListNode(5);
    l1.next.next.next.next.next = new ListNode(6);
    l1.next.next.next.next.next.next = new ListNode(7);
    l1.next.next.next.next.next.next.next = new ListNode(8);
    l1 = oddEvenList(l1);
    System.out.println(l1.next.val);
  }

  public static ListNode oddEvenList(ListNode head) {
    ListNode prv = head;
    ListNode firstSwap = null;
    ListNode lastSwap = null;
    ListNode current = head.next;
    if(current!=null && current.next!=null) {
      while (current!=null) {
        ListNode next = current.next;
        swap(prv,current,next);
        if(firstSwap==null) {
          firstSwap = next;
        }
        if(current.next==lastSwap || current.next.next==lastSwap) {
          lastSwap = current;
          if(firstSwap.next==lastSwap) {
            break;
          }
          current = firstSwap.next;
          prv = firstSwap;
          firstSwap = null;
        } else {
          prv = current;
          current = current.next;
        }
      }
    }
    return head;
  }

  private static void swap(ListNode prv, ListNode current, ListNode next) {
    prv.next = next;
    current.next = next.next!=null ? next.next : null;
    next.next = current;
  }
}
