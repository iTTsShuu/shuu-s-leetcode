/*
 * @lc app=leetcode.cn id=329 lang=java
 *
 * [329] 矩阵中的最长递增路径
 */

// @lc code=start

class Solution {
    // 字节真题 现场k的差不多了 有一些BUG
    // shuu: 记忆化搜索dp
    // shuu: 这里是回溯的去写的
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 1;
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(matrix, i, j, dp);
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    int dfs(int[][] matrix, int curI, int curJ, int[][] dp) {
        // 没有方向可以选择或者方向已经求过
        if (!hasDir(matrix, curI, curJ) || dp[curI][curJ] != 1) {
            return dp[curI][curJ];
        }
        int[][] dirs = new int[][] {
                { 1, 0 },
                { -1, 0 },
                { 0, 1 },
                { 0, -1 }
        };
        int max = 1;
        for (int i = 0; i < 4; i++) {
            int ii = curI + dirs[i][0];
            int jj = curJ + dirs[i][1];
            if ((ii >= 0 && ii < matrix.length) && (jj >= 0 && jj < matrix[0].length)) {
                if (matrix[ii][jj] < matrix[curI][curJ]) {
                    if (dp[ii][jj] == 1) {
                        dfs(matrix, ii, jj, dp);
                    }
                    max = Math.max(max, dp[ii][jj]);
                }
            }
        }
        dp[curI][curJ] = max + 1;
        return dp[curI][curJ];
    }

    boolean hasDir(int[][] matrix, int curI, int curJ) {
        int[][] dirs = new int[][] {
                { 1, 0 },
                { -1, 0 },
                { 0, 1 },
                { 0, -1 }
        };
        for (int i = 0; i < 4; i++) {
            int ii = curI + dirs[i][0];
            int jj = curJ + dirs[i][1];
            if ((ii >= 0 && ii < matrix.length) && (jj >= 0 && jj < matrix[0].length)) {
                if (matrix[ii][jj] < matrix[curI][curJ]) {
                    return true;
                }
            }
        }
        return false;
    }
}

// @lc code=end
class Test329 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][] {
                { 9, 9, 4 },
                { 6, 6, 8 },
                { 2, 1, 1 }
        };
        int ans = solution.longestIncreasingPath(grid);

        System.out.println(ans);
    }
}