/*
 * @lc app=leetcode.cn id=1572 lang=java
 *
 * [1572] 矩阵对角线元素的和
 */

// @lc code=start
class Solution {
    public int diagonalSum(int[][] mat) {
        int som=0;
        int n=mat.length;
        for (int i = 0,j = 0; i < n; i++,j++) {
            som+=mat[i][j];
        }
        for (int i = 0,j=n-1; i < n; i++,j--) {
            som+=mat[j][i];
        }
        if (n%2!=0) {
            som-=mat[n/2][n/2];
        }
        return som;
    }
}
// @lc code=end

