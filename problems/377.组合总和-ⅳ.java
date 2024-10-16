/*
 * @lc app=leetcode.cn id=377 lang=java
 *
 * [377] 组合总和 Ⅳ
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int combinationSum4(int[] nums, int target) {
        // 动态规划递推
        // int[] dp = new int[target + 1];
        // dp[0] = 1;
        // for (int i = 1; i <= target; i++) {
        // for (int x : nums) {
        // if (x <= i) {
        // dp[i] = dp[i] + dp[i - x];
        // }
        // }
        // }
        // return dp[target];

        // shuu:
        // 递归写法 同样是动态规划思想
        int n = nums.length;
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return dfs(target, nums, memo);
    }

    int dfs(int i, int[] nums, int[] memo) {
        // 刚好为target
        if (i == 0) {
            return 1;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int ans = 0;
        // 枚举每次减去nums[],既是每次下x台阶
        for (int x : nums) {
            if (i >= x) {
                ans += dfs(i - x, nums, memo);
            }
        }
        // 记录当前结果
        memo[i] = ans;
        return ans;
    }
}
// @lc code=end
