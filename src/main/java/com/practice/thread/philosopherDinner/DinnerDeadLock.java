package com.practice.thread.philosopherDinner;

public class DinnerDeadLock {
  public static void main(String[] args) {
    int numPhisolopher = 5;
    Integer[] chopsticks = new Integer[numPhisolopher];
    Philosopher[] philosophers = new Philosopher[numPhisolopher];
    int[] count = new int[numPhisolopher];
    for (int i = 0; i < numPhisolopher; i++) {
      chopsticks[i] = i;
      chopsticks[(i+1)%numPhisolopher] = (i+1)%numPhisolopher;
      philosophers[i] = new Philosopher(count,i,chopsticks[i],chopsticks[(i+1)%numPhisolopher]);
    }
    for (int i = 0; i < numPhisolopher; i++) {
      philosophers[i].start();
    }
  }

}
