package com.practice.thread.readerWriter.synchronize;

public class Reader extends Thread {

  Integer[] readWriteCounter;
  Object readLock;
  Object writeLock;

  public Reader(Integer[] readWriteCounter, Object readLock, Object writeLock) {
    this.readWriteCounter = readWriteCounter;
    this.readLock = readLock;
    this.writeLock = writeLock;
  }

  @Override
  public void run() {
    while (!Thread.interrupted()) {
      synchronized (readLock) {
        if (readWriteCounter[1] > 0) {
          try {
            readLock.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
      synchronized (readLock) {
        readWriteCounter[0]++;
      }
      System.out.println("Reading : " + this.getName() + " , read counter : " + readWriteCounter[0]);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
      synchronized (readLock){
        readWriteCounter[0]--;
      }
      if(readWriteCounter[0]==0) {
        synchronized (writeLock) {
          writeLock.notifyAll();
        }
      }
    }
  }

}
