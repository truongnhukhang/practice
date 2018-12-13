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
    for (int i = 0; i < s1.length(); i++) {
      if(s1.charAt(i)==s2.charAt(0)) {
        
      }
    }
    return false;
  }

}
