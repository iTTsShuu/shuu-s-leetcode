/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp[i]表示以下标i的元素结尾的最长递增子序列
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
// @lc code=end
