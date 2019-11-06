package com.practice.leetcode.mock;

public class RotateString {
  public static void main(String[] args) {
    RotateString rotateString = new RotateString();
    System.out.println(rotateString.rotateString("abcde","abced"));
  }
  public boolean rotateString(String A, String B) {
    if(A.length()!=B.length()) {
      return false;
    }
    return (A+A).contains(B);
  }
}
