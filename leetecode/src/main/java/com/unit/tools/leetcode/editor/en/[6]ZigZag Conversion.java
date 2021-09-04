package com.unit.tools.leetcode.editor.en;//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number o
//f rows like this: (you may want to display this pattern in a fixed font for bett
//er legibility) 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R
// 
//
// And then read line by line: "PAHNAPLSIIGYIR" 
//
// Write the code that will take a string and make this conversion given a numbe
//r of rows: 
//
// 
//string convert(string s, int numRows);
// 
//
// 
// Example 1: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
// 
//
// Example 2: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// Example 3: 
//
// 
//Input: s = "A", numRows = 1
//Output: "A"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of English letters (lower-case and upper-case), ',' and '.'. 
// 1 <= numRows <= 1000 
// 
// Related Topics String 
// 👍 2389 👎 5895


//leetcode submit region begin(Prohibit modification and deletion)
class Solution6 {

    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuilder res = new StringBuilder();
        int step = 2 * numRows - 2, len = s.length();
        for (int i = 0; i < numRows; ++i) {
            for (int j = i; j < len; j += step) {
                res.append(s.charAt(j));
                int pos = j + step - 2 * i;
                if (i != 0 && i != numRows - 1 && pos < len) res.append(s.charAt(pos));
            }
        }

        return res.toString();
    }

    public String convert2(String s, int numRows) {
        int len = s.length(), step = 2 * numRows - 2;
        StringBuilder res = new StringBuilder();
        for (int j = 1; j <= numRows; ++j) {
            int i = j - 1;
            if (j == 1 || j == numRows) {
                while (i < len) {
                    res.append(s.charAt(i));
                    i += step;
                }
            } else {
                while (i < len) {
                    res.append(s.charAt(i));
                    int pos = i + step - 2 * (j - 1);
                    if (pos < len) res.append(s.charAt(pos));

                    i += step;
                }
            }
        }

        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
