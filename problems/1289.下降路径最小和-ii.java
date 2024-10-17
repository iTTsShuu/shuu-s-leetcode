/*
 * @lc app=leetcode.cn id=1289 lang=java
 *
 * [1289] 下降路径最小和  II
 */

// @lc code=start
class Solution {
    public int minFallingPathSum(int[][] grid) {
        // 递归
        // int n = grid.length;
        // int[] mins = new int[n];
        // for (int i = 0; i < n; i++) {
        // mins[i] = dfs(grid, n, i, n - 1);
        // }
        // int ans = Integer.MAX_VALUE;
        // for (int min : mins) {
        // ans = Math.min(ans, min);
        // }
        // return ans;

        // shuu: 记忆搜索避免重复计算
        int n = grid.length;
        if (n == 1) {
            return grid[0][0];
        }
        // shuu: dp[i][j]=Min(dp[i-1][0:j-1~j+1:n-1])+grid[i][j]
        // 这里的dp[i]只与dp[i-1]有关 可以用2个数组滚动优化空间
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            ans = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        min = Math.min(min, dp[i - 1][k]);
                    }
                }
                dp[i][j] = min + grid[i][j];
                ans = Math.min(ans, dp[i][j]);
            }
        }
        return ans;

    }

    // 这里的递归虽然是正确的 但会有很多重复计算
    // 改用记忆数组搜索
    int dfs(int[][] grid, int n, int i, int depth) {
        if (depth == 0) {
            return grid[0][i];
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            // 遍历枚举上一行 非本列的最小值
            if (j != i) {
                min = Math.min(min, dfs(grid, n, j, depth - 1));
            }
        }
        return grid[depth][i] + min;
    }
}
// @lc code=end
