package com.practice.arrayAndString;

/**
 * Created by truongnhukhang on 12/11/18.
 */
public class RotateMatrixNxN {
  public static void main(String[] args) {
    String[][] matrix = new String[4][4];
    matrix[0] = new String[]{"A", "B", "C", "D"};
    matrix[1] = new String[]{"E", "F", "G", "H"};
    matrix[2] = new String[]{"I", "K", "L", "M"};
    matrix[3] = new String[]{"N", "P", "Q", "T"};
    matrix = rotate(matrix);
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static String[][] rotate(String[][] matrixNxN) {
    if(matrixNxN.length < 2)
      return matrixNxN;
    int length = matrixNxN.length;
    String[][] result = new String[length][length];
    for (int i = 0; i < length ; i++) {
      for (int j = 0; j < length ; j++) {
        String data = matrixNxN[i][j];
        result[j][length-1-i] = data;
      }
    }
    return result;
  }
}
