package com.unit.tools.leetcode.editor.en;//Given an input string (s) and a pattern (p), implement wildcard pattern matchi
//ng with support for '?' and '*' where: 
//
// 
// '?' Matches any single character. 
// '*' Matches any sequence of characters (including the empty sequence). 
// 
//
// The matching should cover the entire input string (not partial). 
//
// 
// Example 1: 
//
// 
//Input: s = "aa", p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
// 
//
// Example 2: 
//
// 
//Input: s = "aa", p = "*"
//Output: true
//Explanation: '*' matches any sequence.
// 
//
// Example 3: 
//
// 
//Input: s = "cb", p = "?a"
//Output: false
//Explanation: '?' matches 'c', but the second letter is 'a', which does not mat
//ch 'b'.
// 
//
// Example 4: 
//
// 
//Input: s = "adceb", p = "*a*b"
//Output: true
//Explanation: The first '*' matches the empty sequence, while the second '*' ma
//tches the substring "dce".
// 
//
// Example 5: 
//
// 
//Input: s = "acdcb", p = "a*c?b"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length, p.length <= 2000 
// s contains only lowercase English letters. 
// p contains only lowercase English letters, '?' or '*'. 
// 
// Related Topics String Dynamic Programming Backtracking Greedy 
// 👍 3005 👎 142


//leetcode submit region begin(Prohibit modification and deletion)
class Solution44 {
    public static boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int i = 1; i <= pLen; ++i) {
            if (p.charAt(i - 1) == '*') dp[0][i] = dp[0][i - 1];
        }

        for (int i = 1; i <= sLen; ++i) {
            for (int j = 1; j <= pLen; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = (dp[i - 1][j] || dp[i][j - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?');
                }
            }
        }

        return dp[sLen][pLen];
    }

    public static void main(String[] args) {
//        System.out.println(isMatch("adceb", "*a*b"));
        System.out.println(isMatch("aab", "c*a*b"));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
