package com.practice.thread.readerWriter.synchronize;

public class Writer extends Thread {

  Integer[] readWriteCounter;
  Object readLock;
  Object writeLock;

  public Writer(Integer[] readWriteCounter, Object readLock, Object writeLock) {
    this.readWriteCounter = readWriteCounter;
    this.readLock = readLock;
    this.writeLock = writeLock;
  }

  @Override
  public void run() {
    while (!Thread.interrupted()) {
      synchronized (writeLock) {
        if (readWriteCounter[0] > 0) {
          try {
            writeLock.wait();
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
        }
      }
      synchronized (writeLock) {
        readWriteCounter[1]++;
      }
      System.out.println("Start writing : " + this.getName() + " Write Counter : " + readWriteCounter[1]);
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
      synchronized (writeLock) {
        readWriteCounter[1]--;
      }
      synchronized (readLock) {
        if(readWriteCounter[1]==0) {
          readLock.notifyAll();
        }
      }
    }
  }

}
