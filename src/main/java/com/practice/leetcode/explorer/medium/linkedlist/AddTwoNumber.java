package com.practice.leetcode.explorer.medium.linkedlist;

public class AddTwoNumber {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(6);

    ListNode L2 = new ListNode(0);
    L2.next = new ListNode(6);
    L2.next.next = new ListNode(4);

    ListNode sum = addTwoNumbers(l1,L2);
    while (sum!=null) {
      System.out.println(sum.val);
      sum = sum.next;
    }
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode currentL1 = l1;
    ListNode currentL2 = l2;
    int tempSum = currentL1.val+currentL2.val;
    ListNode currentSum = null;
    ListNode result = null;
    int carry = 0;
    if(tempSum>=10) {
      result = new ListNode(tempSum%10);
    } else {
      result = new ListNode(tempSum);
    }
    currentSum = result;
    carry = tempSum/10;
    while (currentL2.next!=null && currentL1.next!=null) {
      currentL1 = currentL1.next;
      currentL2 = currentL2.next;
      tempSum = currentL1.val+currentL2.val + carry;
      if(tempSum>=10) {
        currentSum.next = new ListNode(tempSum%10);
      } else {
        currentSum.next = new ListNode(tempSum);
      }
      carry = tempSum/10;
      currentSum = currentSum.next;
    }
    if(currentL1.next!=null) {
      while (currentL1.next!=null) {
        currentL1 = currentL1.next;
        tempSum = currentL1.val + carry;
        if(tempSum>=10) {
          currentSum.next = new ListNode(tempSum%10);
        } else {
          currentSum.next = new ListNode(tempSum);
        }
        carry = tempSum/10;
        currentSum = currentSum.next;

      }
    }
    if(currentL2.next!=null) {
      while (currentL2.next!=null) {
        currentL2 = currentL2.next;
        tempSum = currentL2.val + carry;
        if(tempSum>=10) {
          currentSum.next = new ListNode(tempSum%10);
        } else {
          currentSum.next = new ListNode(tempSum);
        }
        carry = tempSum/10;
        currentSum = currentSum.next;

      }
    }
    if(carry!=0) {
      currentSum.next = new ListNode(carry);
    }
    return result;
  }
}
