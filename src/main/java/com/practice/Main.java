package com.practice;

import com.practice.linkedList.CircularLinkedListImplementSimple;
import com.practice.linkedList.LinkedListImplementSimple;
import com.practice.linkedList.Node;
import com.practice.queue.QueueImplementSimple;
import com.practice.sort.MergeSortImplementSimple;
import com.practice.stack.*;

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
      MyQueueByStack<String> stringMyQueueByStack = new MyQueueByStack<>();
      stringMyQueueByStack.put("A");
      stringMyQueueByStack.put("B");
      stringMyQueueByStack.put("C");
      stringMyQueueByStack.put("D");
      System.out.println(stringMyQueueByStack.pop());
      System.out.println(stringMyQueueByStack.pop());
      System.out.println(stringMyQueueByStack.pop());
      System.out.println(stringMyQueueByStack.pop());
    }
}
