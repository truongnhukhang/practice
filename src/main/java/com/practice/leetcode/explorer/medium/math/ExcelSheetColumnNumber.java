package com.practice.leetcode.explorer.medium.math;

/**
 * Created by truongnhukhang on 12/17/19.
 */
public class ExcelSheetColumnNumber {
  public static void main(String[] args) {
    ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();
    System.out.println(excelSheetColumnNumber.titleToNumber("AAA"));
  }

  public int titleToNumber(String s) {
    int[] charMap = new int[128];
    for (int i = 'A',count=1; i <= 'Z' ; i++) {
      charMap[i] = count;
      count++;
    }
    char[] chars = s.toCharArray();
    int number = 0;
    for (int i = 0; i < chars.length; i++) {
      number = number * 26 + charMap[chars[i]] ;
    }
    return number;
  }
}
