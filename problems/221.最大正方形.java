/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] - '0' == 1) {
                    int maxL = countMax(i, j, matrix);
                    ans = Math.max(ans, maxL);
                }
            }
        }
        return ans * ans;
    }

    private int countMax(int i, int j, char[][] matrix) {

        int plusL = 1;
        while (inRange(i + plusL, j + plusL, matrix)) {
            if (isSqure(i, j, matrix, plusL)) {
                plusL++;
            } else {
                break;
            }
        }
        return plusL;
    }

    private boolean inRange(int i, int j, char[][] matrix) {
        return i < matrix.length && i >= 0 &&
                j < matrix[0].length && j >= 0;
    }

    private boolean isSqure(int i, int j, char[][] matrix, int plusL) {
        boolean ans = true;

        for (int k = i; k <= i + plusL; k++) {
            if (matrix[k][j + plusL] - '0' == 0) {
                ans = false;
                break;
            }
        }
        for (int k2 = j; k2 <= j + plusL; k2++) {
            if (matrix[i + plusL][k2] - '0' == 0) {
                ans = false;
                break;
            }
        }
        return ans;
    }
}
// @lc code=end
