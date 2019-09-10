package com.practice.leetcode.explorer.easy.string;

public class ReverseString {
  public static void main(String[] args) {
    char[] chars = {'a','b','c','d','e'};
    reverseString(chars);
    for (char c :
        chars) {
      System.out.println(c);
    }
  }

  public static void reverseString(char[] s) {
    for (int i = 0,j=s.length-1; i < s.length; i++,j--) {
      if(i<=j) {
        swap(s,i,j);
      }
    }
  }

  public static void swap(char[] s,int index1,int index2) {
    char temp = s[index1];
    s[index1] = s[index2];
    s[index2] = temp;
  }
}
