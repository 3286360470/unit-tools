package com.unit.tools.leetcode.editor.en;//Given a string containing just the characters '(' and ')', find the length of
//the longest valid (well-formed) parentheses substring. 
//
// 
// Example 1: 
//
// 
//Input: s = "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()".
// 
//
// Example 2: 
//
// 
//Input: s = ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()".
// 
//
// Example 3: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] is '(', or ')'. 
// 
// Related Topics String Dynamic Programming 
// 👍 5196 👎 189


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution32 {
    public int longestValidParentheses(String s) {
        int res = 0, start = 0, len = s.length();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) == '(') stack.push(i);
            else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) start = i + 1;
                else {
                    stack.pop();
                    res = stack.isEmpty() ? Math.max(res, i - start + 1) : Math.max(res, i - stack.peek());
                }
            }
        }

        return res;
    }

//    public static void main(String[] args) {
//        System.out.println(longestValidParentheses(")(()())"));
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
