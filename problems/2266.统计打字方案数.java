/*
 * @lc app=leetcode.cn id=2266 lang=java
 *
 * [2266] 统计打字方案数
 */

// @lc code=start
class Solution {

    public int countTexts(String pressedKeys) {
        //TODO 有一些思考难度
        int MOD = 1_000_000_009;
        char[] chs = pressedKeys.toCharArray();
        int n = chs.length; // 按键数量
        int ans = 1;
        int[] do=new int[n+1];
    }

    // !! WRONG !!
    public int countTexts1(String pressedKeys) {
        int MOD = 1_000_000_009;
        char[] chs = pressedKeys.toCharArray();
        int n = chs.length; // 按键数量
        // dp[i] 为前i个按键的可能信息数
        // shuu: 思路;
        // chs[i-1]!=chs[i-2]时 dp[i]=dp[i-1];
        // chs[i-1]==chs[i-2]时 dp[i]=dp[i-1]*dp[i-2];
        // 思路其实不够完善
        // !!!! Wrong!
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (chs[i - 1] == chs[i - 2]) {
                dp[i] = (dp[i - 1] * dp[i - 2]) % MOD;
            } else {
                dp[i] = dp[i - 1] % MOD;
            }
        }
        return dp[n] % MOD;
    }
}
// @lc code=end
