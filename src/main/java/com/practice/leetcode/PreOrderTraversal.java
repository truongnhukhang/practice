package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(8);
    root.left = new TreeNode(4);
    root.right = new TreeNode(12);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(14);
//    TreeNode root = new TreeNode(1);
//    root.right = new TreeNode(2);
//    root.right.left = new TreeNode(3);
    postorderTraversal(root).forEach(System.out::println);
  }

  public static List<Integer> postorderTraversal(TreeNode root) {
    if(root==null) {
      return new ArrayList<>();
    }
    Stack<TreeNode> treeNodeStack = new Stack<>();
    Stack<TreeNode> traveledNode = new Stack<>();
    List<Integer> result = new ArrayList<>();
    TreeNode left = root.left;
    TreeNode right = root.right;
    if(right!=null) {
      treeNodeStack.push(right);
    }

    if(left!=null) {
      treeNodeStack.push(left);
    }
    treeNodeStack.push(root);
    traveledNode.push(root);
    TreeNode instructor = null;
    TreeNode tempNode = null;
    while (!treeNodeStack.empty()) {
      tempNode = treeNodeStack.pop();
      left = tempNode.left;
      right = tempNode.right;
      if(!traveledNode.isEmpty()) {
        instructor = traveledNode.peek();
      }
      if((left!=null || right!=null) && instructor!=tempNode) {
        if(right!=null) {
          treeNodeStack.push(right);
        }
        traveledNode.push(tempNode);
        if(left!=null) {
          treeNodeStack.push(left);
        }
        treeNodeStack.push(tempNode);
      } else {
        result.add(tempNode.val);
        if(!traveledNode.isEmpty() && instructor==tempNode) {
          traveledNode.pop();
          instructor = null;
        }
      }
    }
    return result;
  }
}
