package com.practice.leetcode.explorer.easy.tree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(10);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(15);
    System.out.println(isValidBST(root));
  }

  public static boolean isValidBST(TreeNode root) {
    List<Integer> vals = new ArrayList<>();
    getValPreOrder(root,vals);
    for (int i = 1; i < vals.size(); i++) {
      if(vals.get(i) <= vals.get(i-1)) {
        return false;
      }
    }
    return true;
  }

  public static void getValPreOrder(TreeNode root,List<Integer> vals) {
    TreeNode left = root.left;
    TreeNode right = root.right;
    if(left!=null) {
      getValPreOrder(left,vals);
    }
    vals.add(root.val);
    if(right!=null) {
      getValPreOrder(right,vals);
    }
  }
}
