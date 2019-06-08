package com.practice.arrayAndString;

public class MaxSub {
  int from;
  int to;
  int count;
  MaxSub(int from,int to,int count) {
    this.from = from;
    this.to = to;
    this.count = count;
  }

  @Override
  public String toString() {
    return "MaxSub{" +
        "from=" + from +
        ", to=" + to +
        ", count=" + count +
        '}';
  }
}
