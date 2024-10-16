/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        char[] sct = s.toCharArray();
        // 0开头一定无法解析
        if (sct[0] - '0' == 0)
            return 0;

        int n = sct.length;
        char[] sc = new char[n + 1];
        for (int i = 0; i < n; i++) {
            sc[i + 1] = sct[i];
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int j = 2; j <= n; j++) {
            if (sc[j] - '0' == 0) {
                if (sc[j - 1] - '0' == 0 || sc[j - 1] - '0' > 2) {
                    return 0;
                } else {
                    dp[j] = dp[j - 2];
                }
            } else if (sc[j - 1] - '0' > 2) {
                dp[j] = dp[j - 1];
            } else if (sc[j - 1] - '0' == 1) {
                dp[j] = dp[j - 1] + dp[j - 2];
            } else if (sc[j - 1] - '0' == 2) {
                if (sc[j] - '0' > 6) {
                    dp[j] = dp[j - 1];
                } else {
                    dp[j] = dp[j - 1] + dp[j - 2];
                }
            } else {
                dp[j] = dp[j - 1];
            }
        }

        return dp[n];
    }
}

// @lc code=end
class test91 {
    public static void main(String[] args) {
        Solution91 solution91 = new Solution91();
        System.out.println(solution91.numDecodings("2101"));
    }
}