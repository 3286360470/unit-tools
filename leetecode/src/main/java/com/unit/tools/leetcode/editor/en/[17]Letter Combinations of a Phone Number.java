package com.unit.tools.leetcode.editor.en;//Given a string containing digits from 2-9 inclusive, return all possible lette
//r combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digit to letters (just like on the telephone buttons) is given b
//elow. Note that 1 does not map to any letters. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
// Related Topics String Backtracking Depth-first Search Recursion 
// 👍 6123 👎 530


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution17 {
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) return res;

        String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Stack<Character> out = new Stack<>();
        letterCombinationDFS(digits, 0, dict, out, res);

        return res;
    }

    public static void letterCombinationDFS(String digits, int level, String[] dict, Stack<Character> out, List<String> res) {
        if (level == digits.length()) {
            StringBuilder sb = new StringBuilder();

            Iterator<Character> iterator = out.iterator();
            while (iterator.hasNext()) {
                sb.append(iterator.next());
            }
            res.add(sb.toString());

            return;
        }

        String temp = dict[digits.charAt(level) - '0'];
        for (int i = 0; i < temp.length(); ++i) {
            out.push(temp.charAt(i));
            letterCombinationDFS(digits, level + 1, dict, out, res);
            out.pop();
        }

    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
