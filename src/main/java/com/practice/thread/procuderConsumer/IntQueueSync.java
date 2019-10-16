package com.practice.thread.procuderConsumer;

public class IntQueueSync {
  private int[] db = null;
  int index=-1;

  public IntQueueSync(int size) {
    this.db = new int[size];
  }

  public synchronized void add(int num) {
    while (index==this.db.length-1) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    index = index+1;
    this.db[index]=num;
    notifyAll();
  }

  public synchronized int remove() {
    while (index==-1) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    int val=this.db[index];
    index = index-1;
    notifyAll();
    return val;
  }
}
