/*
 * @lc app=leetcode.cn id=1351 lang=java
 *
 * [1351] 统计有序矩阵中的负数
 */

// @lc code=start
class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int left = 0, right = m - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (grid[i][mid] >= 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (grid[i][left] < 0) {
                sum += m - left;
            }
        }
        return sum;
    }
}
// @lc code=end
