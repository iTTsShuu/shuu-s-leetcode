/*
 * @lc app=leetcode.cn id=463 lang=java
 *
 * [463] 岛屿的周长
 */

// @lc code=start
class Solution {
    int zhouchang;

    public int islandPerimeter(int[][] grid) {
        zhouchang = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }
        return zhouchang;
    }

    void dfs(int[][] grid, int i, int j) {
        if (!inArea(grid, i, j)) {
            zhouchang++;
            return;
        }
        if (grid[i][j] == 2) {
            return;
        }
        if (grid[i][j] == 0) {
            // 同一套代码
            // shuu: 这里标记为边的思想为递归时
            // 只会从岛屿递归到非岛屿 每次递归到非岛屿都代表遇到一个边
            zhouchang++;
            return;
        }
        grid[i][j] = 2;
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }

    boolean inArea(int[][] grid, int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
}
// @lc code=end
