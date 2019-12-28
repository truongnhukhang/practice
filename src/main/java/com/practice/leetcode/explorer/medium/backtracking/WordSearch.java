package com.practice.leetcode.explorer.medium.backtracking;

import java.util.Stack;

public class WordSearch {
  public static void main(String[] args) {
    char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    String word = "ABCCED";
    WordSearch wordSearch = new WordSearch();
    System.out.println(wordSearch.exist(board,word));
  }

  public boolean exist(char[][] board, String word) {
    int x = board.length;
    if(x<1) {
      return false;
    }
    int y = board[0].length;
    if(x*y < word.length()) {
      return false;
    }
    Stack<int[]> positions = new Stack<>();
    for(int i=0;i<x;i++) {
      for(int j=0;j<y;j++) {
        if(board[i][j]==word.charAt(0)) {
          boolean[][] cache = new boolean[x][y];
          if(word.length()==1) {
            return true;
          }
          cache[i][j]=true;
          addPoint(positions,cache,i,x,j,y);
          while(!positions.empty()) {
            int[] point = positions.pop();
            if(exist(board,point,word,1,cache)) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }

  public boolean exist(char[][] board,int[] point, String word, int index,boolean[][] cache ) {
    if(index>word.length()-1) {
      return false;
    }
    Stack<int[]> positions = new Stack<>();
    int x = board.length;
    int y = board[0].length;
    if(board[point[0]][point[1]]==word.charAt(index)) {
      if(index==word.length()-1) {
        return true;
      }
      cache[point[0]][point[1]] = true;
      addPoint(positions,cache,point[0],x,point[1],y);
      while(!positions.empty()) {
        int[] nextPoint = positions.pop();
        if(exist(board,nextPoint,word,index+1,cache)) {
          return true;
        }
      }
      cache[point[0]][point[1]] = false;
    }
    return false;
  }

  public void addPoint(Stack<int[]> positions, boolean[][] cache, int i, int x, int j, int y) {
    if(i-1>=0 && !cache[i-1][j]) {
      int[] point = new int[2];
      point[0]=i-1;
      point[1]=j;
      positions.push(point);
    }
    if(i+1<=x-1 && !cache[i+1][j]) {
      int[] point = new int[2];
      point[0]=i+1;
      point[1]=j;
      positions.push(point);
    }
    if(j-1>=0 && !cache[i][j-1]) {
      int[] point = new int[2];
      point[0]=i;
      point[1]=j-1;
      positions.push(point);
    }
    if(j+1<=y-1 && !cache[i][j+1]) {
      int[] point = new int[2];
      point[0]=i;
      point[1]=j+1;
      positions.push(point);
    }
  }
}
