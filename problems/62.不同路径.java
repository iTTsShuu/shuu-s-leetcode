/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        // 动态规划
        // int[][] ans=new int[m][n];
        // for (int j = 0; j < n; j++) {
        // ans[0][j]=1;
        // }
        // for (int i = 0; i < m; i++) {
        // ans[i][0]=1;
        // }
        // for (int i = 1; i < m; i++) {
        // for (int j = 1; j < n; j++) {
        // ans[i][j]=ans[i-1][j]+ans[i][j-1];
        // }
        // }
        // return ans[m-1][n-1];‘

        // 排列组合计算即可
        long up = 1;
        for (int i = n; i <= m + n - 2; i++) {
            up *= i;
        }
        long down = 1;
        for (int i = 1; i <= m - 1; i++) {
            down *= i;
        }
        return (int) (up / down);
    }
}

// @lc code=end
class uniquePathstest {
    public static void main(String[] args) {
        mySolution solution = new mySolution();
        System.out.println(solution.uniquePaths(3, 10));
    }
}
