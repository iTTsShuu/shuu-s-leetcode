/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int depth = triangle.get(triangle.size() - 1).size();
        int[][] dp = new int[triangle.size()][depth];
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> tempL = triangle.get(i);
            for (int j = 0; j < tempL.size(); j++) {

                if (i >= 1 && j >= 1 && j < tempL.size() - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + tempL.get(j);
                } else if (i == 0) {
                    dp[i][j] = tempL.get(j);
                } else if (i >= 1 && j == 0) {
                    dp[i][0] = dp[i - 1][0] + tempL.get(0);
                } else if (j == tempL.size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + tempL.get(j);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.get(depth - 1).size(); i++) {
            ans = Math.min(ans, dp[depth - 1][i]);
        }

        return ans;
    }
}
// @lc code=end

class tete {
    public static void main(String[] args) {
        mySolution solution = new mySolution();
        List<List<Integer>> triangle = new ArrayList<List<Integer>>() {
            {
                add(Arrays.asList(new Integer[] { 2 }));
                add(Arrays.asList(new Integer[] { 3, 4 }));
                add(Arrays.asList(new Integer[] { 6, 5, 7 }));
                add(Arrays.asList(new Integer[] { 4, 1, 8, 3 }));
            }

        };
        System.out.println(solution.minimumTotal(triangle));
    }
}