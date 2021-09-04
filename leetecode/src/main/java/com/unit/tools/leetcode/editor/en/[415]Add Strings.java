package com.unit.tools.leetcode.editor.en;//Given two non-negative integers, num1 and num2 represented as string, return t
//he sum of num1 and num2 as a string. 
//
// You must solve the problem without using any built-in library for handling la
//rge integers (such as BigInteger). You must also not convert the inputs to integ
//ers directly. 
//
// 
// Example 1: 
//
// 
//Input: num1 = "11", num2 = "123"
//Output: "134"
// 
//
// Example 2: 
//
// 
//Input: num1 = "456", num2 = "77"
//Output: "533"
// 
//
// Example 3: 
//
// 
//Input: num1 = "0", num2 = "0"
//Output: "0"
// 
//
// 
// Constraints: 
//
// 
// 1 <= num1.length, num2.length <= 104 
// num1 and num2 consist of only digits. 
// num1 and num2 don't have any leading zeros except for the zero itself. 
// 
// Related Topics String 
// 👍 1798 👎 388


//leetcode submit region begin(Prohibit modification and deletion)
class Solution415 {

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? (num1.charAt(i--) - '0') : 0;
            int b = j >= 0 ? (num2.charAt(j--) - '0') : 0;
            int temp = a + b + carry;
            res.insert(0, temp % 10);
            carry = temp / 10;
        }

        return carry == 1 ? res.insert(0, carry).toString() : res.toString();
    }

    public String addStrings2(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int temp = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + carry;
            if (temp > 9) {
                res.insert(0, temp - 10);
                carry = 1;
            } else {
                res.insert(0, temp);
                carry = 0;
            }
            --i;
            --j;
        }

        while (i >= 0) {
            int temp = (num1.charAt(i) - '0') + carry;
            if (temp > 9) {
                res.insert(0, temp - 10);
                carry = 1;
            } else {
                res.insert(0, temp);
                carry = 0;
            }
            --i;
        }

        while (j >= 0) {
            int temp = (num2.charAt(j) - '0') + carry;
            if (temp > 9) {
                res.insert(0, temp - 10);
                carry = 1;
            } else {
                res.insert(0, temp);
                carry = 0;
            }
            --j;
        }
        if (carry > 0) {
            res.insert(0, carry);
        }

        return res.toString();
    }

//    public static void main(String[] args) {
//        System.out.println(addStrings("11", "123"));
//        System.out.println(addStrings("456", "77"));
//        System.out.println(addStrings("0", "0"));
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
