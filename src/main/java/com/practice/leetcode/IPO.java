package com.practice.leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class IPO {
  public static void main(String[] args) {
    int k = 2; int W =0;
    int[] Profits = {1,2,3};
    int[] Capital = {0,1,1};
    System.out.println(new IPO().findMaximizedCapital(k,W,Profits,Capital));
  }

  public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
    PriorityQueue<int[]> maxProfitQueue = new PriorityQueue<>((o1,o2)->o2[0]-o1[0]);
    for (int i = 0; i < Profits.length; i++) {
      maxProfitQueue.add(new int[]{Profits[i],Capital[i]});
    }
    LinkedList<int[]> mem = new LinkedList<>();
    while (k>0 && !maxProfitQueue.isEmpty()) {
      int[] maxProfit = maxProfitQueue.poll();
      if(maxProfit[1] <= W) {
        W = W + maxProfit[0];
        k--;
        while (!mem.isEmpty()) {
          maxProfitQueue.add(mem.pollFirst());
        }
      } else {
        mem.addFirst(maxProfit);
      }
    }

    return W;

  }
}
