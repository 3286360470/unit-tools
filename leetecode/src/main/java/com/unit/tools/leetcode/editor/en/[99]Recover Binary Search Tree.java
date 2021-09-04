package com.unit.tools.leetcode.editor.en;//You are given the root of a binary search tree (BST), where exactly two nodes
//of the tree were swapped by mistake. Recover the tree without changing its struc
//ture. 
//
// Follow up: A solution using O(n) space is pretty straight forward. Could you 
//devise a constant space solution? 
//
// 
// Example 1: 
//
// 
//Input: root = [1,3,null,null,2]
//Output: [3,1,null,null,2]
//Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 mak
//es the BST valid.
// 
//
// Example 2: 
//
// 
//Input: root = [3,1,4,null,null,2]
//Output: [2,1,4,null,null,3]
//Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 a
//nd 3 makes the BST valid.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 1000]. 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics Tree Depth-first Search 
// 👍 2604 👎 95

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
class Solution99 {
    private TreeNode pre = null, first = null, second = null;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (pre == null) pre = root;
        else {
            if (pre.val > root.val) {
                if (first == null) first = pre;
                second = root;
            }
            pre = root;
        }
        inorder(root.right);
    }

    private boolean dfsR(TreeNode parent, TreeNode root) {
        if (root == null) return true;
        if (parent.val < root.val) {
            return dfsR(parent, root.left) && dfsR(parent, root.right);
        } else {
            int temp = parent.val;
            parent.val = root.val;
            root.val = temp;

            return false;
        }
    }

    private boolean dfsL(TreeNode parent, TreeNode root) {
        if (root == null) return true;
        if (parent.val > root.val) {
            return dfsL(parent, root.left) && dfsL(parent, root.right);
        } else {
            int temp = parent.val;
            parent.val = root.val;
            root.val = temp;

            return false;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
