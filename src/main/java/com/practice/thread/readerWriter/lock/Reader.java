package com.practice.thread.readerWriter.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Reader extends Thread {
  ReentrantReadWriteLock reentrantReadWriteLock;

  public Reader(ReentrantReadWriteLock reentrantReadWriteLock) {
    this.reentrantReadWriteLock = reentrantReadWriteLock;
  }

  @Override
  public void run() {
    while (!Thread.interrupted()) {

    }
  }
}
