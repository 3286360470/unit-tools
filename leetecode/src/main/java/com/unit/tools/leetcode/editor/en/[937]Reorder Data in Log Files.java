package com.unit.tools.leetcode.editor.en;//You are given an array of logs. Each log is a space-delimited string of words,
// where the first word is the identifier. 
//
// There are two types of logs: 
//
// 
// Letter-logs: All words (except the identifier) consist of lowercase English l
//etters. 
// Digit-logs: All words (except the identifier) consist of digits. 
// 
//
// Reorder these logs so that: 
//
// 
// The letter-logs come before all digit-logs. 
// The letter-logs are sorted lexicographically by their contents. If their cont
//ents are the same, then sort them lexicographically by their identifiers. 
// The digit-logs maintain their relative ordering. 
// 
//
// Return the final order of the logs. 
//
// 
// Example 1: 
//
// 
//Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","le
//t3 art zero"]
//Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig
//2 3 6"]
//Explanation:
//The letter-log contents are all different, so their ordering is "art can", "ar
//t zero", "own kit dig".
//The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
// 
//
// Example 2: 
//
// 
//Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act z
//oo"]
//Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
// 
//
// 
// Constraints: 
//
// 
// 1 <= logs.length <= 100 
// 3 <= logs[i].length <= 100 
// All the tokens of logs[i] are separated by a single space. 
// logs[i] is guaranteed to have an identifier and at least one word after the i
//dentifier. 
// 
// Related Topics String 
// 👍 1086 👎 2931


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution937 {
    public String[] reorderLogFiles(String[] logs) {
        List<String> res = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        List<List<String>> data = new ArrayList<>();
        for (String log : logs) {
            int index = log.indexOf(" ");
            if (log.charAt(index + 1) >= '0' && log.charAt(index + 1) <= '9') {
                digitLogs.add(log);
                continue;
            }
            data.add(Arrays.asList(new String[] {log.substring(0, index), log.substring(index + 1)}));
        }
//        Arrays.sort(data.toArray(), new Comparator<List<String>>() {
//            @Override
//            public int compare(List<String> o1, List<String> o2) {
//                if (o2.get(1).compareTo(o1.get(1)) != 0) return o2.get(1).compareTo(o1.get(1));
//                else {
//                    return o2.get(0).compareTo(o1.get(0));
//                }
//            }
//        });
        return res.toArray(new String[] {});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
