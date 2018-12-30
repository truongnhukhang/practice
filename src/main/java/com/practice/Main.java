package com.practice;

import com.practice.linkedList.CircularLinkedListImplementSimple;
import com.practice.linkedList.LinkedListImplementSimple;
import com.practice.linkedList.Node;
import com.practice.queue.QueueImplementSimple;
import com.practice.sort.MergeSortImplementSimple;
import com.practice.stack.PopPutMinO1Stack;
import com.practice.stack.PopPutMinO1Stack_v2;
import com.practice.stack.StackImplementSimple;
import com.practice.stack.ThreeStackInOneArray;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        PopPutMinO1Stack popPutMinO1Stack = new PopPutMinO1Stack();
//        popPutMinO1Stack.add(new PopPutMinO1Stack.NodeMin(5));
//        popPutMinO1Stack.add(new PopPutMinO1Stack.NodeMin(1));
//        popPutMinO1Stack.add(new PopPutMinO1Stack.NodeMin(3));
//        popPutMinO1Stack.add(new PopPutMinO1Stack.NodeMin(2));
//        popPutMinO1Stack.add(new PopPutMinO1Stack.NodeMin(4));
//        popPutMinO1Stack.add(new PopPutMinO1Stack.NodeMin(0));
//        popPutMinO1Stack.add(new PopPutMinO1Stack.NodeMin(1));
//        popPutMinO1Stack.get();
//        System.out.println(popPutMinO1Stack.getMin());
        PopPutMinO1Stack_v2 popPutMinO1Stack_v2 = new PopPutMinO1Stack_v2();
        popPutMinO1Stack_v2.add(5);
        popPutMinO1Stack_v2.add(1);
        popPutMinO1Stack_v2.add(3);
        popPutMinO1Stack_v2.add(2);
        popPutMinO1Stack_v2.add(4);
        popPutMinO1Stack_v2.add(0);
        popPutMinO1Stack_v2.get();
        System.out.println(popPutMinO1Stack_v2.getMin());
    }
}
