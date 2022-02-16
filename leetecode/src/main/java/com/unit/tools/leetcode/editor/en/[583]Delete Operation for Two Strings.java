package com.unit.tools.leetcode.editor.en;
//Given two strings word1 and word2, return the minimum number of steps required
// to make word1 and word2 the same. 
//
// In one step, you can delete exactly one character in either string. 
//
// 
// Example 1: 
//
// 
//Input: word1 = "sea", word2 = "eat"
//Output: 2
//Explanation: You need one step to make "sea" to "ea" and another step to make 
//"eat" to "ea".
// 
//
// Example 2: 
//
// 
//Input: word1 = "leetcode", word2 = "etco"
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= word1.length, word2.length <= 500 
// word1 and word2 consist of only lowercase English letters. 
// 
// Related Topics String Dynamic Programming 
// 👍 2497 👎 42


//leetcode submit region begin(Prohibit modification and deletion)
class Solution583 {
    public int minDistance2(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int [][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 1; i <= m; ++i) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; ++j) {
            dp[0][j] = j;
        }
        // dp table: 自底向上求解
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (word1.charAt(i - 1) ==word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i-  1][j], dp[i][j - 1]) + 1;
//                    dp[i][j] = min(
//                        dp[i - 1][j - 1] + 1,
//                        dp[i - 1][j] + 1,
//                        dp[i][j - 1] + 1);
                }
            }
        }
        // 存储了word1到word2的最小编辑距离
        return dp[m][n];
    }

    /**
     * 通过求最大共同子序列间接计算最小操作步骤
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; ++j) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return m + n - 2 * dp[m][n];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
