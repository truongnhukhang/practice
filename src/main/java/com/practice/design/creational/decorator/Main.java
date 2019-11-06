package com.practice.design.creational.decorator;

public class Main {
  public static void main(String[] args) {
    DataSourceDecorator dataSourceDecorator = new Base64DataSource(new SecurityDataSource(new FileDataSourceImpl("File1.xml")));
    dataSourceDecorator.write("this is test".getBytes());
    System.out.println(dataSourceDecorator.read());
  }
}
