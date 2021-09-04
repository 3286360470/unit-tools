package com.unit.tools.leetcode.editor.en;//Given a string s which represents an expression, evaluate this expression and
//return its value. 
//
// The integer division should truncate toward zero. 
//
// Note: You are not allowed to use any built-in function which evaluates string
//s as mathematical expressions, such as eval(). 
//
// 
// Example 1: 
// Input: s = "3+2*2"
//Output: 7
// Example 2: 
// Input: s = " 3/2 "
//Output: 1
// Example 3: 
// Input: s = " 3+5 / 2 "
//Output: 5
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 105 
// s consists of integers and operators ('+', '-', '*', '/') separated by some n
//umber of spaces. 
// s represents a valid expression. 
// All the integers in the expression are non-negative integers in the range [0,
// 231 - 1]. 
// The answer is guaranteed to fit in a 32-bit integer. 
// 
// Related Topics String Stack 
// 👍 2411 👎 371


//leetcode submit region begin(Prohibit modification and deletion)
class Solution227 {
    public static int calculate(String s) {
        int res = 0, curRes = 0, num = 0, len = s.length();
        char op = '+';
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; ++i) {
            char c = chars[i];
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == len - 1) {
                switch (op) {
                    case '+':
                        curRes += num;
                        break;
                    case '-':
                        curRes -= num;
                        break;
                    case '*':
                        curRes *= num;
                        break;
                    case '/':
                        curRes /= num;
                        break;
                }
                if (c == '+' || c == '-' || i == len - 1) {
                    res += curRes;
                    curRes = 0;
                }
                op = c;
                num = 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculate("42"));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
