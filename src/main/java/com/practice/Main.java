package com.practice;

import com.practice.queue.QueueImplementSimple;
import com.practice.sort.MergeSortImplementSimple;
import com.practice.stack.StackImplementSimple;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] test = {4,5,6,2,8,4,1,7,9};
        MergeSortImplementSimple mergeSortImplementSimple = new MergeSortImplementSimple();
        test = mergeSortImplementSimple.mergeSort(test);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }

    }
}
