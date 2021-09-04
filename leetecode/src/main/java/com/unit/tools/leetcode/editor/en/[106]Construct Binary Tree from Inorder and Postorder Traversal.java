package com.unit.tools.leetcode.editor.en;//Given two integer arrays inorder and postorder where inorder is the inorder tr
//aversal of a binary tree and postorder is the postorder traversal of the same tr
//ee, construct and return the binary tree. 
//
// 
// Example 1: 
//
// 
//Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: inorder = [-1], postorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder and postorder consist of unique values. 
// Each value of postorder also appears in inorder. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// postorder is guaranteed to be the postorder traversal of the tree. 
// 
// Related Topics Array Tree Depth-first Search 
// 👍 2808 👎 53

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
class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(inorder, 0, inorder.length - 1,
                    postorder, 0, postorder.length - 1);
    }

    private TreeNode dfs(int[] inorder, int inLeft, int inRight,
                         int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) return null;
        int index = inLeft;
        int val = postorder[postRight];
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == val) {
                index = i;
            }
        }
        int leftSize = index - inLeft;
        TreeNode root = new TreeNode(val);
        root.left = dfs(inorder, inLeft, index - 1,
                        postorder, postLeft, postLeft + leftSize - 1);
        root.right = dfs(inorder, index + 1, inRight,
                        postorder, postLeft + leftSize, postRight - 1);

        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
