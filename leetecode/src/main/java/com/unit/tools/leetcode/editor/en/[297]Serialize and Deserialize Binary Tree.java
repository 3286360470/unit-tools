package com.unit.tools.leetcode.editor.en;//Serialization is the process of converting a data structure or object into a s
//equence of bits so that it can be stored in a file or memory buffer, or transmit
//ted across a network connection link to be reconstructed later in the same or an
//other computer environment. 
//
// Design an algorithm to serialize and deserialize a binary tree. There is no r
//estriction on how your serialization/deserialization algorithm should work. You 
//just need to ensure that a binary tree can be serialized to a string and this st
//ring can be deserialized to the original tree structure. 
//
// Clarification: The input/output format is the same as how LeetCode serializes
// a binary tree. You do not necessarily need to follow this format, so please be 
//creative and come up with different approaches yourself. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,null,null,4,5]
//Output: [1,2,3,null,null,4,5]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: [1]
// 
//
// Example 4: 
//
// 
//Input: root = [1,2]
//Output: [1,2]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 104]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics Tree Design 
// 👍 4469 👎 204

import com.unit.tools.leetcode.editor.en.model.TreeNode;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Codec297 {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder res = new StringBuilder();
    serialize(root, res);

    return res.toString();
  }

  private void serialize(TreeNode root, StringBuilder res) {
    if (root != null) {
      res.append(root.val);
      res.append(",");
      serialize(root.left, res);
      serialize(root.right, res);
    } else {
      res.append("null,");
    }
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] s = data.split(",");
    LinkedBlockingDeque<String> queue = new LinkedBlockingDeque<>(Arrays.asList(s));

    return deserialize(queue);
  }

  private TreeNode deserialize(BlockingQueue<String> queue) {
    if (queue.isEmpty()) return null;
    String peek = queue.poll();
    if (peek.equals("null")) return null;
    TreeNode root = new TreeNode(Integer.parseInt(peek));
    root.left = deserialize(queue);
    root.right = deserialize(queue);

    return root;
  }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
