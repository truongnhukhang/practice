package com.practice.leetcode.explorer.medium.treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(4);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(5);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(15);
    System.out.println(kthSmallest(root,4));
  }

  public static int kthSmallest(TreeNode root, int k) {
    List<Integer> nums = new ArrayList<>();
    if(root.left!=null) {
      preOrder(root.left,nums,k);
    }
    if(nums.size()<k) {
      nums.add(root.val);
    }
    if(nums.size() < k && root.right != null) {
      preOrder(root.right, nums, k);
    }
    return nums.get(k-1);
  }

  public static void preOrder(TreeNode root, List<Integer> nums, int k) {
    if (nums.size() < k && root.left != null) {
      preOrder(root.left, nums, k);
    }
    nums.add(root.val);
    if (nums.size() < k && root.right != null) {
      preOrder(root.right, nums, k);
    }
  }
}
