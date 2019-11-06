package com.practice.design.creational.decorator;

public interface SimpleDataSource {
  String read();
  void write(byte[] data);
}
