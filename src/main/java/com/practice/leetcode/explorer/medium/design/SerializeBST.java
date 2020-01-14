package com.practice.leetcode.explorer.medium.design;

import com.practice.leetcode.explorer.medium.treesAndGraphs.Node;
import com.practice.leetcode.explorer.medium.treesAndGraphs.TreeNode;

import java.util.LinkedList;

public class SerializeBST {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(-2);
    root.left.left = new TreeNode(2);
    root.left.left.left = new TreeNode(7);
    root.left.right = new TreeNode(4);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(9);
    root.right = new TreeNode(1);
    root.right.left = new TreeNode(3);
    root.right.left.left = new TreeNode(4);
    root.right.left.left.left = new TreeNode(5);
    root.right.left.left.right = new TreeNode(5);
    root.right.left.right = new TreeNode(8);
    root.right.right = new TreeNode(5);
    SerializeBST serializeBST = new SerializeBST();
    String data = serializeBST.serializeBrackets(root);
    System.out.println(data);
    TreeNode temp = serializeBST.deserializeBrackets(data);
    System.out.println(temp.val);
    System.out.println(serializeBST.serializeBrackets(temp));
  }

  public String serializeBrackets(TreeNode root) {
    if(root==null) {
      return "n";
    } else {
      String result = root.val+"";
      String leftSubTree = serializeBrackets(root.left);
      String rightSubTree= serializeBrackets(root.right);
      if(leftSubTree.equals("n") && rightSubTree.equals("n")) {
        return result;
      }
      return result+"("+leftSubTree+","+rightSubTree+")";
    }
  }

  public TreeNode deserializeBrackets(String data) {
    if(data.equals("n")) {
      return null;
    }
    TreeNode root = new TreeNode(Character.getNumericValue(data.charAt(0)));
    if(data.length()==1) {
      return root;
    }
    TreeNode left = new TreeNode(Integer.MIN_VALUE);
    int leftFinishIndex = deserializeNode(left,2,data);
    if(leftFinishIndex!=-1) {
      root.left = left;
    }
    if(data.charAt(leftFinishIndex)==',') {
      TreeNode right = new TreeNode(Integer.MAX_VALUE);
      int rightFinishIndex =deserializeNode(right,leftFinishIndex+1,data);
      if(rightFinishIndex!=-1) {
        root.right = right;
      }
    }
    return root;
  }

  public int deserializeNode(TreeNode node,int startPoint,String data) {
    if(data.charAt(startPoint)=='n') {
      return -1;
    }
    int next = 0 ;
    if(data.charAt(startPoint)=='-'){
      node.val = Integer.valueOf(data.substring(startPoint,startPoint+2));
      next = startPoint+2;
    } else {
      node.val = Character.getNumericValue(data.charAt(startPoint));
      next = startPoint+1;
    }

    if(data.charAt(next)=='(') {
      TreeNode left = new TreeNode(Integer.MIN_VALUE);
      int leftFinishIndex = deserializeNode(left,next+1,data);
      if(leftFinishIndex!=-1) {
        node.left = left;
      }
      if(data.charAt(leftFinishIndex) ==',') {
        TreeNode right = new TreeNode(Integer.MAX_VALUE);
        int rightFinishIndex = deserializeNode(right,leftFinishIndex+1,data);
        if(rightFinishIndex!=-1) {
          node.right = right;
          return rightFinishIndex+1;
        } else {
          return leftFinishIndex+2;
        }

      } else if(data.charAt(leftFinishIndex) ==')'){
        return leftFinishIndex;
      }
    } else {
      return next;
    }
    return 0;
  }

  public String serialize(TreeNode root) {
    String result = "";
    if(root!=null) {
      LinkedList<TreeNode> queue = new LinkedList<>();
      int maxNode = ((Double)Math.pow(2D,Double.valueOf(findHeight(root)))).intValue();
      queue.addFirst(root);
      TreeNode nullNode = new TreeNode(Integer.MIN_VALUE);
      int count = 1;
      while(queue.size()>0 && count <= maxNode-1) {
        TreeNode temp = queue.pollLast();
        String nodeVal = "";
        if(temp==nullNode) {
          nodeVal="null";
        } else {
          nodeVal = ""+temp.val;
        }
        result = result.equals("") ? nodeVal : result+"_"+nodeVal;
        if(temp.left!=null) {
          queue.addFirst(temp.left);
        } else {
          queue.addFirst(nullNode);
        }
        if(temp.right!=null) {
          queue.addFirst(temp.right);
        } else {
          queue.addFirst(nullNode);
        }
        count++;
      }
    }
    return result;
  }

  public int findHeight(TreeNode root) {
    if(root==null) {
      return 0;
    }
    int leftHeight = findHeight(root.left);
    int rightHeight = findHeight(root.right);
    return 1+Math.max(leftHeight,rightHeight);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if(data.equals("")) {
      return null;
    }

    String[] nodes = data.split("_");
    TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.addFirst(root);
    LinkedList<Integer> posQueue = new LinkedList<>();
    posQueue.addFirst(1);
    while(queue.size()>0) {
      TreeNode temp = queue.pollLast();
      int pos = posQueue.pollLast();
      int leftPos = pos*2;
      int rightPos = pos*2+1;
      if(leftPos-1 < nodes.length && !nodes[leftPos-1].equals("null")) {
        temp.left = new TreeNode(Integer.valueOf(nodes[leftPos-1]));
        queue.addFirst(temp.left);
        posQueue.addFirst(leftPos);
      }
      if(rightPos-1 < nodes.length && !nodes[rightPos-1].equals("null")) {
        temp.right = new TreeNode(Integer.valueOf(nodes[rightPos-1]));
        queue.addFirst(temp.right);
        posQueue.addFirst(rightPos);
      }

    }
    return root;
  }
}

