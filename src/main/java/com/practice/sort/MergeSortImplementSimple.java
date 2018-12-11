package com.practice.sort;

public class MergeSortImplementSimple {
  public int[] mergeSort(int[] list) {
    int middle = list.length/2;
    int[] list1 = new int[middle];
    int[] list2 = new int[list.length-middle];
    for (int i = 0; i < middle; i++) {
      list1[i] = list[i];
    }
    for (int i = middle;i < list.length;i++) {
      list2[i-middle] = list[i];
    }
    return mergeSort(list1,list2);
  }

  public int[] mergeSort(int[] list1, int[] list2) {
    if(list1.length>1) {
      list1 = mergeSort(list1);
    }
    if(list2.length>1) {
      list2 = mergeSort(list2);
    }
    int list[] = new int[list1.length+list2.length];
    if(list1.length>list2.length) {
      mergeList(list1, list2, list);
    } else {
      mergeList(list2, list1, list);
    }
    return list;
  }

  private void mergeList(int[] list1, int[] list2, int[] list) {
    int index = 0;
    for (int i = 0; i < list1.length; i++) {
      if(i>=list2.length) {
        list[index] = list1[i];
      } else {
        if(list1[i] < list2[i]) {
          list[index] = list1[i];
          list[index+1] = list2[i];
          index++;
        } else {
          list[index] = list2[i];
          list[index+1] = list1[i];
          index++;
        }
      }

      index++;
    }
  }
}
