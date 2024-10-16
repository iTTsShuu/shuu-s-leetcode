/*
 * @lc app=leetcode.cn id=931 lang=java
 *
 * [931] 下降路径最小和
 */

// @lc code=start
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0 && j < n - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + matrix[i][j];
                } else if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + matrix[i][j];
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int idp : dp[n - 1]) {
            ans = Math.min(ans, idp);
        }
        return ans;
    }
}

// @lc code=end
class test931 {
    public static void main(String[] args) {
        Solution931 solution = new Solution931();
        int[][] matrix = new int[][] {
                { 100, -42, -46, -41 },
                { 31, 97, 10, -10 },
                { -58, -51, 82, 89 },
                { 51, 81, 69, -51 }
        };
        System.out.println(solution.minFallingPathSum(matrix));
    }
}