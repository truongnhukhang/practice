package com.practice.arrayAndString;

public class ArrayAndStringPractice {
  public static void main(String[] args) {
    System.out.println(removeDuplicates("aavbnnn".toCharArray()));
    System.out.println(removeDuplicates("aaabnn".toCharArray()));
  }

  public static char[] removeDuplicates(char[] str) {
    if (str == null) return str;
    if (str.length < 2) return str;
    for (int i = 0; i < str.length; i++) {
      for (int j = 0; j < i; j++) {
        if (str[i] == str[j]) {
          if (i < str.length-1) {
            str[i] = str[i + 1];
            i++;
            j=i;
          } else {
            str[i] = 0;
          }
        }
      }
    }
    return str;
  }
}
