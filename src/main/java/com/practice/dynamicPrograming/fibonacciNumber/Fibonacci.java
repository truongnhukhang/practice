package com.practice.dynamicPrograming.fibonacciNumber;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
  public static void main(String[] args) {
    System.out.println(new Fibonacci().calcFibo(11));
    System.out.println(new Fibonacci().calcFiboBottomUp(11));
    System.out.println(new Fibonacci().calcFiboBottomUPO1(11));
    System.out.println(new Fibonacci().calcFiboTopDown(11,new HashMap<>()));
  }

  public int calcFibo(int n) {
    if(n==0) {
      return 0;
    }
    if(n==1) {
      return 1;
    }
    return calcFibo(n-1)+calcFibo(n-2);
  }

  public int calcFiboTopDown(int n, Map<Integer,Integer> map) {
    if(n==0) {
      return 0;
    }
    if(n==1) {
      return 1;
    }
    if(map.get(n)!=null) {
      return map.get(n);
    }
    int fibo = calcFibo(n-1)+calcFibo(n-2);
    map.put(n,fibo);
    return fibo;
  }

  public int calcFiboBottomUp(int n) {
    int[] dp = new int[n+1];
    dp[0]=0;dp[1]=1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
  }

  public int calcFiboBottomUPO1(int n) {
    if(n==0) {
      return 0;
    }
    if(n==1) {
      return 1;
    }
    int prv1 = 1 ; int prv2 =0;
    int fibo = 0;int temp = 0;
    for (int i = 2; i <= n; i++) {
      fibo = prv1 + prv2;
      prv2 = prv1;
      prv1 = fibo;
    }
    return fibo;
  }
}
