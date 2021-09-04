package com.unit.tools.leetcode.editor.en;//Given a string expression of numbers and operators, return all possible result
//s from computing all the different possible ways to group numbers and operators.
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: expression = "2-1-1"
//Output: [0,2]
//Explanation:
//((2-1)-1) = 0 
//(2-(1-1)) = 2
// 
//
// Example 2: 
//
// 
//Input: expression = "2*3-4*5"
//Output: [-34,-14,-10,-10,10]
//Explanation:
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10
// 
//
// 
// Constraints: 
//
// 
// 1 <= expression.length <= 20 
// expression consists of digits and the operator '+', '-', and '*'. 
// 
// Related Topics Divide and Conquer 
// 👍 2193 👎 118


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution241 {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        int len = expression.length();
        for (int i = 0; i < len; ++i) {
            char temp = expression.charAt(i);
            if (temp == '-' || temp == '+' || temp == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1, len));
                for (int m = 0; m < left.size(); ++m) {
                    for (int n = 0; n < right.size(); ++n) {
                        if (expression.charAt(i) == '-') res.add(left.get(m) - right.get(n));
                        else if (expression.charAt(i) == '+') res.add(left.get(m) + right.get(n));
                        else if (expression.charAt(i) == '*') res.add(left.get(m) * right.get(n));
                    }
                }
            }
        }
        if (res.isEmpty()) {
            if (Integer.valueOf(expression) > Integer.MAX_VALUE) res.add(Integer.MAX_VALUE);
            else res.add(Integer.valueOf(expression));
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
