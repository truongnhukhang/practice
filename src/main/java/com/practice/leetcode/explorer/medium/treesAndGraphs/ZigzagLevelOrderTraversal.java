package com.practice.leetcode.explorer.medium.treesAndGraphs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by truongnhukhang on 12/23/19.
 */
public class ZigzagLevelOrderTraversal {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.left.left = new TreeNode(2);
//    root.left.right = new TreeNode(4);
    root.right = new TreeNode(10);
//    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(15);
    ZigzagLevelOrderTraversal zigzagLevelOrderTraversal = new ZigzagLevelOrderTraversal();
    zigzagLevelOrderTraversal.zigzagLevelOrder(root).stream().forEach(list -> {
      System.out.println(list.stream().map(i->String.valueOf(i)).collect(Collectors.joining(",")));
    });
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if(root==null) {
      return new ArrayList<>();
    }
    Deque<TreeNode> nodeDeque = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    nodeDeque.offerFirst(root);
    nodeDeque.offerLast(null);
    int curLevel = 1;
    while (!nodeDeque.isEmpty()) {
      TreeNode node = null;
      boolean needNewLevel = false;
      if(curLevel%2==1) {
        node = nodeDeque.pollFirst();
        needNewLevel = nodeDeque.peekFirst()==null;
      } else {
        node = nodeDeque.pollLast();
        needNewLevel = nodeDeque.peekLast()==null;
      }

      if(node==null) {
        break;
      }

      List<Integer> oldNodes = result.get(result.size()-1);
      oldNodes.add(node.val);

      if((curLevel+1)%2==0) {
        if(node.left!=null) {
          nodeDeque.offerLast(node.left);
        }
        if(node.right!=null) {
          nodeDeque.offerLast(node.right);
        }
      } else {
        if(node.right!=null) {
          nodeDeque.offerFirst(node.right);
        }
        if(node.left!=null) {
          nodeDeque.offerFirst(node.left);
        }
      }

      if(needNewLevel && nodeDeque.size()!=1) {
        result.add(new ArrayList<>());
        curLevel++;
      }

    }
    return result;
  }
}
