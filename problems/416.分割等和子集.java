
/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start

import java.util.Arrays;
import java.util.Map;

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        if (sum % 2 == 1) {
            return false;
        }
        // shuu:问题转化为 求是否有子集的和为sum/2
        sum /= 2;
        // dp[x][y] 表示前x个数 能否和为y
        boolean[][] dp = new boolean[n + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            for (int j = 0; j <= sum; j++) {
                // shuu:这里判断dp[i][j - cur]和dp[i][j]
                dp[i + 1][j] = j >= cur && dp[i][j - cur] || dp[i][j];
            }
            // 找到一个答案即可返回
            if (dp[i + 1][sum])
                return true;
        }
        return false;
    }
}
// @lc code=end
