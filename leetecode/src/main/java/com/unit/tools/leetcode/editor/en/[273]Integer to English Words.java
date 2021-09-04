package com.unit.tools.leetcode.editor.en;//Convert a non-negative integer num to its English words representation.
//
// 
// Example 1: 
// Input: num = 123
//Output: "One Hundred Twenty Three"
// Example 2: 
// Input: num = 12345
//Output: "Twelve Thousand Three Hundred Forty Five"
// Example 3: 
// Input: num = 1234567
//Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven
//"
// Example 4: 
// Input: num = 1234567891
//Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven 
//Thousand Eight Hundred Ninety One"
// 
// 
// Constraints: 
//
// 
// 0 <= num <= 231 - 1 
// 
// Related Topics Math String 
// 👍 1482 👎 3700


import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution273 {
    public String numberToWords(int num) {
        String res = convertHundred(num % 1000);
        List<String> v = Arrays.asList(new String[] {"Thousand", "Million", "Billion"});
        for (int i = 0; i < 3; ++i) {
            num /= 1000;
            res = num % 1000 > 0 ? convertHundred(num % 1000) + " " + v.get(i) + " " + res : res;
        }
        res = res.trim();
        return res.isEmpty() ? "Zero" : res;
    }

    private String convertHundred(int num) {
        List<String> v1 = Arrays.asList(new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"});
        List<String> v2 = Arrays.asList(new String[] {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"});
        String res;
        int a = num / 100, b = num % 100, c = num % 10;
        res = b < 20 ? v1.get(b) : v2.get(b / 10) + (c > 0 ? " " + v1.get(c) : "");
        if (a > 0) {
            res = v1.get(a) + " Hundred" + (b > 0 ? " " + res : "");
        }

        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
