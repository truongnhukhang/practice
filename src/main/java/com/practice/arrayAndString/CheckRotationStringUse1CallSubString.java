package com.practice.arrayAndString;

/**
 * Created by truongnhukhang on 12/13/18.
 */
public class CheckRotationStringUse1CallSubString {

  public static void main(String[] args) {
    String s1 = "aabv";
    String s2 = "abva";
    System.out.println(isRotationFast(s1,s2));
    s1 = "waterbottle";
    s2 = "erbottlewat";
    System.out.println(isRotationFast(s1,s2));
    s1 = "eebb";
    s2 = "ebbe";
    System.out.println(isRotationFast(s1,s2));
    s1 = "aaaabb";
    s2 = "ababaa";
    System.out.println(isRotationFast(s1,s2));
    s1 = "12ab";
    s2 = "2a1b";
    System.out.println(isRotationFast(s1,s2));
    s1 = "abcd";
    s2 = "acbd";
    System.out.println(isRotationFast(s1,s2));
  }

  static boolean isRotationFast(String s1,String s2) {
    if(s1.length()!=s2.length())
      return false;
    return (s1+s1).contains(s2);
  }

  static boolean isRotation(String s1,String s2) {
    if(s1.length()!=s2.length())
      return false;
    int startS1 = -1;
    int startS2 = 0;
    for (int i = 0; i < s1.length(); i++) {
      if(startS1==-1) {
        if(s1.charAt(i)==s2.charAt(0)) {
          startS1 = i;
          startS2++;
        }
      } else {
        if(s1.charAt(i)==s2.charAt(startS2)) {
          startS2++;
        } else {
          //restart the check
          startS1=-1;
          i--;
          startS2=0;
        }
      }
    }
    if(startS1==-1) {
      return false;
    } else {
      String subS1 = s1.substring(0,startS1);
      return s2.contains(subS1);
    }
  }

}
