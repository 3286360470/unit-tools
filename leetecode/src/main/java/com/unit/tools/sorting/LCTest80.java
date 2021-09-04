package com.unit.tools.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LCTest80 {

  public static int removeDuplicates(int[] nums) {
    int step = 0, len = nums.length - 1, count = 0;
    Map<Integer, Integer> index2Step = new HashMap<>();
    for (int i = 0; i <= len; i++) {
      if (i < len && nums[i] == nums[i + 1]) {
        count++;
        if (count < 2) {
          index2Step.put(i, step);
        } else {
          index2Step.put(i, step++);
        }
      } else if (i < len && nums[i] != nums[i + 1]) {
        index2Step.put(i, step);
        count = 0;
      } else if (i == len) {
        index2Step.put(i, step);
      }

    }
    for (int i = 0; i <= len; i++) {
      int temp = index2Step.get(i);
      nums[i - temp] = nums[i];
    }

    return len - step + 1;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{1, 1, 1, 2, 2, 3};
    removeDuplicates(arr);
    System.out.println(Arrays.toString(arr));

    int[] arr2 = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
    removeDuplicates(arr2);
    System.out.println(Arrays.toString(arr2));
  }

}
