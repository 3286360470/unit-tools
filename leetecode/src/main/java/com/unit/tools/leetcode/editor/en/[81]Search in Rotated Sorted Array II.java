package com.unit.tools.leetcode.editor.en;
//There is an integer array nums sorted in non-decreasing order (not necessarily
// with distinct values). 
//
// Before being passed to your function, nums is rotated at an unknown pivot ind
//ex k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1]
//, ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0
//,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,
//2,4,4]. 
//
// Given the array nums after the rotation and an integer target, return true if
// target is in nums, or false if it is not in nums. 
//
// 
// Example 1: 
// Input: nums = [2,5,6,0,0,1,2], target = 0
//Output: true
// Example 2: 
// Input: nums = [2,5,6,0,0,1,2], target = 3
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5000 
// -104 <= nums[i] <= 104 
// nums is guaranteed to be rotated at some pivot. 
// -104 <= target <= 104 
// 
//
// 
//Follow up: This problem is the same as Search in Rotated Sorted Array, where n
//ums may contain duplicates. Would this affect the runtime complexity? How and wh
//y? Related Topics Array Binary Search 
// 👍 2078 👎 578


//leetcode submit region begin(Prohibit modification and deletion)
class Solution81 {
    public boolean search(int[] nums, int target) {
        return solve2(nums, target);
    }

    public boolean solve2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) return true;
            if (nums[middle] < nums[right]) {
                if (nums[middle] < target && nums[right] >= target) left = middle + 1;
                else right = middle - 1;
            } else if (nums[middle] > nums[right]) {
                if (nums[middle] > target && nums[left] <= target) right = middle - 1;
                else left = middle + 1;
            } else right--;
        }

        return false;
    }

    public boolean solve1(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
