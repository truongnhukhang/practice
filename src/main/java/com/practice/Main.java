package com.practice;

import com.practice.linkedList.CircularLinkedListImplementSimple;
import com.practice.linkedList.LinkedListImplementSimple;
import com.practice.linkedList.Node;
import com.practice.queue.QueueImplementSimple;
import com.practice.sort.MergeSortImplementSimple;
import com.practice.stack.StackImplementSimple;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        CircularLinkedListImplementSimple<String> list = new CircularLinkedListImplementSimple<>();
        list.insert("A");
        list.insert("B");
        list.insert("C");
        list.insert("D");
        list.insert("E");
        list.println();
    }
}
