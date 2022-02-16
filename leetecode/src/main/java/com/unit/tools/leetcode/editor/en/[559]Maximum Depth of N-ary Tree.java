package com.unit.tools.leetcode.editor.en;
//Given a n-ary tree, find its maximum depth.
//
// The maximum depth is the number of nodes along the longest path from the root
// node down to the farthest leaf node. 
//
// Nary-Tree input serialization is represented in their level order traversal, 
//each group of children is separated by the null value (See examples). 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,null,3,2,4,null,5,6]
//Output: 3
// 
//
// Example 2: 
//
// 
//
// 
//Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null
//,12,null,13,null,null,14]
//Output: 5
// 
//
// 
// Constraints: 
//
// 
// The total number of nodes is in the range [0, 104]. 
// The depth of the n-ary tree is less than or equal to 1000. 
// 
// Related Topics Tree Depth-First Search Breadth-First Search 
// 👍 1854 👎 68


import com.google.common.collect.Lists;
import com.unit.tools.leetcode.editor.en.model.Node;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private Integer res = 0;

    public int maxDepth(Node root) {
        // 后序遍历
//        if (root == null) return 0;
//        int res = 1;
//        for (Node node : root.children) {
//            res = Math.max(res, maxDepth(node) + 1);
//        }

        dfs(root, 1);
        // 层序遍历
//        levelOrder(root, res);

        return res;
    }

    // 后序遍历
    public void dfs(Node root, int cur) {
        if (root == null) {
            return;
        }
        if (root.children.isEmpty()) {
            res = Math.max(cur, res);
        }
        for (Node node : root.children) {
            dfs(node, cur + 1);
        }
    }

    // 层序遍历
    public int levelOrder(Node root, int res) {
        if (root == null) {
            return res;
        }
        BlockingQueue<Node> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ++res;
            for (int i = queue.size(); i > 0; --i) {
                Node head = queue.poll();
                queue.addAll(head.children);
            }
        }

        return res;
    }

//    public static void main(String[] args) {
//        Node node = new Node(1, Lists.newArrayList());
//        System.out.println(maxDepth(node));
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
