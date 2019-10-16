package com.practice.thread;

public class Main {
  public static void main(String[] args) {
    TestSync testSync = new TestSync();
    Runnable runnable1 = () -> {
      testSync.log1();
    };
    Runnable runnable2 = () -> {
      testSync.log2();
    };
    Thread t1 = new Thread(runnable1);
    t1.start();
    System.out.println("Run 2");
    Thread t2 = new Thread(runnable2);
    t2.start();
  }

}
