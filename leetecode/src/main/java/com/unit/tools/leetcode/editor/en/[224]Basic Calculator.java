package com.unit.tools.leetcode.editor.en;//Given a string s representing a valid expression, implement a basic calculator
// to evaluate it, and return the result of the evaluation. 
//
// Note: You are not allowed to use any built-in function which evaluates string
//s as mathematical expressions, such as eval(). 
//
// 
// Example 1: 
//
// 
//Input: s = "1 + 1"
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: s = " 2-1 + 2 "
//Output: 3
// 
//
// Example 3: 
//
// 
//Input: s = "(1+(4+5+2)-3)+(6+8)"
//Output: 23
// 
//
// Example 4: 
//
// 
//Input: s = "+48 + -48"
//Output: 0
//Explanation: Numbers can have multiple digits and start with +/-.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 3 * 105 
// s consists of digits, '+', '-', '(', ')', and ' '. 
// s represents a valid expression. 
// Every number and running calculation will fit in a signed 32-bit integer. 
// 
// Related Topics Math Stack 
// 👍 2268 👎 200


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution224 {

    public int calculate(String s) {
        int res = 0, sign = 1, len = s.length();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (c >= '0') {
                int num = 0;
                while (i < len && s.charAt(i) >= '0') {
                    num = 10 * num + s.charAt(i++) - '0';
                }
                res += sign * num;
                --i;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                st.push(res);
                st.push(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res *= st.peek();
                st.pop();
                res += st.peek();
                st.pop();
            }
        }

        return res;
    }

    public int calculate2(String s) {
        int len = s.length(), num = 0, curRes = 0, res = 0, count = 0, left = 0, right = 0;
        char op = '+';
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; ++i) {
            char c = chars[i];
            if (c == '(') {
                if (count == 0) {
                    left = i + 1;
                }
                ++count;
                continue;
            } else if (c == ')') {
                --count;
                if (count == 0) {
                    right = i;
                    num = calculate(s.substring(left, right));
                }
            } else if (count > 0) {
                continue;
            }

            if (c >= '0' && c <='9') {
                num = num * 10 + c - '0';
            }

            if (c == '+' || c == '-' || c == '*' || c == '/' || i == len - 1) {
                switch (op) {
                    case '+': curRes += num; break;
                    case '-': curRes -= num; break;
                    case '*': curRes *= num; break;
                    case '/': curRes /= num; break;
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

//    public static void main(String[] args) {
//        System.out.println(calculate("99"));
//        System.out.println(calculate("(1 + (4 + 5 + 2) - 3)"));
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
