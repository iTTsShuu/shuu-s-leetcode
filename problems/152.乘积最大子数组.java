/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        // 用dp数组dp[i][0]标识以i为子串尾数字的最大值
        // dp[i][1]标识以i为子串尾数字的最小值
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            // 分当前数大于零和小于零进行计算
            if (num > 0) {
                // 注意到当前>0 最大值在num和num*dp[i-1][0]中取
                dp[i][0] = Math.max(dp[i - 1][0] * num, num);
                dp[i][1] = Math.min(dp[i - 1][1] * num, num);
            } else if (num <= 0) {
                // 同理思考当前<0
                dp[i][0] = Math.max(dp[i - 1][1] * num, num);
                dp[i][1] = Math.min(dp[i - 1][0] * num, num);
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dp[i][0]);
        }
        return ans;
    }
}
// @lc code=end
