package com.practice.arrayAndString;

public class MatrixSetZero {
  public static void main(String[] args) {
    int[][] matrix = new int[4][4];
    matrix[0] = new int[]{1,2,3,0};
    matrix[1] = new int[]{5,0,8,9};
    matrix[2] = new int[]{6,1,7,9};
    matrix[3] = new int[]{2,3,4,8};
    matrix = setZeroColumnAndRowIfExsitZeroPointElement(matrix);
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  static int[][] setZeroColumnAndRowIfExsitZeroPointElement(int[][] matrix) {
    if(matrix.length<2) {
      return matrix;
    }
    int[] rowStorage = new int[matrix.length];
    int[] colStorage = new int[matrix.length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        if(matrix[i][j]==0) {
          rowStorage[i] = 1;
          colStorage[j] = 1;
        }
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        if(rowStorage[i]==1 || colStorage[j]==1) {
          matrix[i][j] = 0;
        }
      }
    }

    return matrix;
  }
}
