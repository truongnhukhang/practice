package com.practice.leetcode.explorer.easy.array;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {
  public static void main(String[] args) {
    char[][] board = {
    {'7','.','.','.','4','.','.','.','.'},
    {'.','.','.','8','6','5','.','.','.'},
    {'.','1','.','2','.','.','.','.','.'},
    {'.','.','.','.','.','9','.','.','.'},
    {'.','.','.','.','5','.','5','.','.'},
    {'.','.','.','.','.','.','.','.','.'},
    {'.','.','.','.','.','.','2','.','.'},
    {'.','.','.','.','.','.','.','.','.'},
    {'.','.','.','.','.','.','.','.','.'}};
    System.out.println(isValidSudoku(board));
  }

  public static boolean isValidSudoku(char[][] board) {
    int[][] colValidate = new int[9][256];
    int[] rowValidate = null;
    Map<String,Integer[]> boxValidate = new HashMap<>();
    for (int i = 0; i < 9; i++) {
      rowValidate = new int[256];
      for (int j = 0; j < 9; j++) {
        char sudokuNum = board[i][j];
        if(sudokuNum =='.') {
          continue;
        }
        // validate box
        String boxkey = String.valueOf(i/3) + String.valueOf(j/3);
        if(boxValidate.get(boxkey)==null) {
          Integer[] values = new Integer[256];
          values[sudokuNum] = 1;
          boxValidate.put(boxkey,values);
        } else {
          int value =  boxValidate.get(boxkey)[sudokuNum] == null ? 0 : boxValidate.get(boxkey)[sudokuNum];
          if(value>0) {
            return false;
          } else {
            boxValidate.get(boxkey)[sudokuNum] = 1;
          }
        }
        // validate y
        if(colValidate[j][sudokuNum]>0) {
          return false;
        } else {
          colValidate[j][sudokuNum] = 1;
        }
        // validate x
        if(rowValidate[sudokuNum]>0) {
          return false;
        } else {
          rowValidate[sudokuNum] = 1;
        }
      }
    }
    return true;
  }
}
