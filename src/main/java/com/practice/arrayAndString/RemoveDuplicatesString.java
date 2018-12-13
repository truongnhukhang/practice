package com.practice.arrayAndString;

public class RemoveDuplicatesString {
  public static void main(String[] args) {
    System.out.println(removeDuplicates("aavbnnn".toCharArray()));
    System.out.println(removeDuplicates("ababa".toCharArray()));
    System.out.println(removeDuplicates("aaabnn".toCharArray()));
    System.out.println(removeDuplicates("abacabnn".toCharArray()));
    System.out.println(removeDuplicates("aaaaaaa".toCharArray()));
  }

  public static char[] removeDuplicates(char[] str) {
    if (str == null) return str;
    if (str.length < 2) return str;
    int tail = 0;
    for (int i = 1; i < str.length; i++) {
      for (int j = 0; j < i; j++) {
        if(str[j]==str[i]) {
          break;
        } else if(str[j]!=str[i] && j == tail) {
          tail++;
          str[tail] = str[i];
          break;
        }
      }
      if(i==str.length-1) {
        for (int k = tail+1;k < str.length ;k++) {
          str[k]=0;
        }
      }
    }
    return str;
  }

}
