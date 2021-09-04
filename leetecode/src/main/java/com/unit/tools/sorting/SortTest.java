package com.unit.tools.sorting;

import java.util.Arrays;

public class SortTest {

  // 合并排序
  public static void mergeSort(int [] arr) {
    int [] temp = new int [arr.length];
    mergeSortInternal(arr, temp, 0, arr.length - 1);
  }

  public static void mergeSortInternal(int [] arr, int [] temp, int left, int right) {
    if (left == right) {
      return;
    }
    int middle = (left + right) / 2;
    if (left < right) {
      mergeSortInternal(arr, temp, left, middle);
      mergeSortInternal(arr, temp, middle + 1, right);
      mergeSubArrays(arr, temp, left, middle, right);
    }

  }

  public static void mergeSubArrays(int [] arr, int [] temp, int left, int middle, int right) {
    int i = left;
    int j = middle + 1;
    int k = 0;
    while (i <= middle && j <= right) {
      temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
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
    if (left >= right) return;
    int pivotIndex = getPivotIndex(arr, left, right);
    quickSortInternal(arr, left, pivotIndex - 1);
    quickSortInternal(arr, pivotIndex + 1, right);
  }

  public static int getPivotIndex(int [] arr, int left, int right) {
    int pivot = arr[left];
    while (left < right) {
      while (left < right && pivot <= arr[right]) --right;
      arr[left] = arr[right];
      while (left < right && pivot >= arr[left]) ++left;
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
      swap(arr, last--, 0);
      adjustHeap(arr, last, 0);
    }

  }

  public static void adjustHeap(int [] arr, int last, int i) {
    int leftChildIndex = getLeftChildIndex(i);
    while (leftChildIndex <= last) {
      int temp = leftChildIndex;
      if (leftChildIndex < last) {
        temp = arr[leftChildIndex] < arr[leftChildIndex + 1] ? leftChildIndex + 1 : leftChildIndex;
      }

      if (arr[i] < arr[temp]) {
        swap(arr, i, temp);
        i = temp;
        leftChildIndex = getLeftChildIndex(i);
      } else {
        break;
      }
    }
  }

  public static void swap(int [] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static int getParentIndex(int i) {
    return (i - 1) / 2;
  }

  public static int getLeftChildIndex(int i) {
    return 2 * i + 1;
  }

  public static void main(String[] args) {
    // 快速排序
    int[] arr = {3, 4, 10, 1, 2, 8, 20, 3, 5, 120, 101, 13, 33, 35, 62, 18, 91, 10};
    quickSort(arr);
    System.out.println(Arrays.toString(arr));

    // 合并排序
    int [] arr2 = {3, 4, 10, 1, 2, 8, 20, 3, 5, 120, 101, 13, 33, 35, 62, 18, 91, 10};
    mergeSort(arr2);
    System.out.println(Arrays.toString(arr2));

    // 堆排序
    int [] arr3 = {3, 4, 10, 1, 2, 8, 20, 3, 5, 120, 101, 13, 33, 35, 62, 18, 91, 10};
    heapSort(arr3);
    System.out.println(Arrays.toString(arr3));
  }

}
