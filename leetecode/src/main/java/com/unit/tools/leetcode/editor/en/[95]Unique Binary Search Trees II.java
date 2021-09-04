package com.unit.tools.leetcode.editor.en;//Given an integer n, return all the structurally unique BST's (binary search tr
//ees), which has exactly n nodes of unique values from 1 to n. Return the answer 
//in any order. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]
//]
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics Dynamic Programming Tree 
// 👍 3113 👎 213


//leetcode submit region begin(Prohibit modification and deletion)

import com.unit.tools.leetcode.editor.en.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();

        return dfs(1, n);
    }

    public List<TreeNode> dfs(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = dfs(start, i - 1), right = dfs(i + 1, end);
            for (TreeNode a : left) {
                for (TreeNode b : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = a;
                    node.right = b;
                    res.add(node);
                }
            }
        }

        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
