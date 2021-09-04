package com.unit.tools.leetcode.editor.en;//Given two integer arrays preorder and inorder where preorder is the preorder t
//raversal of a binary tree and inorder is the inorder traversal of the same tree,
// construct and return the binary tree. 
//
// 
// Example 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder and inorder consist of unique values. 
// Each value of inorder also appears in preorder. 
// preorder is guaranteed to be the preorder traversal of the tree. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// 
// Related Topics Array Tree Depth-first Search 
// 👍 5672 👎 139


import com.unit.tools.leetcode.editor.en.model.TreeNode;
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution105 {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return dfs(preorder, 0, preorder.length - 1,
        inorder, 0, inorder.length - 1);
  }

  private TreeNode dfs(int[] preorder, int preLeft, int preRight,
                       int[] inorder, int inLeft, int inRight) {
    if (preLeft > preRight || inLeft > inRight) return null;
    int val = preorder[preLeft];
    int index = inLeft;
    for (int i = inLeft; i <= inRight; i++) {
      if (inorder[i] == val) {
        index = i;
      }
    }
    int leftSize = index - inLeft;
    TreeNode root = new TreeNode(val);
    root.left = dfs(preorder, preLeft + 1, preLeft + leftSize,
        inorder, inLeft, index - 1);
    root.right = dfs(preorder, preLeft + leftSize + 1, preRight,
        inorder, index + 1, inRight);

    return root;
  }

}
//leetcode submit region end(Prohibit modification and deletion)
