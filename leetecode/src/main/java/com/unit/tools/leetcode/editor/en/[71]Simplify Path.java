package com.unit.tools.leetcode.editor.en;
//Given a string path, which is an absolute path (starting with a slash '/') to
//a file or directory in a Unix-style file system, convert it to the simplified ca
//nonical path. 
//
// In a Unix-style file system, a period '.' refers to the current directory, a 
//double period '..' refers to the directory up a level, and any multiple consecut
//ive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any
// other format of periods such as '...' are treated as file/directory names. 
//
// The canonical path should have the following format: 
//
// 
// The path starts with a single slash '/'. 
// Any two directories are separated by a single slash '/'. 
// The path does not end with a trailing '/'. 
// The path only contains the directories on the path from the root directory to
// the target file or directory (i.e., no period '.' or double period '..') 
// 
//
// Return the simplified canonical path. 
//
// 
// Example 1: 
//
// 
//Input: path = "/home/"
//Output: "/home"
//Explanation: Note that there is no trailing slash after the last directory nam
//e.
// 
//
// Example 2: 
//
// 
//Input: path = "/../"
//Output: "/"
//Explanation: Going one level up from the root directory is a no-op, as the roo
//t level is the highest level you can go.
// 
//
// Example 3: 
//
// 
//Input: path = "/home//foo/"
//Output: "/home/foo"
//Explanation: In the canonical path, multiple consecutive slashes are replaced 
//by a single one.
// 
//
// Example 4: 
//
// 
//Input: path = "/a/./b/../../c/"
//Output: "/c"
// 
//
// 
// Constraints: 
//
// 
// 1 <= path.length <= 3000 
// path consists of English letters, digits, period '.', slash '/' or '_'. 
// path is a valid absolute Unix path. 
// 
// Related Topics String Stack 
// 👍 327 👎 95


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution71 {
    public String simplifyPath(String path) {
        String[] inodes = path.split("/");
        Stack<String> s = new Stack<>();
        for (String inode : inodes) {
            if (!s.isEmpty() && inode.equals("..")) {
                s.pop();
            } else if (!inode.equals(".") && !inode.equals("") && !inode.equals("..")) {
                s.push(inode);
            }
        }

        List<String> simpleInodes = new ArrayList<>(s);
        return "/" + String.join("/", simpleInodes);


//        String[] inodes = StringUtils.split(path, "/");
//        List<String> simpleInodes = new ArrayList<>();
//        for (String inode : inodes) {
//            switch (inode) {
//                case ".":
//                    continue;
//                case "..":
//                    if (simpleInodes.size() > 1) {
//                        simpleInodes.remove(simpleInodes.size() - 1);
//                    }
//                    continue;
//                default:
//                    simpleInodes.add(inode);
//            }
//        }
//
//        for (String simpleInode : simpleInodes) {
//            result += simpleInode + "/";
//        }
//
//        return result.length() > 1 ? result.substring(result.length() - 1) : result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
