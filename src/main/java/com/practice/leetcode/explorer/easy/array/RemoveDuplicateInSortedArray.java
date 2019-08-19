package com.practice.leetcode.explorer.easy.array;

import java.util.stream.IntStream;

/**
 * Created by truongnhukhang on 8/19/19.
 */
public class RemoveDuplicateInSortedArray {
  public static void main(String[] args) {
    int[] a = {0,0,0,1,1,1,2,2,3,3,4};
    int count = removeDuplicatedInPlace(a);
    System.out.println(count);
    IntStream.of(a).forEach(System.out::println);
  }

  public static int removeDuplicatedInPlace(int[] a) {
    int prv = a[0];
    int count = 1;
    int maxValue = a[a.length-1];
    for (int i = 1; i < a.length; i++) {
      if(prv==maxValue) {
        break;
      }
      if(prv==a[i]) {
        shiftLeftArrayFrom(i,a,prv);
        i--;
      } else {
        prv = a[i];
        count++;
      }
    }
    return count;
  }

  public static void shiftLeftArrayFrom(int index,int[] array,int lastIndexValue) {
    for (int i = index; i < array.length; i++) {
      if(i!=array.length-1) {
        array[i] = array[i+1];
      } else {
        array[i] = lastIndexValue;
      }
    }
  }
}
