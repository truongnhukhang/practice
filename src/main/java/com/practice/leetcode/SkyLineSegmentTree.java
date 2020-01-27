package com.practice.leetcode;

import java.util.*;

public class SkyLineSegmentTree {

  public static void main(String[] args) {
    SkyLineSegmentTree skyLineSegmentTree = new SkyLineSegmentTree();
//    int[][] buildings = {{2,4,70},{3,8,30},{6,100,41},{7,15,70},{10,30,102},{15,25,76},{60,80,91},{70,90,72},{85,120,59}};
//    int[][] buildings= {{0,7,3},{2,4,4},{5,6,4}};
//    int[][] buildings= {{0,2,2},{3,4,3}};
    int[][] buildings= {{0,4,5},{2,3,2}};
    skyLineSegmentTree.getSkyline(buildings).stream().forEach(integers -> System.out.println(integers[0] + " - " + integers[1]));

  }

  public class Node {
    Node left, right;
    int start, end, height;
    public Node(int start, int end) {
      this.start = start;
      this.end = end;
      height = 0;
    }
  }

  public List<int[]> getSkyline(int[][] buildings) {
    List<int[]> result = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    for (int[] b : buildings){
      set.add(b[0]);
      set.add(b[1]);
    }
    List<Integer> positions = new ArrayList<>(set);
    Collections.sort(positions);
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < positions.size(); i++){
      map.put(positions.get(i), i);
    }
    Node root = buildTree(0, positions.size() - 1);
    for (int[] b : buildings){
      add(root, map.get(b[0]), map.get(b[1]), b[2]);
    }

    explore(result, positions, root);
    if(positions.size() > 0){
      result.add(new int[]{positions.get(positions.size() - 1), 0});
    }
    return result;
  }

  public Node buildTree(int start, int end) {
    if (start > end){
      return null;
    }
    Node root = new Node(start, end);
    if (start + 1 < end){
      int mid = (start + end) / 2;
      root.left = buildTree(start, mid);
      root.right = buildTree(mid, end);
    }
    return root;
  }

  public void add(Node root, int start, int end, int height) {
    if (root == null || start >= root.end || end <= root.start || root.height > height){
      return;
    }
    if (root.left == null && root.right == null){
      root.height = height;
    } else {
      add(root.left, start, end, height);
      add(root.right, start, end, height);
      root.height = Math.min(root.left.height, root.right.height);
    }
  }

  public void explore(List<int[]> result, List<Integer> positions, Node node){
    if(node == null){
      return;
    }
    if(node.left == null && node.right == null && (result.size() == 0 || result.get(result.size() - 1)[1] != node.height)){
      result.add(new int[]{positions.get(node.start), node.height});
    }else{
      explore(result, positions, node.left);
      explore(result, positions, node.right);
    }
  }
}
