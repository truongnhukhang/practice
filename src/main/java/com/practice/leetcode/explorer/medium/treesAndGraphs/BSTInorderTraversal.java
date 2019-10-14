package com.practice.leetcode.explorer.medium.treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class BSTInorderTraversal {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(10);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(15);
    inorderTraversal(root).stream().forEach(System.out::println);
  }

  public static List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if(root!=null) {
      if(root.left!=null) {
        inorderTraversal(root.left,result);
      }
      result.add(root.val);
      if(root.right!=null) {
        inorderTraversal(root.right,result);
      }
    }
    return result;
  }
  public static void inorderTraversal(TreeNode root,List<Integer> list) {
    if(root.left!=null) {
      inorderTraversal(root.left,list);
    }
    list.add(root.val);
    if(root.right!=null) {
      inorderTraversal(root.right,list);
    }
  }
}
