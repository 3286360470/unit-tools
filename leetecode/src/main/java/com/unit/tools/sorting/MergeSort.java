package com.unit.tools.sorting;

import java.util.Arrays;

/**
 * 归并排序算法：2路归并排序
 */
public class MergeSort {

  /**
   * 归并排序方法入口
   */
  public static void mergeSort(int [] arr) {
    int length = arr.length;
    int [] tmp = new int[length];
    internalMergeSort(arr, tmp, 0, length - 1);
  }

  /**
   * 递归-分别处理左右两个子数组：先递归，再合并
   */
  public static void internalMergeSort(int [] arr, int [] tmp, int left, int right) {
    int middle = (left + right) / 2;

    // 只剩一个元素该怎么处理? => 不做任何处理，直接返回
    if (left == right) return;

    if (left < right) {
      internalMergeSort(arr, tmp, left, middle);
      internalMergeSort(arr, tmp, middle + 1, right);
      mergeSubArrays(arr, tmp, left, middle, right);
    }
  }

  /**
   * 合并两个递归子数组
   */
  public static void mergeSubArrays(int [] arr, int [] tmp, int left, int middle, int right) {
    int i = left;
    int j = middle + 1;
    int k = 0;
    while (i <= middle && j <= right) {
      tmp[k++] = arr[i] > arr[j] ? arr[j++] : arr[i++];
    }

    while (i <= middle) {
      tmp[k++] = arr[i++];
    }

    while (j <= right) {
      tmp[k++] = arr[j++];
    }

    for (int m = 0; m < k; m++) {
      arr[left + m] = tmp[m];
    }
  }

  public static void main(String[] args) {
    int[] arr = {3, 4, 10, 1, 2, 8, 20, 3, 5, 120, 101, 13};
    mergeSort(arr);
    System.out.println(Arrays.toString(arr));
  }

}
