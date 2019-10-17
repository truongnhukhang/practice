package com.practice.leetcode.explorer.medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
  public static void main(String[] args) {
    Permutations permutations = new Permutations();
    permutations.permute(new int[]{1,2,3,4}).stream().forEach(list -> {
      String val = list.stream().map(integer -> String.valueOf(integer)).collect(Collectors.joining(","));
      System.out.println(val);
    });
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    if(nums.length==1) {
      result.add(Arrays.asList(nums[0]));
      return result;
    }
    for (int i = 0; i < nums.length; i++) {
      if(i!=0) {
        swap(nums,i,0);
      }
      List<List<Integer>> tempRs = permuteFrom(nums,1);
      for (int j = 0; j < tempRs.size(); j++) {
        List<Integer> integers = tempRs.get(j);
        List<Integer> total = new ArrayList<>();
        total.add(nums[0]);
        total.addAll(integers);
        result.add(total);
      }
      if(i!=0) {
        swap(nums,i,0);
      }
    }
    return result;
  }

  private List<List<Integer>> permuteFrom(int[] nums, int startFrom) {
    List<List<Integer>> result = new ArrayList<>();
    if(startFrom==nums.length-1) {
      result.add(Arrays.asList(nums[startFrom]));
      return result;
    }
    for (int i = startFrom; i < nums.length; i++) {
      if(i!=startFrom) {
        swap(nums,i,startFrom);
      }
      List<List<Integer>> tempRs = permuteFrom(nums,startFrom+1);
      for (int j = 0; j < tempRs.size(); j++) {
        List<Integer> integers = tempRs.get(j);
        List<Integer> total = new ArrayList<>();
        total.add(nums[startFrom]);
        total.addAll(integers);
        result.add(total);
      }
      if(i!=startFrom) {
        swap(nums,i,startFrom);
      }
    }
    return result;
  }

  public void swap(int[] nums,int index1,int index2) {
    nums[index1] = nums[index2] ^ nums[index1];
    nums[index2] = nums[index2] ^ nums[index1];
    nums[index1] = nums[index2] ^ nums[index1];
  }
}
