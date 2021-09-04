package com.unit.tools.leetcode.editor.en;//You are given the root of a binary tree with n nodes where each node in the tr
//ee has node.val coins. There are n coins in total throughout the whole tree. 
//
// In one move, we may choose two adjacent nodes and move one coin from one node
// to another. A move may be from parent to child, or from child to parent. 
//
// Return the minimum number of moves required to make every node have exactly o
//ne coin. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,0,0]
//Output: 2
//Explanation: From the root of the tree, we move one coin to its left child, an
//d one coin to its right child.
// 
//
// Example 2: 
//
// 
//Input: root = [0,3,0]
//Output: 3
//Explanation: From the left child of the root, we move two coins to the root [t
//aking two moves]. Then, we move one coin from the root of the tree to the right 
//child.
// 
//
// Example 3: 
//
// 
//Input: root = [1,0,2]
//Output: 2
// 
//
// Example 4: 
//
// 
//Input: root = [1,0,0,null,3]
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is n. 
// 1 <= n <= 100 
// 0 <= Node.val <= n 
// The sum of all Node.val is n. 
// 
// Related Topics Tree Depth-first Search 
// 👍 2614 👎 86

import com.unit.tools.leetcode.editor.en.model.TreeNode;
//leetcode submit region begin(Prohibit modification and deletion)


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
class Solution979 {

    private Integer res = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);

        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        int cur = root.val + left + right - 1;
        res += Math.abs(left) + Math.abs(right);

        return cur;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
