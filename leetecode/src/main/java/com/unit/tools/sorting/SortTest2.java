package com.unit.tools.sorting;

import java.util.Arrays;

public class SortTest2 {

  // 合并排序
  public static void mergeSort(int [] arr) {
    int [] temp = new int [arr.length];
    mergeSortInternal(arr, temp, 0, arr.length - 1);
  }

  public static void mergeSortInternal(int [] arr, int [] temp, int left, int right) {
    int middle = (left + right) / 2;
    if (left == right) {
      return;
    }
    if (left < right) {
      mergeSortInternal(arr, temp, left, middle);
      mergeSortInternal(arr, temp, middle + 1, right);
      mergeSubArrays(arr, temp, left, middle, right);
    }
  }

  public static void mergeSubArrays(int [] arr, int [] temp, int left, int middle, int right) {
    int i = left, j = middle + 1, k = 0;
    while (i <= middle && j <= right) {
      temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
    }

    while (i <= middle) {
      temp[k++] = arr[i++];
    }
    while (j <= right) {
      temp[k++] = arr[j++];
    }

    for (int m = 0; m < k; m++) {
      arr[left + m] = temp[m];
    }

  }

  // 快速排序
  public static void quickSort(int [] arr) {
    quickSortInternal(arr, 0, arr.length - 1);
  }

  public static void quickSortInternal(int [] arr, int left, int right) {
    if (left == right) {
      return;
    }
    int pivotIndex = getPivotIndex(arr, left, right);
    if (left < right) {
      quickSortInternal(arr, left, pivotIndex - 1);
      quickSortInternal(arr, pivotIndex + 1, right);

    }
  }

  public static int getPivotIndex(int [] arr, int left, int right) {
    int pivot = arr[left];
    while (left < right) {
      while (left < right && pivot <= arr[right]) right--;
      arr[left] = arr[right];
      while (left < right && pivot >= arr[left]) left++;
      arr[right] = arr[left];
    }

    arr[left] = pivot;
    return left;
  }

  // 堆排序
  public static void heapSort(int [] arr) {
    int last = arr.length - 1;
    for (int i = getParentIndex(last); i >= 0; i--) {
      adjustHeap(arr, last, i);
    }

    while (last >= 0) {
      swap(last--, 0, arr);
      adjustHeap(arr, last, 0);
    }

  }

  public static void adjustHeap(int [] arr, int len, int cur) {
    int leftChildIndex = getLeftChildIndex(cur);
    while (leftChildIndex <= len) {
      int temp = leftChildIndex;
      int right = leftChildIndex + 1;
      if (right <= len) {
        temp = arr[leftChildIndex] < arr[right] ? right : leftChildIndex;
      }

      if (arr[cur] < arr[temp]) {
        swap(cur, temp, arr);
        cur = temp;
        leftChildIndex = getLeftChildIndex(cur);
      } else {
        break;
      }
    }
  }

  public static void swap(int i, int j, int [] arr) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static int getParentIndex(int childIndex) {
    return (childIndex - 1) / 2;
  }

  public static int getLeftChildIndex(int parentIndex) {
    return 2 * parentIndex + 1;
  }

  public static void main(String[] args) {
    // 合并排序
    int [] arr2 = {3, 4, 10, 1, 2, 8, 20, 3, 5, 120, 101, 13, 33, 35, 62, 18, 91, 10};
    mergeSort(arr2);
    System.out.println(Arrays.toString(arr2));

    // 快速排序
    int[] arr = {3, 4, 10, 1, 2, 8, 20, 3, 5, 120, 101, 13, 33, 35, 62, 18, 91, 10};
    quickSort(arr);
    System.out.println(Arrays.toString(arr));

    // 堆排序
    int [] arr3 = {3, 4, 10, 1, 2, 8, 20, 3, 5, 120, 101, 13, 33, 35, 62, 18, 91, 10};
    heapSort(arr3);
    System.out.println(Arrays.toString(arr3));

  }

}
