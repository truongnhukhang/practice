package com.practice.leetcode.explorer.medium.design;

public class Flatten2DVector {
  int[][] v =null;
  int row = 0;
  int col = 0;
  public Flatten2DVector(int[][] v) {
    this.v = v;
    int row = 0;
    int col = 0;
  }

  public int next() {
    if(hasNext()) {
      return v[row][col++];
    }
    return -1;

  }

  public boolean hasNext() {
    while(row<v.length && col==v[row].length) {
      row++;
      col=0;
    }
    return row < v.length;
  }
}
