package com.practice.leetcode;

public class NumArray {

  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6};
    NumArray numArray = new NumArray(nums);
    System.out.println(numArray.sumRange(0,1));
    System.out.println(numArray.sumRange(0,5));
    numArray.update(1,10);
    System.out.println(numArray.sumRange(0,0));
    System.out.println(numArray.sumRange(1,1));
    System.out.println(numArray.sumRange(0,1));
    System.out.println(numArray.sumRange(0,5));

  }

  int[] tree = null;
  int[] source = null;
  public NumArray(int[] nums) {
    Double height = Math.ceil(Math.sqrt(nums.length));
    tree = new int[(int) (Math.pow(2d, height.intValue()+1)-1)];
    source = nums;
    buildSegmentTree();
  }

  public void buildSegmentTree() {
    int start = 0;
    int end = source.length-1;
    int root = 1;
    buildNode(root,start,end);
  }

  public void buildNode(int node, int start, int end) {
    if(start==end) {
      tree[node-1] = source[start];
    } else if(start<end) {
      int mid = (start+end)/2;
      // build left child
      int leftChild = node * 2;
      buildNode(leftChild,start,mid);
      // build right child
      int rightChild = node * 2 + 1;
      buildNode(rightChild,mid+1,end);
      // sum children val
      tree[node-1] = tree[leftChild-1] + tree[rightChild-1];
    }
  }

  public void update(int i, int val) {
    int start = 0;
    int end = source.length-1;
    int mid = (start+end)/2;
    int root = 1;
    int leftChild = root * 2;
    int rightChild = root * 2 + 1;
    if(i>mid) {
      updateNode(i,val,mid+1,end,root*2+1);
    } else {
      updateNode(i,val,start,mid,root*2);
    }
    tree[root-1] = tree[leftChild-1] + tree[rightChild-1];

  }

  public void updateNode(int i, int val, int start, int end, int node) {
    if(start>=end) {
      source[i] = val;
      tree[node-1] = val;
    } else {
      int mid = (start+end)/2;
      int leftChild = node * 2;
      int rightChild = node * 2 + 1;
      if(i>mid) {
        updateNode(i,val,mid+1,end,rightChild);
      } else {
        updateNode(i,val,start,mid,leftChild);
      }

      tree[node-1] = tree[leftChild-1] + tree[rightChild-1];
    }

  }

  public int sumRange(int i, int j) {
    int root = 1;
    int start = 0;
    int end = source.length-1;
    return sumRange(root,i,j,start,end);
  }

  public int sumRange(int node, int left,int right, int start, int end) {
    if(left < start || right > end) {
      return 0;
    }
    if(left== start && right==end) {
      return tree[node-1];
    } else {
      int mid = (start+end)/2;
      int rightNode = node * 2+1;
      int leftNode = node * 2;
      int result = 0 ;
      if(left > mid ) {
        // in the right subtree;
        return sumRange(rightNode,left,right,mid+1,end);
      } else if(right <= mid) {

        return sumRange(leftNode,left,right,start,mid);
        // in the left subtree;
      }
      result = sumRange(leftNode,left,mid,start,mid) + sumRange(rightNode,mid+1,right,mid+1,end);
      return result;
    }
  }
}
