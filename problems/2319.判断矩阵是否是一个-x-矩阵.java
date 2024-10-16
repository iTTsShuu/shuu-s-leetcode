/*
 * @lc app=leetcode.cn id=2319 lang=java
 *
 * [2319] 判断矩阵是否是一个 X 矩阵
 */

// @lc code=start
class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((!isBorder(i, j, n) && grid[i][j] == 0) || (isBorder(i, j, n) && grid[i][j] != 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    // 判断是否为边界
    boolean isBorder(int i, int j, int n) {
        return i != j && i + j != n - 1;
    }
}
// @lc code=end
