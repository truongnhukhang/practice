package com.practice.leetcode.explorer.medium.TreesAndGraphs;

import java.util.ArrayDeque;
import java.util.Queue;

public class PopulatingNextRightPointers {
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.left.left=new Node(4);
    root.left.right=new Node(5);
    root.right = new Node(3);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    root = connect(root);
    System.out.println(root.val);
  }

  public static Node connect(Node root) {
    if(root==null) {
      return root;
    }
    int height = 0;
    int count = 0;
    Queue<Node> nodeQueue = new ArrayDeque<>();
    nodeQueue.add(root);
    while (!nodeQueue.isEmpty()) {
      Node cur = nodeQueue.poll();
      count++;
      if(cur.left!=null) {
        nodeQueue.add(cur.left);
      }
      if(cur.right!=null) {
        nodeQueue.add(cur.right);
      }
      if(Math.pow(2,height)==count) {
        count=0;
        height++;
        cur.next=null;
      } else {
        cur.next=nodeQueue.peek();
      }
    }
    return root;
  }
}
