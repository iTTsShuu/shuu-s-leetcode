/*
 * @lc app=leetcode.cn id=2140 lang=java
 *
 * [2140] 解决智力问题
 */

// @lc code=start
class Solution {
    public long mostPoints(int[][] questions) {
        int i = 0, n = questions.length;
        long[] dp = new long[n + 1];
        while (i < n) {
            int point = questions[i][0];
            int skip = questions[i][1];
            // 解决当前
            if (i + skip + 1 < n) {
                dp[i + 1 + skip] = Math.max(dp[i + skip + 1], dp[i] + point);
            } else {
                dp[n] = Math.max(dp[n], dp[i] + point);
            }
            // 不解决当前
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            i++;
        }
        return dp[n];
    }
}
// @lc code=end
