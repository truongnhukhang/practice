package com.practice.thread;

public class TestSync {
  Object lock1 = new Object();
  Object lock2 = new Object();
  public synchronized void log1(){
    System.out.println("Log1");
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Finish log1");

  }


  public void log2(){
    synchronized (this) {
      System.out.println("Log2");
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Finish log2");
    }


  }
}
