/*
 * @lc app=leetcode.cn id=2658 lang=java
 *
 * [2658] 网格图中鱼的最大数目
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;

class Solution {
    public int findMaxFish(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    ans = Math.max(dfs(grid, i, j), ans);
                }
            }
        }
        List<Integer> ansList = new LinkedList<>();
        ansList.sort((a, b) -> {
            return a - b;
        });
        int[] array = ansList.stream().mapToInt(Integer::intValue).toArray();

        return ans;
    }

    int dfs(int[][] grid, int curI, int curJ) {
        if (curI < 0 || curI > grid.length - 1 || curJ < 0 || curJ > grid[0].length - 1) {
            return 0;
        }
        if (grid[curI][curJ] == 0) {
            return 0;
        }
        // 记得将遍历过位置 置为0
        int ans = grid[curI][curJ];
        grid[curI][curJ] = 0;
        int[][] dirs = new int[][] {
                { 1, 0 },
                { 0, 1 },
                { -1, 0 },
                { 0, -1 }
        };
        for (int i = 0; i < 4; i++) {
            int ii = curI + dirs[i][0];
            int jj = curJ + dirs[i][1];
            ans += dfs(grid, ii, jj);
        }
        return ans;
    }

}
// @lc code=end
