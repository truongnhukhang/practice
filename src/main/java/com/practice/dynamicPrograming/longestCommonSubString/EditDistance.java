package com.practice.dynamicPrograming.longestCommonSubString;

import java.util.HashMap;
import java.util.Map;

public class EditDistance {
  public static void main(String[] args) {
    String s1 = "ros";
    String s2 = "ros";
    System.out.println(new EditDistance().findMin(0,0,s1,s2,new Integer[s1.length()+1][s2.length()+1]));

    s1 = "bat";
    s2 = "but";
    System.out.println(new EditDistance().findMin(0,0,s1,s2,new Integer[s1.length()+1][s2.length()+1]));

    s1 = "abdca";
    s2 = "cbda";
    System.out.println(new EditDistance().findMin(0,0,s1,s2,new Integer[s1.length()+1][s2.length()+1]));

    s1 = "passpot";
    s2 = "ppsspqrt";
    System.out.println(new EditDistance().findMin(0,0,s1,s2,new Integer[s1.length()+1][s2.length()+1]));

    s1 = "sea";
    s2 = "eat";
    System.out.println(new EditDistance().findMin(0,0,s1,s2,new Integer[s1.length()+1][s2.length()+1]));

//    s1 = "a";
//    s2 = "b";
//    System.out.println(new EditDistance().findMin(0,0,s1,s2,0,new Integer[s1.length()+1][s2.length()+1]));

  }

  public int findMin(int idx1, int idx2, String s1, String s2, Integer[][] map) {
    if(idx2==s2.length()) {
      map[idx1][idx2] = s1.length()-idx1;
      return map[idx1][idx2];
    }
    if(idx1==s1.length()) {
      map[idx1][idx2] = s2.length()-idx2;
      return map[idx1][idx2];
    }
    if(map[idx1][idx2]!=null) {
      return map[idx1][idx2];
    }
    if(s1.charAt(idx1)==s2.charAt(idx2)) {
      int min1 = findMin(idx1+1,idx2+1,s1,s2,map);
      map[idx1][idx2] = min1;
    } else {
      // replace
      int min2 = 1 + findMin(idx1+1,idx2+1,s1,s2,map);
      // delete
      int min3 = 1 + findMin(idx1+1,idx2,s1,s2,map);
      // insert
      int min4 = 1 + findMin(idx1,idx2+1,s1,s2,map);
      int min = Math.min(min4,Math.min(min2,min3));
      map[idx1][idx2] = min;
    }
    return map[idx1][idx2];
  }
}
