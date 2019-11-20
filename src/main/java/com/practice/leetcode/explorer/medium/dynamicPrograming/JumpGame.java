package com.practice.leetcode.explorer.medium.dynamicPrograming;

import java.util.HashMap;
import java.util.Map;

public class JumpGame {

  Map<String,Boolean> canJumpMap = new HashMap<>();

  public static void main(String[] args) {
    int[] nums = {4,0,1,1,4,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
    JumpGame jumpGame = new JumpGame();
    System.out.println(jumpGame.canJump(nums));
  }

  public boolean canJump(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      if(canJump(nums,i,nums.length-1)) {
        return true;
      }
    }
    return false;
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
