package com.practice.leetcode.explorer.easy.tree;

public class MaximumDepthOfBinarySearchTree {
  public static void main(String[] args) {

  }

  public static int maxDepth(TreeNode root) {
    if(root.left==null && root.right==null) {
      return 1;
    }
    int leftHeight = 1 + (root.left==null ? 0 : maxDepth(root.left));
    int rightHeight = 1 + (root.right==null ? 0 : maxDepth(root.right));
    return Math.max(leftHeight,rightHeight);
  }
}
