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
//        popPutMinO1Stack.add(new PopPutMinO1Stack.NodeMin(5));
//        popPutMinO1Stack.add(new PopPutMinO1Stack.NodeMin(1));
//        popPutMinO1Stack.add(new PopPutMinO1Stack.NodeMin(3));
//        popPutMinO1Stack.add(new PopPutMinO1Stack.NodeMin(2));
//        popPutMinO1Stack.add(new PopPutMinO1Stack.NodeMin(4));
//        popPutMinO1Stack.add(new PopPutMinO1Stack.NodeMin(0));
//        popPutMinO1Stack.add(new PopPutMinO1Stack.NodeMin(1));
//        popPutMinO1Stack.get();
//        System.out.println(popPutMinO1Stack.getMin());
      SetOfStacks<String> stringSetOfStacks = new SetOfStacks<>();
      stringSetOfStacks.push("A");
      stringSetOfStacks.push("B");
      stringSetOfStacks.push("C");
      stringSetOfStacks.push("D");
      stringSetOfStacks.push("E");
      stringSetOfStacks.push("F");
      stringSetOfStacks.push("G");
      stringSetOfStacks.push("H");
      stringSetOfStacks.push("I");
      stringSetOfStacks.push("K");
      stringSetOfStacks.push("L");
      stringSetOfStacks.push("M");
      stringSetOfStacks.push("N");

      System.out.println(stringSetOfStacks.pop());
      System.out.println(stringSetOfStacks.pop());
      System.out.println(stringSetOfStacks.pop());
      System.out.println(stringSetOfStacks.pop());
      System.out.println(stringSetOfStacks.pop());
      System.out.println(stringSetOfStacks.pop());
      System.out.println(stringSetOfStacks.pop());
      System.out.println(stringSetOfStacks.pop());
      System.out.println(stringSetOfStacks.pop());
      System.out.println(stringSetOfStacks.pop());
      System.out.println(stringSetOfStacks.pop());
      System.out.println(stringSetOfStacks.pop());
      System.out.println(stringSetOfStacks.pop());
    }
}
