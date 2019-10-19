package com.practice.thread.philosopherDinner;

public class DinnerResolveDeadLock {
  public static void main(String[] args) {
    int numPhisolopher = 5;
    Integer[] chopsticks = new Integer[numPhisolopher];
    Philosopher[] philosophers = new Philosopher[numPhisolopher];
    int[] count = new int[numPhisolopher];
    for (int i = 0; i < numPhisolopher; i++) {
      chopsticks[i] = i;
      chopsticks[(i+1)%numPhisolopher] = (i+1)%numPhisolopher;
      if(i==0) {
        philosophers[i] = new Philosopher(count,i,chopsticks[(i+1)%numPhisolopher],chopsticks[i]);
      } else {
        philosophers[i] = new Philosopher(count,i,chopsticks[i],chopsticks[(i+1)%numPhisolopher]);
      }
    }
    for (int i = 0; i < numPhisolopher; i++) {
      philosophers[i].start();
    }
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    for (int i = 0; i < numPhisolopher; i++) {
      philosophers[i].interrupt();
    }
    for (int i = 0; i < numPhisolopher; i++) {
      System.out.println(i + " = " + count[i]);
    }
  }
}
