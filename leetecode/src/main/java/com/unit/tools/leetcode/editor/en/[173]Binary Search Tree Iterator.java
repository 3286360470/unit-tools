package com.unit.tools.leetcode.editor.en;//Implement the BSTIterator class that represents an iterator over the in-order
//traversal of a binary search tree (BST): 
//
// 
// BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. Th
//e root of the BST is given as part of the constructor. The pointer should be ini
//tialized to a non-existent number smaller than any element in the BST. 
// boolean hasNext() Returns true if there exists a number in the traversal to t
//he right of the pointer, otherwise returns false. 
// int next() Moves the pointer to the right, then returns the number at the poi
//nter. 
// 
//
// Notice that by initializing the pointer to a non-existent smallest number, th
//e first call to next() will return the smallest element in the BST. 
//
// You may assume that next() calls will always be valid. That is, there will be
// at least a next number in the in-order traversal when next() is called. 
//
// 
// Example 1: 
//
// 
//Input
//["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext
//", "next", "hasNext"]
//[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
//Output
//[null, 3, 7, true, 9, true, 15, true, 20, false]
//
//Explanation
//BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
//bSTIterator.next();    // return 3
//bSTIterator.next();    // return 7
//bSTIterator.hasNext(); // return True
//bSTIterator.next();    // return 9
//bSTIterator.hasNext(); // return True
//bSTIterator.next();    // return 15
//bSTIterator.hasNext(); // return True
//bSTIterator.next();    // return 20
//bSTIterator.hasNext(); // return False
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 105]. 
// 0 <= Node.val <= 106 
// At most 105 calls will be made to hasNext, and next. 
// 
//
// 
// Follow up: 
//
// 
// Could you implement next() and hasNext() to run in average O(1) time and use 
//O(h) memory, where h is the height of the tree? 
// 
// Related Topics Stack Tree Design 
// 👍 3778 👎 329

import com.unit.tools.leetcode.editor.en.model.TreeNode;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

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
class BSTIterator173 {

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator173(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode peek = stack.peek();
        stack.pop();
        int res = peek.val;
        if (peek.right != null) {
            TreeNode root = peek.right;
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        return res;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)
