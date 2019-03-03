package com.practice.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildTreeMinimalHeightFromSortedArray {
  public static void main(String[] args) {
    Integer[] data = new Integer[15];
    for (int i = 0; i < 15; i++) {
      data[i] = i+1;
    }
    BinarySearchTreeImplementSimple<Integer> result = buildTreeWithMinimalHeightFromSortedArray(data);
    System.out.println("Tree's height : " + result.height());
    result.levelOrderPrint();
    ;
  }

  static BinarySearchTreeImplementSimple<Integer> buildTreeWithMinimalHeightFromSortedArray(Integer[] data) {
    BinarySearchTreeImplementSimple<Integer> tree = new BinarySearchTreeImplementSimple<>();
    Long minHeight = Math.round(Math.log(data.length)/Math.log(2));
    System.out.println("Min Height : " + minHeight);
    buildTree(tree,data);
    return tree;
  }

  static void buildTree(BinarySearchTreeImplementSimple<Integer> tree,Integer[] data) {
    int midIndex = (data.length-1)/2;
    tree.insert(data[midIndex]);
    int leftMidIndex = midIndex/2;
    int rightMidIndex = midIndex+(midIndex-leftMidIndex);
    if(leftMidIndex>0) {
      List<Integer> leftList = Arrays.asList(data).subList(0, midIndex);
      Integer[] lefData = leftList.toArray(new Integer[leftList.size()]);
      buildTree(tree,lefData);
    } else {
      tree.insert(data[leftMidIndex]);
    }
    if(rightMidIndex<data.length-1) {
      List<Integer> rightList = Arrays.asList(data).subList(midIndex+1, data.length);
      Integer[] rightData = rightList.toArray(new Integer[rightList.size()]);
      buildTree(tree,rightData);
    } else {
      tree.insert(data[rightMidIndex]);
    }
  }
}
