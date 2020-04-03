package com.practice.leetcode;

import java.util.LinkedList;

public class LargestRectangleHistogram {
  public static void main(String[] args) {
    int[] heights = {2,1,4,5,1,3,3};
    System.out.println(new LargestRectangleHistogram().largestRectangleArea(heights));
    heights = new int[]{2,1,2};
    System.out.println(new LargestRectangleHistogram().largestRectangleArea(heights));
    heights = new int[]{1,1};
    System.out.println(new LargestRectangleHistogram().largestRectangleArea(heights));
    heights = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println(new LargestRectangleHistogram().largestRectangleArea(heights));
    heights = new int[]{1,2,3,4,5};
    System.out.println(new LargestRectangleHistogram().largestRectangleArea(heights));

  }

  public int largestRectangleArea(int[] heights) {
    LinkedList<int[]> icrList = new LinkedList<>();
    LinkedList<int[]> tempList = new LinkedList<>();
    icrList.addLast(new int[]{0,heights[0]});
    int max = heights[0];
    for (int i = 1; i < heights.length; i++) {
      int count = icrList.size();
      int val = heights[i];
      while(count>0) {
        int idx = icrList.pollLast();
        int tempMax = 0;
        if(val>=heights[idx]) {
          if(!icrList.isEmpty()) {
            tempMax = heights[idx] * (i-icrList.getLast());
          } else {
            tempMax = heights[idx] * (i-idx+1);
          }
          tempList.addFirst(idx);
        } else {
          if(!icrList.isEmpty()) {
            tempMax = val * (i-icrList.getLast());
          } else {
            tempMax = val * (i-idx+1);
          }
        }
        tempMax = Math.max(tempMax,val);
        if(tempMax>max) {
          max = tempMax;
        }
        count--;
      }
      if(tempList.size()>0) {
        icrList.addFirst(tempList.pollLast());
        while (tempList.size()>0) {
          Integer id = tempList.pollLast();
          if(heights[id]*(i-id+1) > heights[icrList.getLast()]*(i-icrList.getLast()+1)) {
            icrList.addFirst(id);
          }
        }
      }

      if(icrList.size()==0 || heights[icrList.getLast()] < val) {
        icrList.addLast(i);
      }
    }
    return max;
  }
}
