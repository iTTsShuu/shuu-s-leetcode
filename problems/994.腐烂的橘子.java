/*
 * @lc app=leetcode.cn id=994 lang=java
 *
 * [994] 腐烂的橘子
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    // 广度优先 借助 队列的写法
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        int cnt1 = 0; // 新鲜橘子计数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    cnt1++;
                } else if (grid[i][j] == 2) {
                    queue.push(new int[] { i, j });
                }
            }
        }
        int minutes = 0;
        int[][] dirs = new int[][] {
                { 1, 0 },
                { 0, 1 },
                { -1, 0 },
                { 0, -1 }
        };
        // 广度优先搜索
        while (!queue.isEmpty() && cnt1 > 0) { // cnt1>0的判断也很重要
            minutes++;
            int len = queue.size();
            // 遍历当前层
            for (int i = 0; i < len; i++) {
                int[] cur = queue.poll();
                int curX = cur[0], curY = cur[1];
                // 感染四个方向
                for (int j = 0; j < 4; j++) {
                    curX += dirs[j][0];
                    curY += dirs[j][1];
                    if (curX >= 0 && curX < m && curY >= 0 && curY < n && grid[curX][curY] == 1) {
                        cnt1--;// 感染橘子数减
                        queue.add(new int[] { curX, curY });
                        // 传染
                        grid[curX][curY] = 2;
                    }
                    curX -= dirs[j][0];
                    curY -= dirs[j][1];
                }
            }
        }

        return cnt1 > 0 ? -1 : minutes;
    }
}
// @lc code=end
