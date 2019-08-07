package com.practice.leetcode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by truongnhukhang on 8/7/19.
 */
public class FruitsIntoBaskets {
  public static void main(String[] args) {
    int[] tree = {3,3,3,1,2,1,1,2,3,3,4,4,3,3,5};
    System.out.println(totalFruit(tree));
    tree = new int[]{6};
    System.out.println(totalFruit(tree));
    tree = new int[]{1,2,3,2,2};
    System.out.println(totalFruit(tree));
  }

  public static int totalFruit(int[] tree) {
    List<Integer[]> treeList = new ArrayList<>();
    Integer[] treeNumberFruitCount = {tree[0],1};
    treeList.add(treeNumberFruitCount);
    for (int i = 1; i < tree.length; i++) {
      if(treeNumberFruitCount[0]==tree[i]) {
        treeNumberFruitCount[1]++;
      } else {
        treeNumberFruitCount = new Integer[]{tree[i],1};
        treeList.add(treeNumberFruitCount);
      }
    }
    if(treeList.size()==1) {
      return treeList.get(0)[1];
    }
    int basketType1 = treeList.get(0)[0];
    int basketType2 = treeList.get(1)[0];
    int collectedFruit = treeList.get(0)[1]+ treeList.get(1)[1];
    int maxFruitCollected = collectedFruit;
    for (int i = 2 ; i < treeList.size() ; i++) {
      Integer[] tempPair = treeList.get(i);
      if(!tempPair[0].equals(basketType1) && !tempPair[0].equals(basketType2)) {
        basketType1 = treeList.get(i-1)[0];
        basketType2 = tempPair[0];
        collectedFruit = treeList.get(i-1)[1]+tempPair[1];
      } else {
        collectedFruit = collectedFruit+tempPair[1];
      }
      if(maxFruitCollected < collectedFruit) {
        maxFruitCollected = collectedFruit;
      }
    }
    return maxFruitCollected;
  }
}
