/*
 * @lc app=leetcode.cn id=646 lang=java
 *
 * [646] 最长数对链
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> {
            return a[0] - b[0];
        });
        int[] dp = new int[pairs.length + 1];
        Arrays.fill(dp, 1);
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int ans = 0;
        for (int i : dp) {
            ans = ans < i ? i : ans;
        }
        return ans;

    }
}
// @lc code=end

class test646 {
    public static void main(String[] args) {
        Solution646 solution = new Solution646();
        int[][] pairs = {
                { 2, 3 },
                { 3, 4 },
                { 1, 2 }

        };
        solution.findLongestChain(pairs);
    }
}