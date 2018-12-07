package com.practice;

import com.practice.queue.QueueImplementSimple;
import com.practice.stack.StackImplementSimple;

public class Main {

    public static void main(String[] args) {
	// write your code here
        QueueImplementSimple stackImplementSimple = new QueueImplementSimple();
        stackImplementSimple.add("test1");
        System.out.println(stackImplementSimple.get());
        stackImplementSimple.add("test2");
        System.out.println(stackImplementSimple.get());
        stackImplementSimple.add("test3");
        stackImplementSimple.add("test4");
        System.out.println(stackImplementSimple.get());
        stackImplementSimple.add("test5");
        System.out.println(stackImplementSimple.get());

    }
}
