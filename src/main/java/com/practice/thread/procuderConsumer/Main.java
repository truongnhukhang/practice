package com.practice.thread.procuderConsumer;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
  public static void main(String[] args) {
    IntQueueSync intQueueLock = new IntQueueSync(8);
    Random random = new Random();
    Thread producer = new Thread(()->{
      while (true) {
        int val = random.nextInt(11);
        System.out.println("Produce :" + val);
        intQueueLock.add(val);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    Thread consumer = new Thread(()->{
      while (true) {
        System.out.println("Consume :"+ intQueueLock.remove());
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    executorService.execute(producer);
    producer.start();
    consumer.start();
  }
}
