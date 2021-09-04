package com.unit.tools.leetcode.editor.en;
//Given the head of a sorted linked list, delete all nodes that have duplicate n
//umbers, leaving only distinct numbers from the original list. Return the linked 
//list sorted as well. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,3,4,4,5]
//Output: [1,2,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1,1,1,2,3]
//Output: [2,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 300]. 
// -100 <= Node.val <= 100 
// The list is guaranteed to be sorted in ascending order. 
// 
// Related Topics Linked List 
// 👍 2859 👎 125

import com.unit.tools.leetcode.editor.en.model.ListNode;
//leetcode submit region begin(Prohibit modification and deletion)



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        return solve2(head);
    }

    public ListNode solve2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1), pre = dummy;
        dummy.next = head;
        while (pre.next != null) {
            ListNode cur = pre.next;
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }

            if (cur != pre.next) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }

    public ListNode wrongSolve1(ListNode head) {
        ListNode cur = head, next = cur.next, pre = head;
        int temp = cur.val;
        while (cur.next != null) {
            if (temp == next.val || next.val == cur.val) {
                cur = cur.next;
                next = cur.next;
            } else if (temp != next.val) {
                pre.next = next;
                cur = next;
                next = cur.next;
                pre = cur;
                temp = next.val;
            }

        }

        return head;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
