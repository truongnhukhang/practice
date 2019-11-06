package com.practice.design.creational.decorator;

public class SecurityDataSource extends DataSourceDecorator {
  public SecurityDataSource(SimpleDataSource decorateObject) {
    super(decorateObject);
  }

  @Override
  public String read() {
    String data = super.read();
    return data.substring(0,data.length()-1);
  }

  @Override
  public void write(byte[] data) {
    String dataInString = new String(data)+"1";
    super.write(dataInString.getBytes());
  }
}
