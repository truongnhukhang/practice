package com.practice.leetcode.explorer.easy.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class SymmetricTree {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(2);
//    root.left.right = new TreeNode(1);
//    root.left.left.left = new TreeNode(2);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(2);
//    root.right.right = new TreeNode(2);
//    root.right.right.left = new TreeNode(1);
    System.out.println(isSymmetric(root));
  }

  public static boolean isSymmetric(TreeNode root) {
    if(root==null) {
      return true;
    }
    TreeNode left = root.left;
    TreeNode right = root.right;
    if(left==null && right==null) {
      return true;
    }
    if(right==null || left==null) {
      return false;
    }
    return isSymmetric(left,right);
  }

  private static boolean isSymmetric(TreeNode left, TreeNode right) {
    if(left==null && right==null) {
      return true;
    }
    if(right==null || left==null) {
      return false;
    }
    if(left.val!=right.val) {
      return false;
    }
    return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
  }


}
