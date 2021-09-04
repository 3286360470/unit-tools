package com.unit.tools.leetcode.editor.en;
//Given a sorted array nums, remove the duplicates in-place such that duplicates
// appeared at most twice and return the new length. 
//
// Do not allocate extra space for another array; you must do this by modifying 
//the input array in-place with O(1) extra memory. 
//
// Clarification: 
//
// Confused why the returned value is an integer, but your answer is an array? 
//
// Note that the input array is passed in by reference, which means a modificati
//on to the input array will be known to the caller. 
//
// Internally you can think of this: 
//
// 
//// nums is passed in by reference. (i.e., without making a copy)
//int len = removeDuplicates(nums);
//
//// any modification to nums in your function would be known by the caller.
//// using the length returned by your function, it prints the first len element
//s.
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
// 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,1,2,2,3]
//Output: 5, nums = [1,1,2,2,3]
//Explanation: Your function should return length = 5, with the first five eleme
//nts of nums being 1, 1, 2, 2 and 3 respectively. It doesn't matter what you leav
//e beyond the returned length.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,0,1,1,1,1,2,3,3]
//Output: 7, nums = [0,0,1,1,2,3,3]
//Explanation: Your function should return length = 7, with the first seven elem
//ents of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively. It doesn't m
//atter what values are set beyond the returned length.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 104 
// -104 <= nums[i] <= 104 
// nums is sorted in ascending order. 
// 
// Related Topics Array Two Pointers 
// 👍 1821 👎 786


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution80 {
    public int removeDuplicates(int[] nums) {
        return solve2(nums);
    }

    public int solve2(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i++] = num;
            }
        }
        return i;
    }

    public int solve1(int[] nums) {
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
}
//leetcode submit region end(Prohibit modification and deletion)
