package com.practice.leetcode.explorer.medium.treesAndGraphs;

/**
 * Created by truongnhukhang on 12/24/19.
 */
public class InorderSuccessorBST {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(2);
    root.left.left.left = new TreeNode(1);
    root.left.right = new TreeNode(4);
    root.right = new TreeNode(10);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(15);
    InorderSuccessorBST inorderSuccessorBST = new InorderSuccessorBST();
    TreeNode inorderSuccesor = inorderSuccessorBST.inorderSuccessor(root, root.left.right);
    int treeNode = inorderSuccesor == null ? -1 : inorderSuccesor.val;
    System.out.println(treeNode);
  }

  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if(p.right!=null) {
      // find most left
      TreeNode temp = p.right;
      while (temp.left!=null) {
        temp = temp.left;
      }
      return temp;
    }
    TreeNode nearestRightParent=null;
    TreeNode node = root;
    while (node!=null) {
      if(node.val > p.val) {
        nearestRightParent = node;
        node = node.left;
      } else if(node.val < p.val) {
        node = node.right;
      } else {
        break;
      }
    }
    if(nearestRightParent!=null) {
      return nearestRightParent;
    }
    return null;
  }
}
