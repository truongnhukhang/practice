package com.practice.design.creational.singleton;

public class SingletonLogger {
  private static SingletonLogger instance = null;

  // disable create object
  private SingletonLogger() {
  }

  /**
   * Double-checked looking used to avoid overhead of acquiring a lock by testing the looking situation
   * @return
   */
  public static SingletonLogger getInstance() {
    if(instance==null) {
      synchronized (SingletonLogger.class) {
        instance = new SingletonLogger();
      }
    }
    return instance;
  }
}
