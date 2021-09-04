package com.unit.tools.leetcode.editor.en;
//Given two integers n and k, return all possible combinations of k numbers out
//of the range [1, n]. 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: n = 4, k = 2
//Output:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// 
//
// Example 2: 
//
// 
//Input: n = 1, k = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics Backtracking 
// 👍 2172 👎 81


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
//        combineInternal(1, n, k, 0, new ArrayList<>(), result);
        helper(n, k, 1, new Stack<>(), result);

        return result;
    }

    public void helper(int n, int k, int level, Stack<Integer> tmp, List<List<Integer>> result) {
        if (tmp.size() == k) {
            result.add(new ArrayList<>(tmp));
        }
        for (int i = level; i <= n; i++) {
            tmp.push(i);
            helper(n, k, i + 1, tmp, result);
            tmp.pop();
        }

    }

    public void combineInternal(int begin, int n, int k, int count, List<Integer> tmp, List<List<Integer>> result) {
        if (count == k) {
            result.add(new ArrayList<>(tmp));
            return;
        } else if (n - begin + count < k) {
            return;
        } else {
            for (int i = begin; i < k; i++) {
                tmp.add(begin);
                combineInternal(begin + 1, n, k, count + 1, tmp, result);
            }
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
