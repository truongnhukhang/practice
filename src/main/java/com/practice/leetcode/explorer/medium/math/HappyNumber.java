package com.practice.leetcode.explorer.medium.math;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by truongnhukhang on 12/17/19.
 */
public class HappyNumber {
  public static void main(String[] args) {
    HappyNumber happyNumber = new HappyNumber();
    System.out.println(happyNumber.isHappy(0));
  }
  public boolean isHappy(int n) {
    Set<Integer> cache = new HashSet<>();
    return isHappy(n,cache);
  }

  public boolean isHappy(int n, Set<Integer> cache) {
    if(!cache.add(n)) {
      return false;
    }
    int sumSquare = 0;
    while (n>0) {
      sumSquare = sumSquare + ((Double)Math.pow(n%10.0,2.0)).intValue();
      n=n/10;
    }
    if(sumSquare==1) {
      return true;
    }
    return isHappy(sumSquare,cache);
  }
}
