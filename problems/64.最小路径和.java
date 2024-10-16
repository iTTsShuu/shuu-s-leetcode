/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] ans=new int[m][n];
        ans[0][0]=grid[0][0];
        for (int i = 1; i < m; i++) {
            ans[i][0]=ans[i-1][0]+grid[i][0];
        }
        for(int j=1;j<n;j++){
            ans[0][j]=ans[0][j-1]+grid[0][j];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                ans[i][j]=Math.min(ans[i-1][j], ans[i][j-1])+grid[i][j];
            }
        }
        return ans[m-1][n-1];
    }
}
// @lc code=end

