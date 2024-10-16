/*
 * @lc app=leetcode.cn id=2352 lang=java
 *
 * [2352] 相等行列对
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<List<Integer>, Integer> map = new HashMap<>();
        // 遍历每行，记录当前行排列，并记录相同排列出现次数
        for (int i = 0; i < n; i++) {
            List<Integer> curRow = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                curRow.add(grid[i][j]);
            }
            map.put(curRow, map.getOrDefault(curRow, 0) + 1);
        }
        // 遍历每一列计算相等数量
        int ans = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> curColum = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                curColum.add(grid[j][i]);
            }
            if (map.containsKey(curColum)) {
                ans += map.get(curColum);
            }
        }
        return ans;
    }
}
// @lc code=end

class testEqualPairs {
    public static void main(String[] args) {
        mySolution solution = new mySolution();
        int[][] grid = new int[][] {
                { 1, 2, 3 },
                { 2, 2, 3 },
                { 3, 3, 3 }
        };
        System.out.println(solution.equalPairs(grid));
    }
}