package com.practice.thread.philosopherDinner;

import static java.lang.Thread.*;

public class Philosopher extends Thread {
  int id;
  Integer chopstick1;
  Integer chopstick2;
  public int[] count;
  public Philosopher(int[] count,int id, Integer chopstick1, Integer chopstick2) {
    this.id = id;
    this.chopstick1 = chopstick1;
    this.chopstick2 = chopstick2;
    this.count = count;
  }

  @Override
  public void run() {
    while(!Thread.interrupted()) {
//      System.out.println("Philosopher " + id + " Thinking");
      synchronized (chopstick1) {
//        System.out.println("Philosopher " + id + " acquired chopstick " + chopstick1);
        synchronized (chopstick2) {
//          System.out.println("Philosopher " + id + " acquired chopstick " + chopstick2);
//          System.out.println("Philosopher " + id + " Eating");
          count[id]++;
        }
      }
    }

  }
}
