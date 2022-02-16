package com.unit.tools.leetcode.editor.en;
//Given a string word, return the sum of the number of vowels ('a', 'e', 'i', 'o
//', and 'u') in every substring of word. 
//
// A substring is a contiguous (non-empty) sequence of characters within a strin
//g. 
//
// Note: Due to the large constraints, the answer may not fit in a signed 32-bit
// integer. Please be careful during the calculations. 
//
// 
// Example 1: 
//
// 
//Input: word = "aba"
//Output: 6
//Explanation: 
//All possible substrings are: "a", "ab", "aba", "b", "ba", and "a".
//- "b" has 0 vowels in it
//- "a", "ab", "ba", and "a" have 1 vowel each
//- "aba" has 2 vowels in it
//Hence, the total sum of vowels = 0 + 1 + 1 + 1 + 1 + 2 = 6. 
// 
//
// Example 2: 
//
// 
//Input: word = "abc"
//Output: 3
//Explanation: 
//All possible substrings are: "a", "ab", "abc", "b", "bc", and "c".
//- "a", "ab", and "abc" have 1 vowel each
//- "b", "bc", and "c" have 0 vowels each
//Hence, the total sum of vowels = 1 + 1 + 1 + 0 + 0 + 0 = 3. 
//
// Example 3: 
//
// 
//Input: word = "ltcd"
//Output: 0
//Explanation: There are no vowels in any substring of "ltcd". 
//
// Example 4: 
//
// 
//Input: word = "noosabasboosa"
//Output: 237
//Explanation: There are a total of 237 vowels in all the substrings.
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length <= 105 
// word consists of lowercase English letters. 
// 
// 👍 64 👎 8


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution2063 {
    public static long countVowels4(String word) {
        long res = 0;
        int[] asic = new int[128];
        List<String> subString = new ArrayList<>();
        for (int i = 0; i < word.length(); ++i) {
            for (int j = word.length() - 1; j >= i; --j) {
                subString.add(word.substring(i, j + 1));
            }
        }
        for (String s : subString) {
            for (char cur : s.toCharArray()) {
                if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') {
                    if (asic[cur] == 0) {
                        asic[cur] = 1;
                    } else {
                        asic[cur]++;
                    }
                }
            }
        }
        res = asic['a'] + asic['e'] + asic['i'] + asic['o'] + asic['u'];

        return res;
    }

    public static long countVowels2(String word) {
        long res = 0;
        int[] asic = new int[128];
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            for (int j = chars.length - 1; j >= i; --j) {
                for (int k = i; k <= j; ++k) {
                    char cur = chars[k];
                    if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') {
                        if (asic[cur] == 0) {
                            asic[cur] = 1;
                        } else {
                            asic[cur]++;
                        }
                    }
                }

            }
        }
        res = asic['a'] + asic['e'] + asic['i'] + asic['o'] + asic['u'];

        return res;
    }

    public static long countVowels3(String word) {
        long res = 0, last = 0;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            for (int j = i; j < chars.length; ++j) {
                char cur = chars[j];
                if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') {
                    last += 1;
                    res += last;
                } else {
                    res += last;
                }
            }
            last = 0;
        }

        return res;
    }

    public long countVowels(String word) {
        long res = 0;
        long len = word.length();
        for (int i = 0; i < len; ++i) {
            char cur = word.charAt(i);
            if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') {
                res += (i + 1) * (len - i);
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
