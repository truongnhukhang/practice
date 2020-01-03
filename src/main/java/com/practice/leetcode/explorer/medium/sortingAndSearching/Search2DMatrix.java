package com.practice.leetcode.explorer.medium.sortingAndSearching;

import java.util.LinkedList;
import java.util.Queue;

public class Search2DMatrix {
  public static void main(String[] args) {
     int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
     int target = 5;
     int[][] matrix2 = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
     int target2=20;
    System.out.println((new Search2DMatrix()).searchMatrix(matrix,target));
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix.length==0) {
      return false;
    }
    Queue<int[]> matrixQueue = new LinkedList<>();
    int[] minMax = new int[4];
    minMax[0] = 0;
    minMax[1] = 0;
    minMax[2] = matrix.length-1;
    minMax[3] = matrix[0].length-1;
    matrixQueue.offer(minMax);
    while(matrixQueue.size()>0) {
      int[] pos = matrixQueue.poll();
      int minVal = matrix[pos[0]][pos[1]];
      int maxVal = matrix[pos[2]][pos[3]];
      if(target >= minVal && target <= maxVal) {
        int[] guess = new int[]{(pos[0]+pos[2])/2,(pos[1]+pos[3])/2};
        if(matrix[guess[0]][guess[1]]==target) {
          return true;
        } else {
          putPossibleMXToQueue(matrix,matrixQueue,pos,guess,target);
        }
      }
    }
    return false;
  }

  public void putPossibleMXToQueue(int[][] matrix,Queue<int[]> matrixQ,int[] pos,int[] guess,int target) {
    int x = 0 ; int y = 1;
    int val = matrix[guess[0]][guess[1]];
    if(target < val) {
      if(guess[y] - 1 >= 0) {
        int[] minMax = new int[4];
        minMax[0] = guess[x];
        minMax[1] = pos[1];
        minMax[2] = pos[2];
        minMax[3] = guess[y]-1;
        matrixQ.offer(minMax);
      }
      if(guess[x] - 1 >= 0 ) {
        int[] minMax = new int[4];
        minMax[0] = pos[0];
        minMax[1] = guess[y];
        minMax[2] = guess[x] - 1;
        minMax[3] = pos[3];
        matrixQ.offer(minMax);
      }
      if(guess[y] - 1 >= 0 && guess[x] - 1 >= 0 ) {
        int[] minMax = new int[4];
        minMax[0] = pos[0];
        minMax[1] = pos[1];
        minMax[2] = guess[x]-1;
        minMax[3] = guess[y]-1;
        matrixQ.offer(minMax);
      }
    } else {
      if(guess[y] + 1 < matrix[0].length) {
        int[] minMax = new int[4];
        minMax[0] = pos[0];
        minMax[1] = guess[y]+1;
        minMax[2] = guess[x];
        minMax[3] = pos[3];
        matrixQ.offer(minMax);
      }
      if(guess[x] + 1 < matrix.length) {
        int[] minMax = new int[4];
        minMax[0] = guess[x]+1;
        minMax[1] = pos[1];
        minMax[2] = pos[2];
        minMax[3] = guess[y];
        matrixQ.offer(minMax);
      }
      if(guess[y] + 1 < matrix[0].length && guess[x] + 1 < matrix.length) {
        int[] minMax = new int[4];
        minMax[0] = guess[x]+1;
        minMax[1] = guess[y] + 1;
        minMax[2] = pos[2];
        minMax[3] = pos[3];
        matrixQ.offer(minMax);
      }
    }
  }
}
