package com.practice.linkedList;

/**
 * Created by truongnhukhang on 12/27/18.
 */
public class PlusNumberStoreInLinkedList {
  public static void main(String[] args) {
    LinkedListImplementSimple<Integer> num1 = new LinkedListImplementSimple<>();
    num1.insert(9);
    num1.insert(9);
    num1.insert(9);
    LinkedListImplementSimple<Integer> num2 = new LinkedListImplementSimple<>();
    num2.insert(1);
    num2.insert(0);
    num2.insert(0);
    plus(num1,num2).println();
  }

  static LinkedListImplementSimple plus(LinkedListImplementSimple<Integer> num1,LinkedListImplementSimple<Integer> num2) {
    Node<Integer> cursor1 = num1.head;
    Node<Integer> cursor2 = num2.head;
    LinkedListImplementSimple<Integer> result = new LinkedListImplementSimple<>();
    int carry = 0;
    int tempResult;
    int tempNum1;
    int tempNum2;
    while (cursor1!=null || cursor2!=null) {
      tempNum1 = 0;
      tempNum2 = 0;
      if(cursor1!=null) {
        tempNum1 = cursor1.data;
        cursor1 = cursor1.next;
      }
      if(cursor2!=null) {
        tempNum2 = cursor2.data;
        cursor2 = cursor2.next;
      }
      tempResult = (tempNum1+tempNum2+carry)%10;
      carry = (tempNum1+tempNum2+carry)/10;
      result.insert(tempResult);
    }
    if(carry!=0) {
      result.insert(carry);
    }
    return result;
  }
}
