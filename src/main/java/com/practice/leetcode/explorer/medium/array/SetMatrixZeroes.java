package com.practice.leetcode.explorer.medium.array;

public class SetMatrixZeroes {
  public static void main(String[] args) {
    int[][] matrix = new int[4][4];
    matrix[0] = new int[]{1,2,3,0};
    matrix[1] = new int[]{5,0,8,9};
    matrix[2] = new int[]{6,1,7,9};
    matrix[3] = new int[]{2,3,4,8};
    setZeroes(matrix);
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void setZeroes(int[][] matrix) {
    int numRows = matrix.length;
    int numCol = matrix[0].length;
    boolean firstRowIsZero = false;
    boolean firstColIsZero = false;
    for (int i = 0; i < numCol; i++) {
      if(matrix[0][i]==0) {
        firstRowIsZero=true;
      }
    }
    for (int i = 0; i < numRows; i++) {
      if(matrix[i][0]==0) {
        firstColIsZero=true;
      }
    }
    for (int i = 1; i < numRows; i++) {
      for (int j = 1; j < numCol; j++) {
        if(matrix[i][j]==0) {
          matrix[i][0]=0;
          matrix[0][j]=0;
        }
      }
    }
    for (int i = 1; i < numRows; i++) {
      if(matrix[i][0]==0) {
        for (int j = 1; j < numCol; j++) {
          matrix[i][j]=0;
        }
      }
    }
    for (int i = 0; i < numCol; i++) {
      if(matrix[0][i]==0) {
        for (int j = 1; j < numRows; j++) {
          matrix[j][i]=0;
        }
      }
    }
    if(firstColIsZero) {
      for (int i = 0; i < numRows; i++) {
        matrix[i][0]=0;
      }
    }
    if(firstRowIsZero) {
      for (int i = 0; i < numCol; i++) {
        matrix[0][i]=0;
      }
    }

  }
}
