package com.practice.design.creational.decorator;

public class FileDataSourceImpl implements SimpleDataSource {

  private String fileLocation;
  byte[] data;

  public FileDataSourceImpl(String fileLocation) {
    this.fileLocation = fileLocation;
  }

  @Override
  public String read() {
    return new String(data);
  }

  @Override
  public void write(byte[] data) {
    this.data = data;
  }
}
