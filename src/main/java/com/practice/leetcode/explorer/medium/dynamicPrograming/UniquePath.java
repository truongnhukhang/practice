package com.practice.leetcode.explorer.medium.dynamicPrograming;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by truongnhukhang on 11/22/19.
 */
public class UniquePath {

  Map<String,Integer> pathCache = new HashMap<>();

  public static void main(String[] args) {
    UniquePath uniquePath = new UniquePath();
    System.out.println(uniquePath.uniquePaths(99,99));
  }
  public int uniquePaths(int m, int n) {
    String key = m+"|"+n;
    if(pathCache.get(key)!=null) {
      System.out.println("use cache");
      return pathCache.get(key);
    }
    if(m<1 || n<1) {
      return 0;
    }
    if(m==1 && n==1) {
      return 1;
    }
    int result = 0;
    result = uniquePaths(m-1,n) + uniquePaths(m,n-1);
    pathCache.put(key,result);
    return result;
  }
}
