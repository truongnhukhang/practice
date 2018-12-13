package com.practice.arrayAndString;

/**
 * Created by truongnhukhang on 12/13/18.
 */
public class CheckRotationStringUse1CallSubString {

  public static void main(String[] args) {
    String s1 = "ABCD";
    String s2 = "CDAB";

  }

  public boolean isRotation(String s1,String s2) {
    if(s1.length()!=s2.length())
      return false;
    int startS1 = -1;
    int startS2 = -1;
    for (int i = 0; i < s1.length(); i++) {
      for (int j = 0; j < s2.length(); j++) {
        if(s1.charAt(i)==s2.charAt(j)) {
          startS1 = i;
          startS2 = j;
          break;
        } else {
          startS1 = 0;
          startS2 = 0;
          break;
        }
      }
    }
    return false;
  }

}
