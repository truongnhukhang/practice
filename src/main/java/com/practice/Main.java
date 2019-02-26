package com.practice;

import com.practice.linkedList.CircularLinkedListImplementSimple;
import com.practice.linkedList.LinkedListImplementSimple;
import com.practice.linkedList.Node;
import com.practice.queue.QueueImplementSimple;
import com.practice.sort.MergeSortImplementSimple;
import com.practice.stack.*;
import com.practice.tree.BinarySearchTreeImplementSimple;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        PopPutMinO1Stack popPutMinO1Stack = new PopPutMinO1Stack();
//        popPutMinO1Stack.put(new PopPutMinO1Stack.NodeMin(5));
//        popPutMinO1Stack.put(new PopPutMinO1Stack.NodeMin(1));
//        popPutMinO1Stack.put(new PopPutMinO1Stack.NodeMin(3));
//        popPutMinO1Stack.put(new PopPutMinO1Stack.NodeMin(2));
//        popPutMinO1Stack.put(new PopPutMinO1Stack.NodeMin(4));
//        popPutMinO1Stack.put(new PopPutMinO1Stack.NodeMin(0));
//        popPutMinO1Stack.put(new PopPutMinO1Stack.NodeMin(1));
//        popPutMinO1Stack.pop();
//        System.out.println(popPutMinO1Stack.getMin());
      BinarySearchTreeImplementSimple<Integer> bstInteger = new BinarySearchTreeImplementSimple<>();
      bstInteger.insert(10);
      bstInteger.insert(5);
      bstInteger.insert(15);
      bstInteger.insert(4);
      bstInteger.insert(6);
      bstInteger.insert(11);
      bstInteger.insert(16);
      bstInteger.levelOrderPrint();
    }
}
