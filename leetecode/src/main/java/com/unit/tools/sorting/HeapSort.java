package com.unit.tools.sorting;

import java.util.Arrays;

/**
 * 堆：一种特殊的完全二叉树(完全二叉树：除了最底层之外，每一层都是满的，这使得堆可以利用数组来表示)
 * 对于给定的某个结点的下标i，可以很容易计算出这个结点的父结点、孩子结点的下标：
 *    1. Parent(i) = floor(i/2)  // i的父结点下标
 *    2. Left(i) = 2i            // i的左子结点下标
 *    3. Right(i) = 2i + 1       // i的右子结点下标
 * 由于数组都是Zero-Based(从0开始)的，所以上述的i要做相应的调整:
 *    1. Parent(i) = floor((i - 1)/2)  // i的父结点下标
 *    2. Left(i) = 2i + 1            // i的左子结点下标
 *    3. Right(i) = 2(i + 1)       // i的右子结点下标
 */
public class HeapSort {

  public static int getParentIndex(int childIndex) {
    return (childIndex - 1) / 2;
  }

  public static int getLeftChildIndex(int parentIndex) {
    return 2 * parentIndex + 1;
  }

  public static void swap(int i, int j, int [] arr) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  /**
   * 调整堆
   */
  public static void adjustHeap(int i, int len, int [] arr) {
    int left, right, j;
    left = getLeftChildIndex(i);
    while (left <= len) {
      right = left + 1;
      j = left;
      if (j < len && arr[left] < arr[right]) {
        j++;
      }

      if (arr[i] < arr[j]) {
        swap(i, j, arr);
        i = j;
        left = getLeftChildIndex(i);
      } else {
        break; // 停止筛选
      }
    }
    printAsTree(arr.length, arr);

  }

  public static void sort(int [] arr) {
    int last = arr.length - 1;
    // 初始化大顶堆
    for (int i = getParentIndex(last); i >= 0; i--) {
      adjustHeap(i, last, arr);
    }
    // 堆调整
    while (last >= 0) {
      swap(0, last--, arr);
      adjustHeap(0, last, arr);
    }
  }

  public static void main(String[] args) {
    int[] arr = {3, 4, 10, 1, 2, 8, 20, 3, 5, 120, 101, 13, 33, 35, 62, 18, 91, 10};
    printAsTree(arr.length, arr);
    System.out.println("=========================");
    System.out.println(Arrays.toString(arr));
    System.out.println("=========================");
    sort(arr);
    printAsTree(arr.length, arr);
    System.out.println(Arrays.toString(arr));

  }

  public static void printSpace(int n) {//打印n个空格(在这里用‘\t’来代替)
    for (int i = 0; i < n; i++) {
      System.out.printf("%3s", "");
    }
  }

  public static void printAsTree(int size, int [] arr) {
    int lineNum = 1;//首先遍历第一行
    int lines = (int) (Math.log(size) / Math.log(2)) + 1;//lines是堆的层数
    int spaceNum = (int) (Math.pow(2, lines) - 1);
    for (int i = 1; i <= size; ) { //因为在[1...size]左闭右闭区间存数据，data[0]不存数据

      //每层都是打印这个区间[2^(层数-1) ... (2^层数)-1]。如果堆里的数不够(2^层数)-1个，那就打印到size。所以取min((2^层数)-1,size).
      for (int j = (int) Math.pow(2, lineNum - 1); j <= Math.min(size, (int) Math.pow(2, lineNum) - 1); j++) {
        printSpace(spaceNum / 4); //打印spaceNum个空格
        System.out.printf("%3s", arr[j - 1]);//打印数据
        System.out.printf("%3s", "");//图片中绿色方框
        printSpace(spaceNum / 4);//打印spaceNum个空格
        i++;//每打印一个元素就 + 1
      }
      lineNum++;
      spaceNum = spaceNum / 2;
      System.out.println();
    }
    System.out.println("===================================");
  }

}
