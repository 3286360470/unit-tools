package com.unit.tools.leetcode.editor.en;
//Given a string s, return the longest palindromic substring in s.
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// Example 3: 
//
// 
//Input: s = "a"
//Output: "a"
// 
//
// Example 4: 
//
// 
//Input: s = "ac"
//Output: "a"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters (lower-case and/or upper-case), 
//
// Related Topics String Dynamic Programming 
// 👍 10783 👎 692


//leetcode submit region begin(Prohibit modification and deletion)
class Solution5 {
    private int left = 0;
    private int right = 0;
    private int max = 0;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        for (int i = 0; i < len - 1; ++i) {
            centralExpand(s, i, i, len);
            centralExpand(s, i, i + 1, len);
        }

        return s.substring(left, right + 1);
    }

    private void centralExpand(String s, int i, int j, int len) {
        while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
            --i;
            ++j;
        }

        if (max < j - i - 1) {
            max = j - i - 1;
            left = i + 1;
            right = j - 1;
        }
    }

    public static String longestPalindrome1(String s) {
        int len = s.length();
        int start = 0, end = 0, max = 0;
        if (len < 2) return s;
        for (int i = 0; i < len;) {
            if (len - i <= max / 2) break;
            int left = i, right = i;
            while (right < len - 1 && s.charAt(right) == s.charAt(right + 1)) ++right;
            i = right + 1;
            while (left > 0 && right < len - 1 && s.charAt(left - 1) == s.charAt(right + 1)) {
                --left;
                ++right;
            }
            if (max < (right - left + 1)) {
                max = (right - left + 1);
                start = left;
                end = right;
            }
        }

        return s.substring(start, end + 1);
    }

//    public static void main(String[] args) {
//        System.out.println(longestPalindrome("a"));
//        System.out.println(longestPalindrome("ac"));
//        System.out.println(longestPalindrome("cbbd"));
//        System.out.println(longestPalindrome("ababd"));
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
