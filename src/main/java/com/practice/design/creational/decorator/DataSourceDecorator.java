package com.practice.design.creational.decorator;

public class DataSourceDecorator implements SimpleDataSource {

  SimpleDataSource decorateObject;

  public DataSourceDecorator(SimpleDataSource decorateObject) {
    this.decorateObject = decorateObject;
  }

  @Override
  public String read() {
    return decorateObject.read();
  }

  @Override
  public void write(byte[] data) {
    decorateObject.write(data);
  }
}
