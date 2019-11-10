package com.practice.thread.readerWriter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReaderWriterProblem {
  public static void main(String[] args) throws InterruptedException {
    Integer readCounter=0;
    Integer writeCounter=0;
    Integer[] readWriteCounter ={0,0};
    Object readLock = new Object();
    Object writeLock = new Object();
    Reader reader1 = new Reader(readWriteCounter,readLock,writeLock);
    Reader reader2 = new Reader(readWriteCounter,readLock,writeLock);
    Reader reader3 = new Reader(readWriteCounter,readLock,writeLock);
    Reader reader4 = new Reader(readWriteCounter,readLock,writeLock);
    Reader reader5 = new Reader(readWriteCounter,readLock,writeLock);
    Reader reader6 = new Reader(readWriteCounter,readLock,writeLock);
    Writer writer = new Writer(readWriteCounter,readLock,writeLock);
    reader1.start();
    reader2.start();
    reader3.start();
//    reader4.start();
//    reader5.start();
//    reader6.start();
    writer.start();
    Thread.sleep(10000);
    reader1.interrupt();
    reader2.interrupt();
    reader3.interrupt();
//    reader4.interrupt();
//    reader5.interrupt();
//    reader6.interrupt();
    writer.interrupt();
  }
}
