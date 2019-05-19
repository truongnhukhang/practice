package com.practice.arrayAndString;

public class MaxSub {
  int from;
  int to;
  MaxSub(int from,int to) {
    this.from = from;
    this.to = to;
  }

  int countMaxSub(int[] a) {
    int count = 0;
    for (int i = from; i < to ; i++) {
      count = count + a[i];
    }
    return count;
  }

  @Override
  public String toString() {
    return "MaxSub{" +
        "from=" + from +
        ", to=" + to +
        '}';
  }
}
