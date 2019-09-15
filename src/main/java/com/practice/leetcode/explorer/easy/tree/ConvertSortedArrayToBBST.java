package com.practice.leetcode.explorer.easy.tree;

import java.util.ArrayList;
import java.util.List;

import static com.practice.leetcode.explorer.easy.tree.ValidateBST.getValPreOrder;

public class ConvertSortedArrayToBBST {
  public static void main(String[] args) {
    int[] nums = {1,3};
    TreeNode node = sortedArrayToBST(nums);
    List<Integer> vals = new ArrayList<>();
    getValPreOrder(node,vals);
    vals.stream().forEach(System.out::println);
  }

  public static TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 0) {
      return null;
    }
    if (nums.length == 1) {
      return new TreeNode(nums[0]);
    }
    int min = 0;
    int max = nums.length - 1;
    int mid = (nums.length - 1) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    if(min+mid>min) {
      insertLeft(root, nums, min, mid - 1);
    }
    if(min+mid<max) {
      insertRight(root, nums, mid + 1, max);
    }
    return root;
  }

  private static void insertRight(TreeNode root, int[] nums, int min, int max) {
    int mid = (max-min) / 2;
    root.right = new TreeNode(nums[min+mid]);
    if(min+mid>min) {
      insertLeft(root.right, nums, min, min+mid-1);
    }
    if(min+mid<max) {
      insertRight(root.right, nums, min+mid+1, max);
    }

  }

  private static void insertLeft(TreeNode root, int[] nums, int min, int max) {
    int mid = (max - min) / 2;
    root.left = new TreeNode(nums[min+mid]);
    if(min+mid>min) {
      insertLeft(root.left, nums, min, min+mid-1);
    }
    if(min+mid<max) {
      insertRight(root.left, nums, min+mid+1, max);
    }
  }
}
