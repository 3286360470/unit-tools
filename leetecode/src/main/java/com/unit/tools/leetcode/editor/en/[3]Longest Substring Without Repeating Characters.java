package com.unit.tools.leetcode.editor.en;
//Given a string s, find the length of the longest substring without repeating c
//haracters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// Example 4: 
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
// 0 <= s.length <= 5 * 104 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table Two Pointers String Sliding Window 
// 👍 13346 👎 689


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        int res = 0, left = -1, len = s.length();
        int[] arr = new int[256];
        Arrays.fill(arr, -1);
        for (int i = 0; i < len; ++i) {
            left = Math.max(arr[s.charAt(i)], left);
            arr[s.charAt(i)] = i;
            res = Math.max(res, i - left);
        }

        return res;
    }

    public int lengthOfLongestSubstring1(String s) {
        int res = 0, left = 0, right = 0;
        Set<Character> t = new HashSet<>();
        while (right < s.length()) {
            if (!t.contains(s.charAt(right))) {
                t.add(s.charAt(right++));
                res = Math.max(res, t.size());
            } else {
                t.remove(s.charAt(left++));
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
