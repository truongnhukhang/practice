package com.practice.leetcode.explorer.medium.sortingAndSearching;

import java.util.*;

public class TopKFrequentElements {
  public static void main(String[] args) {
    int[] nums = {1,1,1,2,2,2,2,2,3,4,5,4,4,5,5,5,5};
    int k = 2;
    TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
    topKFrequentElements.topKFrequent(nums,k).stream().forEach(System.out::println);
  }

  public List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer,Integer> eCountMap = new HashMap<>();
    PriorityQueue<int[]> kQueue = new PriorityQueue<>(k,(g1, g2)->{return g1[1]-g2[1];});
    int len = nums.length;
    for (int i=0;i<len;i++) {
      Integer count = eCountMap.get(nums[i]);
      if(count==null) {
        count = 1;
      } else {
        count = count + 1;
      }
      eCountMap.put(nums[i],count);
    }
    Set<Map.Entry<Integer,Integer>> keyValueSet = eCountMap.entrySet();
    for(Map.Entry<Integer,Integer> keyValue : keyValueSet) {
      int[] e = new int[2];
      e[0] = keyValue.getKey();
      e[1] = keyValue.getValue();
      if(kQueue.size()==k) {
        int[] top = kQueue.peek();
        if(top[1] < e[1]) {
          kQueue.poll();
          kQueue.offer(e);
        }
      } else {
        kQueue.offer(e);
      }

    }
    List<Integer> result = new ArrayList<>();
    while(kQueue.size()>0) {
      result.add(kQueue.poll()[0]);
    }
    return result;
  }
}
