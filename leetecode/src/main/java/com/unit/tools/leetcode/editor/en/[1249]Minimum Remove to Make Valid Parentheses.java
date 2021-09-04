package com.unit.tools.leetcode.editor.en;//Given a string s of '(' , ')' and lowercase English characters.
//
// Your task is to remove the minimum number of parentheses ( '(' or ')', in any
// positions ) so that the resulting parentheses string is valid and return any va
//lid string. 
//
// Formally, a parentheses string is valid if and only if: 
//
// 
// It is the empty string, contains only lowercase characters, or 
// It can be written as AB (A concatenated with B), where A and B are valid stri
//ngs, or 
// It can be written as (A), where A is a valid string. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "lee(t(c)o)de)"
//Output: "lee(t(c)o)de"
//Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
// 
//
// Example 2: 
//
// 
//Input: s = "a)b(c)d"
//Output: "ab(c)d"
// 
//
// Example 3: 
//
// 
//Input: s = "))(("
//Output: ""
//Explanation: An empty string is also valid.
// 
//
// Example 4: 
//
// 
//Input: s = "(a(b(c)d)"
//Output: "a(b(c)d)"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10^5 
// s[i] is one of '(' , ')' and lowercase English letters. 
// Related Topics String Stack 
// 👍 2122 👎 48


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1249 {
    public static String minRemoveToMakeValid(String s) {
        StringBuilder res = new StringBuilder();
        int len = s.length(), n = 0, m = 0;
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; ++i) {
            if (arr[i] == '(') {
                ++n;
            } else if (m < n && arr[i] == ')') {
                ++m;
            } else if (m >= n && arr[i] == ')') {
                stack.push(i);
            }
        }
        int count = n - m;
        for (int i = len - 1; i >= 0; --i) {
            if (!stack.isEmpty() && i == stack.peek()) {
                stack.pop();
                continue;
            }
            if (count > 0 && arr[i] == '(') {
                --count;
                continue;
            }
            res.insert(0, arr[i]);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
