/*
 * @lc app=leetcode.cn id=2639 lang=java
 *
 * [2639] 查询网格图中每一列的宽度
 */

// @lc code=start
class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int maxl = 0;
            for (int j = 0; j < m; j++) {
                String tmp = String.valueOf(grid[j][i]);
                maxl = Math.max(tmp.length(), maxl);
            }
            ans[i] = maxl;
        }
        return ans;
    }
}
// @lc code=end
