package com.unit.tools.leetcode.editor.en;//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order, and each of their nodes contains a si
//ngle digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have leading
// zeros. 
// 
// Related Topics Linked List Math Recursion 
// 👍 11019 👎 2652


//leetcode submit region begin(Prohibit modification and deletion)

import com.unit.tools.leetcode.editor.en.model.ListNode;

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
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int d1 = l1 == null ? 0 : l1.val;
            int d2 = l2 == null ? 0 : l2.val;
            int sum = d1 + d2 + carry;
            carry = sum >= 10 ? 1 : 0;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry == 1) cur.next = new ListNode(1);
        return head.next;


//        ListNode cur = new ListNode();
//        ListNode head = new ListNode();
//        head.next = cur;
//
//        int next = 0;
//        while (l1 != null && l2 !=null) {
//            int tmpVal = l1.val + l2.val + next;
//            l1 = l1.next;
//            l2 = l2.next;
//            next = 0;
//            if (tmpVal < 10) {
//                cur.val = tmpVal;
//            } else {
//                cur.val = tmpVal % 10;
//                next = 1;
//            }
//            cur.next = new ListNode();
//            cur = cur.next;
//        }
//
//        while (l1 != null) {
//            cur.val = l1.val;
//            l1 = l1.next;
//            cur.next = new ListNode();
//            cur = cur.next;
//        }
//
//        while (l2 != null) {
//            cur.val = l2.val;
//            l2 = l2.next;
//            cur.next = new ListNode();
//            cur = cur.next;
//        }
//
//        cur = null;
//
//        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
