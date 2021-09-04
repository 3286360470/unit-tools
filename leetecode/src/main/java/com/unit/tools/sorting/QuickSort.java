package com.unit.tools.sorting;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

  /**
   * 快速排序方法入口
   */
  public static void quickSort(int [] arr) {
    quickSortInterval(arr, 0, arr.length - 1);
  }

  /**
   * 递归-分别处理两个分区的排序：先分区，再递归
   */
  public static void quickSortInterval(int [] arr, int low, int high) {
    if (low >= high) return;
    int pivotIndex = partitionSort(arr, low, high);
    quickSortInterval(arr, low, pivotIndex - 1);
    quickSortInterval(arr, pivotIndex + 1, high);
  }

  public static int partitionSort(int [] arr, int low, int high) {
    int pivot = arr[low];
    while (low < high) {
      while (low < high && arr[high] >= pivot) --high;
      arr[low] = arr[high];
      while (low < high && arr[low] <= pivot) ++low;
      arr[high] = arr[low];
    }

    arr[low] = pivot;
    return low;
  }

  public static void main(String[] args) {
    int[] arr = {3, 4, 10, 1, 2, 8, 20, 3, 5, 120, 101, 13, 33, 35, 62, 18, 91, 10};
    quickSort(arr);
    System.out.println(Arrays.toString(arr));
  }

}
