package com.unit.tools.leetcode.editor.en;//Given a string s containing only digits, return all possible valid IP addresse
//s that can be obtained from s. You can return them in any order. 
//
// A valid IP address consists of exactly four integers, each integer is between
// 0 and 255, separated by single dots and cannot have leading zeros. For example,
// "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.
//168.1.312" and "192.168@1.1" are invalid IP addresses. 
//
// 
// Example 1: 
// Input: s = "25525511135"
//Output: ["255.255.11.135","255.255.111.35"]
// Example 2: 
// Input: s = "0000"
//Output: ["0.0.0.0"]
// Example 3: 
// Input: s = "1111"
//Output: ["1.1.1.1"]
// Example 4: 
// Input: s = "010010"
//Output: ["0.10.0.10","0.100.1.0"]
// Example 5: 
// Input: s = "101023"
//Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
// 
// Constraints: 
//
// 
// 0 <= s.length <= 3000 
// s consists of digits only. 
// 
// Related Topics String Backtracking 
// 👍 1802 👎 569


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        Stack<String> out = new Stack<>();
        dfs(s, 0, out, res);

        return res;
    }

    public void dfs(String s, int level, Stack<String> out, List<String> res) {
        if (level == 4) {
            if (s.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> iterator = out.iterator();
                while (iterator.hasNext()) {
                    sb.append(iterator.next());
                    sb.append(".");
                }
                sb.deleteCharAt(sb.length() - 1);
                res.add(sb.toString());
            }

            return;
        }

        for (int i = 1; i < 4; ++i) {
            if (s.length() < i) break;
            int val = Integer.parseInt(s.substring(0, i));
            // 数值大于255/数值首位字符为0
            if (val > 255 || i != String.valueOf(val).length()) continue;
            out.push(s.substring(0, i));
            dfs(s.substring(i), level + 1, out, res);
            out.pop();
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
