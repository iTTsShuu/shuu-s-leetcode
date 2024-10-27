/*
 * @lc app=leetcode.cn id=673 lang=java
 *
 * [673] 最长递增子序列的个数
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        // dp[i]表示以下标i结尾的最长子序列长度
        int[] dp = new int[n];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return ans;
    }
}
// @lc code=end
