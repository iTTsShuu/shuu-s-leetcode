/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int x = 0, y = m - 1;
        while (x < n && y >= 0) {
            int curr = matrix[x][y];
            if (curr > target) {
                y--;
            } else if (curr < target) {
                x++;
            } else {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
