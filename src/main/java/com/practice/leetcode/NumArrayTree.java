package com.practice.leetcode;

public class NumArrayTree {

  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6};
    NumArrayTree numArray = new NumArrayTree(nums);
    System.out.println(numArray.sumRange(0,1));
    System.out.println(numArray.sumRange(0,5));
    numArray.update(1,10);
    System.out.println(numArray.sumRange(0,0));
    System.out.println(numArray.sumRange(1,1));
    System.out.println(numArray.sumRange(0,1));
    System.out.println(numArray.sumRange(0,5));
  }

  public class Segment {
    public int start;
    public int end;
    public int val;
    public Segment left;
    public Segment right;
  }

  Segment root;

  public NumArrayTree(int[] nums) {
    root = new Segment();
    buildSegmentTree(nums,root,0,nums.length-1);
  }

  public void buildSegmentTree(int[] nums,Segment root,int start,int end) {
    if(start==end) {
      root.val = nums[start];
    } else {
      int mid = (start+end)/2;
      root.left = new Segment();
      buildSegmentTree(nums,root.left,start,mid);
      root.right = new Segment();
      buildSegmentTree(nums,root.right,mid+1,end);
      root.val = root.left.val+root.right.val;
    }
    root.start = start;
    root.end = end;
  }

  public void update(int i,int val) {
    update(i,val,root);
  }

  public void update(int i, int val, Segment root) {
    if(root.start==root.end) {
      root.val = val;
    } else {
      int mid = (root.start+root.end)/2;
      if(i<=mid) {
        update(i,val,root.left);
      } else {
        update(i,val,root.right);
      }
      root.val = root.left.val + root.right.val;
    }
  }

  public int sumRange(int i, int j) {
    return sumRange(i,j,root);
  }

  public int sumRange(int i, int j, Segment root) {
    if(i<root.start || j>root.end) {
      return 0;
    }
    if(i==root.start && j==root.end) {
      return root.val;
    }
    int mid = (root.start+root.end)/2;
    if(j <= mid) {
      return sumRange(i,j,root.left);
    }
    if(i>mid) {
      return sumRange(i,j,root.right);
    }
    return sumRange(i,mid,root.left) + sumRange(mid+1,j,root.right);
  }
}
