package com.practice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

  public static void main(String[] args) {
    int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
    RottingOranges rottingOranges = new RottingOranges();
    System.out.println(rottingOranges.orangesRotting(grid));
  }

  public int orangesRotting(int[][] grid) {
    if(grid.length==0) {
      return 0;
    }
    Queue<int[]> rottenQ = new LinkedList<>();
    int freshCount = 0;
    for(int i=0;i<grid.length;i++) {
      for(int j=0;j<grid[i].length;j++) {
        if(grid[i][j]==2) {
          int[] rottenPos = new int[2];
          rottenPos[0]=i;
          rottenPos[1]=j;
          rottenQ.offer(rottenPos);
        } else if(grid[i][j]==1){
          freshCount++;
        }
      }
    }

    if(freshCount==0) {
      return 0;
    }
    System.out.println("freshCount : " + freshCount);
    int minutes = 0;
    while(rottenQ.size()>0 && freshCount>0) {
      int curSize = rottenQ.size();
      System.out.println("Cursize : " + curSize);
      while(curSize>0) {
        int[] rottenPos = rottenQ.poll();
        int numAffect = affectOrange(rottenPos,grid,rottenQ);
        freshCount = freshCount - numAffect;
        System.out.println("numAffect : " + numAffect +" - freshCount: "+ freshCount);
        curSize--;
      }
      minutes++;
    }
    if(freshCount>0) {
      return -1;
    }
    return minutes;
  }

  public int affectOrange(int[] pos, int[][] grid, Queue<int[]> rottenQ) {
    int i = pos[0];
    int j = pos[1];
    int affected = 0;
    if(i-1>=0 && grid[i-1][j]==1) {
      int[] rottenPos = new int[2];
      rottenPos[0]=i-1;
      rottenPos[1]=j;
      rottenQ.offer(rottenPos);
      grid[rottenPos[0]][rottenPos[1]]=2;
      System.out.println("Add : [" +rottenPos[0]+","+rottenPos[1]+"]");
      affected++;
    }
    if(i+1<grid.length && grid[i+1][j]==1) {
      int[] rottenPos = new int[2];
      rottenPos[0]=i+1;
      rottenPos[1]=j;
      rottenQ.offer(rottenPos);
      grid[rottenPos[0]][rottenPos[1]]=2;
      System.out.println("Add : [" +rottenPos[0]+","+rottenPos[1]+"]");
      affected++;
    }
    if(j-1>=0 && grid[i][j-1]==1) {
      int[] rottenPos = new int[2];
      rottenPos[0]=i;
      rottenPos[1]=j-1;
      rottenQ.offer(rottenPos);
      grid[rottenPos[0]][rottenPos[1]]=2;
      System.out.println("Add : [" +rottenPos[0]+","+rottenPos[1]+"]");
      affected++;
    }
    if(j+1<grid[i].length && grid[i][j+1]==1) {
      int[] rottenPos = new int[2];
      rottenPos[0]=i;
      rottenPos[1]=j+1;
      rottenQ.offer(rottenPos);
      System.out.println("Add : [" +rottenPos[0]+","+rottenPos[1]+"]");
      grid[rottenPos[0]][rottenPos[1]]=2;
      affected++;
    }
    return affected;
  }
}
