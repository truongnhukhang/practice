package com.practice.leetcode.explorer.medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Subsets {
  public static void main(String[] args) {
    int[] nums = {1,2,3};
    Subsets subsets = new Subsets();
    subsets.subsets(nums).stream().forEach(list -> {
      System.out.println(list.stream().map(i->String.valueOf(i)).collect(Collectors.joining(",")));
    });
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> results = subsets(nums,0);
    results.add(new ArrayList<>());
    return results;
  }

  public List<List<Integer>> subsets(int[] nums,int index) {
    List<List<Integer>> results = new ArrayList<>();
    if(index==nums.length-1) {
      List<Integer> lastSubset = new ArrayList<>();
      lastSubset.add(nums[index]);
      results.add(lastSubset);
      return results;
    }
    if(index <= nums.length-1) {
      results.add(Arrays.asList(nums[index]));
      List<List<Integer>> subsets = subsets(nums,index+1);
      results.addAll(subsets);
      for(int i=0;i<subsets.size();i++) {
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[index]);
        temp.addAll(subsets.get(i));
        results.add(temp);
      }
    }
    return results;
  }
}
