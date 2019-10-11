package com.practice.leetcode.explorer.medium.TreesAndGraphs;

public class ConstructBSTFromInAndPreOrder {
  public static void main(String[] args) {
    int[] pre = {1,2,4,5,3,6,7};
    int[] in = {4,2,5,1,6,3,7};
    TreeNode root = buildTree(pre,in);
    System.out.println(root.val);
  }

  public static TreeNode buildTree(int[] preorder,int[] inorder) {
    if(inorder.length==0 || preorder.length==0) {
      return null;
    }
    int rootVal = preorder[0];
    TreeNode root = new TreeNode(rootVal);
    if(preorder.length==1) {
      return root;
    }
    int rootIndex = 0;
    for (int i = 0; i < inorder.length; i++) {
      if(inorder[i]==rootVal) {
        rootIndex = i;
        break;
      }
    }
    int[] subLeftPreOrder = new int[rootIndex];
    for (int i = 0; i < rootIndex; i++) {
      subLeftPreOrder[i] = preorder[i+1];
    }
    int[] subLeftInOrder = new int[rootIndex];
    for (int i = 0; i < rootIndex; i++) {
      subLeftInOrder[i] = inorder[i];
    }
    int[] subRightPreOrder = new int[preorder.length-rootIndex-1];
    for (int i = 0; i < preorder.length - rootIndex - 1; i++) {
      subRightPreOrder[i] = preorder[rootIndex+1+i];
    }
    int[] subRightInOrder = new int[inorder.length-rootIndex-1];
    for (int i = 0; i < inorder.length-rootIndex-1; i++) {
      subRightInOrder[i] = inorder[rootIndex+1+i];
    }

    root.left = buildTree(subLeftPreOrder,subLeftInOrder);
    root.right = buildTree(subRightPreOrder,subRightInOrder);
    return root;
  }

  private static TreeNode buildSubTree(int[] preorder, int fromPre, int toPre, int[] inorder, int fromIn, int toIn) {
    if(toPre<=fromPre) {
      return new TreeNode(inorder[fromPre]);
    }
    int rootVal = inorder[fromIn];
    TreeNode root = new TreeNode(rootVal);
    int rootIndex = 0;
    for (int i = fromPre; i <=toPre; i++) {
      if(preorder[i]==rootVal) {
        rootIndex = i;
      }
    }
    root.left = buildSubTree(preorder,fromPre,rootIndex-1,inorder,fromIn+1,rootIndex);
    root.right=buildSubTree(preorder,rootIndex+1,toPre,inorder,rootIndex+1,toIn);
    return root;
  }
}
