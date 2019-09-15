package com.practice.leetcode.explorer.easy.sortingAndSearching;

import java.util.Random;

public class FirstBadVersion {
  static int count = 0;
  static Random random = new Random();

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    System.out.println(firstBadVersion(Integer.MAX_VALUE));
    System.out.println("Take time : " + (System.currentTimeMillis()- startTime));
    System.out.println(count);
    count=0;
    System.out.println(firstBadVersionBinarySearch(Integer.MAX_VALUE));
    System.out.println(count);
  }

  public static int firstBadVersionBinarySearch(int n) {
    int i = 1, j = n;
    while (i < j) {
      int m = i + (j-i) / 2;
      if (isBadVersion(m)) {
        j = m;
      } else {
        i = m+1;
      }
    }

    if (isBadVersion(i)) {
      return i;
    }

    return j;
  }

  public static int firstBadVersion(int n) {
    int selectedVersion = random.nextInt(n)+1;
    boolean currentVersionStatus = isBadVersion(selectedVersion);
    if(!currentVersionStatus) {
      return findFirstBadVersion(selectedVersion+1,n);
    }
    return findFirstBadVersion(0,selectedVersion-1);

  }

  private static int findFirstBadVersion(int min, int max) {
    if(max-min < 0) {
      return min;
    }
    int selectedVersion = 0;
    if(max > min) {
      selectedVersion = random.nextInt(max-min) + 1 + min;
    } else {
      selectedVersion = min;
    }
    boolean currentVersionStatus = isBadVersion(selectedVersion);
    if(!currentVersionStatus) {
      return findFirstBadVersion(selectedVersion+1,max);
    }
    return findFirstBadVersion(min,selectedVersion-1);
  }

  public static boolean isBadVersion(int n) {
    count++;
    return n>=Integer.MAX_VALUE;
  }
}
