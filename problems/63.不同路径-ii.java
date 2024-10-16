/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    if (j >= 1 && obstacleGrid[i][j - 1] == 0) {
                        dp[j] += dp[j - 1];
                    }
                }
            }
        }
        return dp[n - 1];
    }

    /*
     * public int uniquePathsWithObstacles(int[][] obstacleGrid) {
     * int m = obstacleGrid.length, n = obstacleGrid[0].length;
     * int[][] dp = new int[m][n];
     * // 遍历第一列
     * for (int i = 0; i < m; i++) {
     * // 遇到障碍物终止
     * if (obstacleGrid[i][0] == 1) {
     * break;
     * }
     * dp[i][0] = 1;
     * }
     * // 遍历第一行
     * for (int i = 0; i < n; i++) {
     * // 遇到障碍物终止
     * if (obstacleGrid[0][i] == 1) {
     * break;
     * }
     * dp[0][i] = 1;
     * }
     * // 遍历求解
     * for (int i = 1; i < m; i++) {
     * for (int j = 1; j < n; j++) {
     * if (obstacleGrid[i][j] == 1) {
     * dp[i][j] = 0;
     * } else {
     * dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
     * }
     * }
     * }
     * return dp[m - 1][n - 1];
     * }
     */
}
// @lc code=end
