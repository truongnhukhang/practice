package com.practice.thread.procuderConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IntQueueLock {
  private int[] db = null;
  int index=-1;
  Lock lock = new ReentrantLock();
  Condition isFull = lock.newCondition();
  Condition isNotFull = lock.newCondition();
  public IntQueueLock(int size) {
    this.db = new int[size];
  }

  public void add(int num) {
    lock.lock();
    try {
      while(index==db.length-1) {
        try {
          isFull.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      index = index+1;
      this.db[index] = num;
      isNotFull.signalAll();
    } finally {
      lock.unlock();
    }
  }

  public  int remove() {
    lock.lock();
    try {
      while(index==-1) {
        try {
          isNotFull.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      int val = this.db[index];
      index = index-1;
      isFull.signalAll();
      return val;
    } finally {
      lock.unlock();
    }
  }
}
