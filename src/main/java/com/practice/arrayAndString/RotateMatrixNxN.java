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
    matrix = rotateInPlace(matrix);
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
    matrix = new String[3][3];
    matrix[0] = new String[]{"A", "B", "C"};
    matrix[1] = new String[]{"E", "F", "G"};
    matrix[2] = new String[]{"I", "K", "L"};
    matrix = rotateInPlace(matrix);
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static String[][] rotateOutPlace(String[][] matrixNxN) {
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

  public static String[][] rotateInPlace(String[][] matrixNxN) {
    if(matrixNxN.length < 2)
      return matrixNxN;
    int length = matrixNxN.length;
    int maxIndex = length-1;
    long middle = Math.round(length*1.0/2);
    for (int i = 0; i < length-middle; i++) {
      for (int j = 0; j < middle; j++) {
        swapPoint(matrixNxN,new int[]{i,j},new int[]{j,maxIndex-i});
        swapPoint(matrixNxN,new int[]{i,j},new int[]{maxIndex-i,maxIndex-j});
        swapPoint(matrixNxN,new int[]{i,j},new int[]{maxIndex-j,i});

      }
    }
    return matrixNxN;
  }

  static void swapPoint(String[][] matrixNxN,int[] point1,int[] point2) {
    String temp = matrixNxN[point1[0]][point1[1]];
    matrixNxN[point1[0]][point1[1]] = matrixNxN[point2[0]][point2[1]];
    matrixNxN[point2[0]][point2[1]] = temp;
  }
}
