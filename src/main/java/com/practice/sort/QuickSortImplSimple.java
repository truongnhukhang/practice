package com.practice.sort;

/**
 * Created by truongnhukhang on 3/2/20.
 */
public class QuickSortImplSimple {


  public static void main(String[] args) {
    int[] sortList = {0,4,5,6,1,2,7,8,3};
    QuickSortImplSimple quickSortImplSimple  = new QuickSortImplSimple();
    quickSortImplSimple.quickSort(sortList,0,sortList.length-1);
    for (int i = 0; i < sortList.length; i++) {
      System.out.println(sortList[i]);
    }
  }

  public void quickSort(int[] arr,int start,int end) {
    if(start<end) {
      int pivot = partition(arr,start,end);
      quickSort(arr,start,pivot-1);
      quickSort(arr,pivot+1,end);
    }

  }

  private int partition(int[] arr, int start, int end) {
    int i=start,j=start;
    int pivot = arr[end];
    for (; i < end; i++) {
      if(arr[i] < pivot) {
        swap(arr,i,j);
        j++;
      }
    }
    swap(arr,j,end);
    return j;
  }

  private void swap(int[] arr,int i, int j) {
    if(i!=j) {
      int temp = 0;
      temp=arr[j];
      arr[j] = arr[i];
      arr[i]=temp;
    }
  }
}
