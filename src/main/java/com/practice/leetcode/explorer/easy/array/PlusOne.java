package com.practice.leetcode.explorer.easy.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by truongnhukhang on 8/20/19.
 */
public class PlusOne {
  public static void main(String[] args) {
    int[] digits = {0};
    IntStream.of(plusOne(digits)).forEach(System.out::println);
  }

  public static int[] plusOne(int[] digits) {
    int borrow;
    int[] result = new int[digits.length];
    int tempResult = digits[digits.length-1] + 1;
    if(tempResult >= 10 ) {
      result[digits.length-1] = tempResult%10;
      borrow = tempResult/10;
      for (int i = digits.length-2; i >-1; i--) {
        tempResult = digits[i] + borrow;
        if(tempResult >= 10 ) {
          borrow = tempResult/10;
          result[i] = tempResult%10;
        } else {
          result[i] = tempResult;
          borrow = 0;
        }
      }
      if(borrow>0) {
        int[] newResult = new int[digits.length+1];
        newResult[0] = borrow;
        System.arraycopy(result,0,newResult,1,digits.length);
        return newResult;
      }
      return result;
    } else {
      digits[digits.length-1] = tempResult;
      return digits;
    }


  }
}
