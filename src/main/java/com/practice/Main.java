package com.practice;

import com.practice.linkedList.LinkedListImplementSimple;
import com.practice.queue.QueueImplementSimple;
import com.practice.sort.MergeSortImplementSimple;
import com.practice.stack.StackImplementSimple;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedListImplementSimple linkedListImplementSimple = new LinkedListImplementSimple();
        linkedListImplementSimple.insert("A");
        linkedListImplementSimple.insert("B");
        linkedListImplementSimple.insert("C");
        linkedListImplementSimple.insert("D");
        linkedListImplementSimple.insert("D");
        linkedListImplementSimple.insert("E");

//        linkedListImplementSimple.delete("B");
//        linkedListImplementSimple.delete("C");
//        linkedListImplementSimple.delete("A");
        linkedListImplementSimple.delete("D");
        linkedListImplementSimple.println();

    }
}
