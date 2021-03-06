package com.practice.leetcode.explorer.medium.dynamicPrograming;

import java.util.HashMap;
import java.util.Map;

public class JumpGame {

  Map<String,Boolean> canJumpMap = new HashMap<>();

  public static void main(String[] args) {
    int[] nums = {1,1,2,2,0,1,1};
    JumpGame jumpGame = new JumpGame();
    System.out.println("Memory : " + jumpGame.canJumpMemory(nums));
    System.out.println("Greedy : " + jumpGame.canJumpGreedy(nums));
    System.out.println("Matrix : " + jumpGame.canJumpMatrix(nums));
    System.out.println("DP : " + jumpGame.canJump(nums));
  }

  public boolean canJump(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if(canJump(nums,i,nums.length-1)) {
        return true;
      }
    }
    return false;
  }

  public boolean canJumpGreedy(int[] nums) {
    if(nums.length==1) {
      return true;
    }
    int maxJumpIndex = nums[0];
    int lastIndex = nums.length-1;
    for (int i = 1; i < lastIndex; i++) {
      if(i <= maxJumpIndex) {
        if(nums[i]+i>maxJumpIndex) {
          maxJumpIndex = nums[i] + i;
        }
      }
    }
    return maxJumpIndex >= lastIndex;
  }

  public boolean canJumpMemory(int[] nums) {
    int[] memorize = new int[nums.length];
    // we always jump at first steps;
    memorize[0] = 1;
    int length = nums.length;
    for (int i = 0; i < length-1; i++) {
      int jumps = nums[i];
      int memCount = i+1;
      while (jumps>0) {
        if(memCount<memorize.length) {
          memorize[memCount] = 1;
        }
        memCount++;
        jumps--;
      }
    }
    for (int i = 0; i < length; i++) {
      if(memorize[i]==0) {
        return false;
      }
    }
    return true;
  }

  public boolean canJumpMatrix(int[] nums) {
    if(nums.length==1) {
      return true;
    }
    int[][] matrix = new int[nums.length][nums.length];
    buildingMatrix(matrix,nums);
//    for (int i = 0; i < matrix.length; i++) {
//      System.out.println("");
//      for (int j = 0; j < matrix.length; j++) {
//        System.out.print(" " + matrix[i][j]);
//      }
//    }
//    System.out.println("");
    for (int i = 0; i < matrix.length; i++) {
      if(matrix[i][i]==0) {
        return false;
      }
    }
    return true;
  }

  public void buildingMatrix(int[][] matrix, int[] nums) {
    for (int i = 0; i < matrix.length; i++) {
      int jumpCount = nums[i];
      if(i!=0) {
        matrix[i][i] = matrix[i-1][i];
      } else {
        // we always can jump at first position
        matrix[0][0] = 1;
      }
      for (int j = i+1; j < matrix.length; j++) {
        // start Jumping
        if(i-1>=0) {
        // 1. If not the first jumping , can look the prv jumping to copy the farthest position
          if(jumpCount > 0 || matrix[i-1][j]==1) {
            jumpCount--;
            matrix[i][j] = 1;
          } else {
            break;
          }
        } else {
        // 2. We are the first one .
          if(jumpCount > 0) {
            matrix[i][j] = 1;
            jumpCount--;
          } else {
            break;
          }
        }
      }
    }
  }

  public boolean canJump(int[] nums,int index,int maxIndex) {
    String key = "" + index + "|" + maxIndex;
    boolean canJump = false;
    if(canJumpMap.get(key)!=null) {
      return canJumpMap.get(key);
    }
    if(index==0) {
      return nums[0]>=maxIndex;
    }
    if(nums[index]>=maxIndex-index) {
      for (int i = 0; i < index ; i++) {
        if(canJump(nums,i,index)) {
          canJump = true;
          break;
        }
      }
    }
    canJumpMap.put(key,canJump);
    return canJump;
  }
}
