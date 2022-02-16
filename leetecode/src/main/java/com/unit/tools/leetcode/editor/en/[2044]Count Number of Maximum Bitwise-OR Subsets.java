package com.unit.tools.leetcode.editor.en;
//Given an integer array nums, find the maximum possible bitwise OR of a subset
//of nums and return the number of different non-empty subsets with the maximum bi
//twise OR. 
//
// An array a is a subset of an array b if a can be obtained from b by deleting 
//some (possibly zero) elements of b. Two subsets are considered different if the 
//indices of the elements chosen are different. 
//
// The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length - 
//1] (0-indexed). 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,1]
//Output: 2
//Explanation: The maximum possible bitwise OR of a subset is 3. There are 2 sub
//sets with a bitwise OR of 3:
//- [3]
//- [3,1]
// 
//
// Example 2: 
//
// 
//Input: nums = [2,2,2]
//Output: 7
//Explanation: All non-empty subsets of [2,2,2] have a bitwise OR of 2. There ar
//e 23 - 1 = 7 total subsets.
// 
//
// Example 3: 
//
// 
//Input: nums = [3,2,1,5]
//Output: 6
//Explanation: The maximum possible bitwise OR of a subset is 7. There are 6 sub
//sets with a bitwise OR of 7:
//- [3,5]
//- [3,1,5]
//- [3,2,5]
//- [3,2,1,5]
//- [2,5]
//- [2,1,5] 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 16 
// 1 <= nums[i] <= 105 
// 
// Related Topics Array Backtracking Bit Manipulation 
// 👍 124 👎 12


//leetcode submit region begin(Prohibit modification and deletion)
class Solution2044 {
    public int countMaxOrSubsets(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(1 & 3);
        System.out.println(1 | 3);
        System.out.println(1 ^ 3);
        System.out.println(3 | 5);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
