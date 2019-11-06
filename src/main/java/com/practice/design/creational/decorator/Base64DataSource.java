package com.practice.design.creational.decorator;

import java.util.Base64;

public class Base64DataSource extends DataSourceDecorator {


  public Base64DataSource(SimpleDataSource decorateObject) {
    super(decorateObject);
  }

  @Override
  public String read() {
    String data = super.read();
    return new String(Base64.getDecoder().decode(data));
  }

  @Override
  public void write(byte[] data) {
    data = Base64.getEncoder().encode(data);
    super.write(data);
  }
}
