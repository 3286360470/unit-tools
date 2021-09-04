package com.unit.tools.leetcode.editor.en;//Given two strings s and t of lengths m and n respectively, return the minimum
//window in s which will contain all the characters in t. If there is no such wind
//ow in s that covers all characters in t, return the empty string "". 
//
// Note that If there is such a window, it is guaranteed that there will always 
//be only one unique minimum window in s. 
//
// 
// Example 1: 
// Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
// Example 2: 
// Input: s = "a", t = "a"
//Output: "a"
// 
// 
// Constraints: 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 105 
// s and t consist of English letters. 
// 
//
// 
//Follow up: Could you find an algorithm that runs in O(m + n) time? Related Top
//ics Hash Table Two Pointers String Sliding Window 
// 👍 6620 👎 451


//leetcode submit region begin(Prohibit modification and deletion)
class Solution76 {
    public static String minWindow(String s, String t) {
        int[] asc = new int[128];
        int left = 0, cnt = 0, minLeft = -1, minLen = Integer.MAX_VALUE,
            sLen = s.length(), tLen = t.length();
        char[] tArr = t.toCharArray();
        for (char c : tArr) ++asc[c];
        for (int i = 0; i < sLen; ++i) {
            if (--asc[s.charAt(i)] >= 0) ++cnt;
            while (cnt == tLen) {
                if (minLen > i - left + 1) {
                    minLen = i - left + 1;
                    minLeft = left;
                }
                if (++asc[s.charAt(left)] > 0) --cnt;
                ++left;
            }
        }

        return minLeft == -1 ? "" : s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
