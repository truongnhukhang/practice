package com.practice.arrayAndString;

import java.util.Collections;
import java.util.PriorityQueue;

public class LC_FindLastStone {
  public static void main(String[] args) {
    int[] testdata = new int[]{1,3};
    System.out.println(lastStoneWeight(testdata));
  }
  public static int lastStoneWeight(int[] stones) {
    if(stones.length==0) {
      return 0;
    }
    if(stones.length==1) {
      return stones[0];
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for(int i = 0;i<stones.length;i++) {
      pq.offer(stones[i]);
    }
    while(pq.size()>1) {
      Integer firstRock = pq.poll();
      Integer secondRock = pq.poll();
      if(!firstRock.equals(secondRock)) {
        pq.offer(firstRock-secondRock);
      }
    }
    if(pq.size()==0) {
      return 0;
    }
    return pq.poll();

  }
}
