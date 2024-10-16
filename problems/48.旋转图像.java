/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // int[][] tmp = new int[n][n];
        // for (int i = 0; i < n; i++) {
        // tmp[i] = matrix[i].clone();
        // }
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // matrix[j][n - 1 - i] = tmp[i][j];
        // }
        // }
        // }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
// @lc code=end
