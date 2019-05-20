package com.practice.arrayAndString;

import java.util.Arrays;
import java.util.stream.Stream;

public class FindMaxSubArray {
  public static void main(String[] args) {
//    int[] a = {-1,1,2,3,-2,4,-2,2,1};
    int[] a = {-1,1,2,3,4};
    MaxSub maxSubArray = findMaxSubArray(a);
    System.out.println(maxSubArray);
    System.out.println(maxSubArray.countMaxSub(a));
  }

  private static MaxSub findMaxSubArray(int[] a) {
   if(a.length==1) {
     return new MaxSub(0,0);
   }
   int mid = (a.length-1)  /2;
   int[] left = subArray(a,0,mid);
   int[] right = subArray(a,mid+1, a.length-1);
   MaxSub maxSubLeft = findMaxSubArray(left,0,mid);
   MaxSub maxSubRight = findMaxSubArray(right,mid+1,  a.length-1);
   MaxSub maxSubCross = findMaxCross(a,maxSubLeft.to, maxSubRight.from,mid);
   MaxSub maxSub = Arrays.asList(maxSubLeft,maxSubRight,maxSubCross).stream().max((o1, o2) -> o1.countMaxSub(a)-o2.countMaxSub(a)).get();
   return maxSub;
  }

  private static MaxSub findMaxSubArray(int[] a,int fromIndex,int toIndex) {
    if(a.length==1) {
      return new MaxSub(fromIndex,toIndex);
    }
    if(a.length==2) {
      MaxSub maxSubLeft = new MaxSub(fromIndex,fromIndex);
      MaxSub maxSubRight = new MaxSub(toIndex,toIndex);
      MaxSub maxCross = new MaxSub(fromIndex,toIndex);
      MaxSub maxSub = Arrays.asList(maxSubLeft,maxSubRight,maxCross).stream().max((o1, o2) -> o1.countMaxSub(a)-o2.countMaxSub(a)).get();
      return maxSub;
    }
    int mid = (a.length-1)  /2;
    int[] left = subArray(a,0,mid);
    int[] right = subArray(a,mid+1,  a.length-1);
    MaxSub maxSubLeft = findMaxSubArray(left,0,mid);
    maxSubLeft.from = maxSubLeft.from+fromIndex;
    maxSubLeft.to = maxSubLeft.to+toIndex;
    MaxSub maxSubRight = findMaxSubArray(right,mid+1, a.length-1);
    maxSubRight.from = maxSubRight.from+fromIndex;
    maxSubRight.to = maxSubRight.to+toIndex;
    MaxSub maxCross = findMaxCross(a,maxSubLeft.to,maxSubRight.from,mid);
    maxCross.from = maxCross.from+fromIndex;
    maxCross.to = maxCross.to+toIndex;
    MaxSub maxSub = Arrays.asList(maxSubLeft,maxSubRight,maxCross).stream().max((o1, o2) -> o1.countMaxSub(a)-o2.countMaxSub(a)).get();
    return maxSub;
  }

  private static MaxSub findMaxCross(int[] a,int fromIndex,int toIndex,int mid) {
    int leftMax = 0;
    int rightMax = 0;
    MaxSub lefMaxSub = null;
    for (int i = mid; i >=fromIndex ; i--) {
      if(leftMax+a[i] >= leftMax) {
        leftMax = leftMax + a[i];
        lefMaxSub = new MaxSub(fromIndex,i);
      } else {
        break;
      }
    }
    MaxSub rightMaxSub = null;
    for (int i = mid; i <=toIndex ; i++) {
      if(leftMax+a[i] >= leftMax) {
        rightMax = rightMax + a[i];
        rightMaxSub = new MaxSub(fromIndex,i);
      } else {
        break;
      }
    }
    MaxSub cross = new MaxSub(fromIndex,toIndex);
    if(lefMaxSub!=null) {
      cross.from = lefMaxSub.from;
    }
    if(rightMaxSub!=null) {
      cross.to = rightMaxSub.to;
    }
    return cross;
  }

  private static int[] subArray(int[] a,int from,int to) {
    if(to!=from) {
      int[] result = new int[to-from+1];
      int count =0;
      for (int i = from; i <= to; i++) {
        result[count] = a[i];
        count++;
      }
      return result;
    } else {
      return new int[] {a[from]};
    }

  }


}
