package com.practice.leetcode.mock;

/**
 * Created by truongnhukhang on 12/23/19.
 */
public class HammingDistance {
  public static void main(String[] args) {
    HammingDistance hammingDistance = new HammingDistance();
    System.out.println(hammingDistance.hammingDistance(1,4));
  }

  public int hammingDistance(int x, int y) {
    int xor = x ^ y;
    int distance = 0;
    while (xor!=0) {
      if(xor%2==1) {
        distance++;
      }
      xor=xor/2;
    }
    return distance;
  }
}
