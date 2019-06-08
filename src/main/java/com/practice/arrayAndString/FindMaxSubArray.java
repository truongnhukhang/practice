package com.practice.arrayAndString;

import java.util.Arrays;

public class FindMaxSubArray {
  public static void main(String[] args) {
//    int[] a = {-1,1,2,3,-2,4,-2,2,1};
//    int[] a = {-1,1,5,-3,3, -4,5, -4,-2, 6};
//    MaxSub maxSubArray = findMaxSubArray(a);
//    System.out.println(maxSubArray);
//    a = new int[] {-1,1,5,-3, 6};
//    maxSubArray = findMaxSubArray(a);
//    System.out.println(maxSubArray);
//    a = new int[] {1,1};
//    maxSubArray = findMaxSubArray(a);
//    System.out.println(maxSubArray);
//    a = new int[] {1,1,2,-3,4};
//    maxSubArray = findMaxSubArray(a);
//    System.out.println(maxSubArray);
//    a = new int[] {0,0,0,-1};
//    maxSubArray = findMaxSubArray(a);
//    System.out.println(maxSubArray);
    int[] a = new int[] {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
    MaxSub maxSubArray = findMaxSubArray(a);
    System.out.println(maxSubArray);
  }

  private static MaxSub findMaxSubArray(int[] a) {
    if (a.length == 1) {
      return new MaxSub(0, 0, a[0]);
    }
    int mid = (a.length - 1) / 2;
    int[] left = subArray(a, 0, mid);
    int[] right = subArray(a, mid + 1, a.length - 1);
    MaxSub maxSubLeft = findMaxSubArray(left, 0);
    MaxSub maxSubRight = findMaxSubArray(right, mid + 1);
    MaxSub maxCross = null;
    if (maxSubLeft.to + 1 == maxSubRight.from || maxSubLeft.from == 0 && maxSubRight.to == a.length - 1) {
      int count = 0;
      for (int i = maxSubLeft.from; i <= maxSubRight.to; i++) {
        count = count + a[i];
      }
      maxCross = new MaxSub(maxSubLeft.from, maxSubRight.to, count);
    } else {
      int[] cross = subArray(a, maxSubLeft.from, maxSubRight.to);
      maxCross = findMaxSubArray(cross, maxSubLeft.from);
    }

    MaxSub maxSub = Arrays.asList(maxSubLeft, maxSubRight, maxCross).stream().max((o1, o2) -> o1.count - o2.count).get();
    return maxSub;
  }

  private static MaxSub findMaxSubArray(int[] a, int fromIndex) {
    if (a.length == 1) {
      return new MaxSub(fromIndex, fromIndex, a[0]);
    }
    int mid = (a.length - 1) / 2;
    int[] left = subArray(a, 0, mid);
    int[] right = subArray(a, mid + 1, a.length - 1);
    MaxSub maxSubLeft = findMaxSubArray(left, 0);
    MaxSub maxSubRight = findMaxSubArray(right, mid + 1);
    MaxSub maxCross = null;
    if (maxSubLeft.to + 1 == maxSubRight.from || maxSubLeft.from == 0 && maxSubRight.to == a.length - 1) {
      int count = 0;
      for (int i = maxSubLeft.from; i <= maxSubRight.to; i++) {
        count = count + a[i];
      }
      maxCross = new MaxSub(maxSubLeft.from, maxSubRight.to, count);
    } else {
      int[] cross = subArray(a, maxSubLeft.from, maxSubRight.to);
      maxCross = findMaxSubArray(cross, maxSubLeft.from);
    }
    maxSubLeft.from = maxSubLeft.from + fromIndex;
    maxSubLeft.to = maxSubLeft.to + fromIndex;
    maxSubRight.from = maxSubRight.from + fromIndex;
    maxSubRight.to = maxSubRight.to + fromIndex;
    maxCross.from = maxCross.from+fromIndex;
    maxCross.to = maxCross.to+fromIndex;
    MaxSub maxSub = Arrays.asList(maxSubLeft, maxSubRight, maxCross).stream().max((o1, o2) -> o1.count - o2.count).get();
    return maxSub;
  }


  private static int[] subArray(int[] a, int from, int to) {
    if (to != from) {
      int[] result = new int[to - from + 1];
      int count = 0;
      for (int i = from; i <= to; i++) {
        result[count] = a[i];
        count++;
      }
      return result;
    } else {
      return new int[]{a[from]};
    }

  }


}
