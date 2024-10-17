/*
 * @lc app=leetcode.cn id=2684 lang=java
 *
 * [2684] 矩阵中移动的最大次数
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int maxMoves(int[][] grid) {
        // 先想到
        int m = grid.length;
        int n = grid[0].length;
        // 记忆化搜索
        int[][] memo = new int[m][n];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            ans = Math.max(backTrack(grid, i, 0, memo), ans);
        }
        return ans;
    }

    // shuu:递归 深度优先
    // 返回值为当前位置可以往后移动的最大
    // 其实有很多 多余的空间开销
    int backTrack(int[][] grid, int row, int col, int[][] memo) {
        if (col == grid[0].length - 1) {
            return 0;
        }
        // 记忆化搜索 避免重复计算
        if (memo[row][col] != -1) {
            return memo[row][col];
        }
        int max = 0;
        // 取三个方向 取可行的最大值
        if (grid[Math.max(row - 1, 0)][col + 1] > grid[row][col]) {
            max = Math.max(backTrack(grid, Math.max(row - 1, 0), col + 1, memo) + 1, max);
        }
        if (grid[row][col + 1] > grid[row][col]) {
            max = Math.max(backTrack(grid, row, col + 1, memo) + 1, max);
        }
        if (grid[Math.min(row + 1, grid.length - 1)][col + 1] > grid[row][col]) {
            max = Math.max(backTrack(grid, Math.min(row + 1, grid.length - 1), col + 1, memo) + 1, max);
        }
        return memo[row][col] = max;
    }
}
// @lc code=end
