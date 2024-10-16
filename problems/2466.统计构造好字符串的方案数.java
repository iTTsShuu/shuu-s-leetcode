/*
 * @lc app=leetcode.cn id=2466 lang=java
 *
 * [2466] 统计构造好字符串的方案数
 */

// @lc code=start

class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        final int MOD = 1_000_000_007;
        int[] dp = new int[high + 1];
        dp[0] = 1;
        int ans = 0;
        // 长度为i的方案数 dp[i]=dp[i-zero]+dp[i-one]
        for (int i = 1; i <= high; i++) {

            if (i >= zero && i >= one) {
                dp[i] = (dp[i - zero] + dp[i - one]) % MOD;
            } else if (i >= zero) {
                dp[i] = dp[i - zero];
            } else if (i >= one) {
                dp[i] = dp[i - one];
            }

            if (i >= low) {
                ans = (ans + dp[i]) % MOD;
            }
        }
        return ans;
    }
}

// @lc code=end
class test2466 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}