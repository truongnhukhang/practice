package com.practice.leetcode.explorer.medium.math;

public class Pow {

  public static void main(String[] args) {
    System.out.println((new Pow()).myPow(2,-2147483648));
  }

  public double myPow(double x,int n) {
    if(n<0) {
      Long N = Long.valueOf(n)*-1;
      return 1.0/fastPow(x,N);
    }
    return fastPow(x,n);
  }

  public double fastPow(double x,long n) {
    if(x==0) {
      return 0;
    }
    if(x==1) {
      return 1;
    }
    if(n==0) {
      return 1;
    }
    if(n==1) {
      return x;
    }
    long carry = n%2;
    double halfPow = fastPow(x,n/2);
    double result = halfPow * halfPow ;
    if(carry==1) {
      result = result * x;
    }
    return result;
  }
}
