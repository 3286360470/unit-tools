package com.unit.tools.leetcode.editor.en;//Write an efficient algorithm that searches for a value in an m x n matrix. Thi
//s matrix has the following properties: 
//
// 
// Integers in each row are sorted from left to right. 
// The first integer of each row is greater than the last integer of the previou
//s row. 
// 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics Array Binary Search 
// 👍 3126 👎 194


//leetcode submit region begin(Prohibit modification and deletion)
class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int up = 0, down = matrix.length;
        while (up < down) {
            int mid = (up + down) / 2;
            if (matrix[mid][0] == target) return true;
            else if (matrix[mid][0] < target) up = mid + 1;
            else down = mid;
        }
        int tmp = (down > 0) ? down - 1 : down;
        int left = 0, right = matrix[tmp].length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (matrix[tmp][mid] == target) return true;
            else if (matrix[tmp][mid] < target) left = mid + 1;
            else right = mid;
        }

        return false;



//        int m = matrix.length;
//        int n = matrix[0].length;
//        int i = 0, j = 0;
//        while (++i < m) {
//            if (matrix[i - 1][n - 1] < target && target < matrix[i][n - 1]) {
//                break;
//            } else if (target == matrix[i][n - 1]) {
//                return true;
//            }
//        }
//        if (i >= m) {
//            return false;
//        }
//
//        while (j < n) {
//            if (matrix[i][j] == target) {
//                return true;
//            }
//        }
//
//        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
