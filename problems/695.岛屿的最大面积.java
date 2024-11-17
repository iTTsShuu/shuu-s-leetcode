/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start

class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        // 还是一种深度递归标记的思想
        // 遇到1时深度遍历这个岛屿 计算面积并标记访问过的位置
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(dfs(i, j, grid), ans);
                }
            }
        }
        return ans;
    }

    private int dfs(int curI, int curJ, int[][] grid) {
        if (curI < 0 || curI >= grid.length || curJ < 0 || curJ >= grid[0].length || grid[curI][curJ] != 1) {
            return 0;
        }
        grid[curI][curJ] = 0;
        int ans = 1;
        // 四个方向深度遍历
        int[][] dirs = new int[][] {
                { 1, 0 },
                { 0, 1 },
                { -1, 0 },
                { 0, -1 }
        };
        for (int i = 0; i < 4; i++) {
            int ii = curI + dirs[i][0];
            int jj = curJ + dirs[i][1];
            ans += dfs(ii, jj, grid);
        }
        // 不是我的写法为啥不过啊
        // 向四个方向发散求和
        // ans += dfs(curI - 1, curJ, grid);
        // ans += dfs(curI + 1, curJ, grid);
        // ans += dfs(curI, curJ - 1, grid);
        // ans += dfs(curI, curJ + 1, grid);
        return ans;
    }

}

// @lc code=end
class test695 {
    public static void main(String[] args) {
        int[][] grid = new int[][] {
                { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }
        };
    }
}