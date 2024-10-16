/*
 * @lc app=leetcode.cn id=712 lang=java
 *
 * [712] 两个字符串的最小ASCII删除和
 */

// @lc code=start
class Solution {
    public int minimumDeleteSum1(String s1, String s2) {
        // shuu: 记忆化搜索 传统dp
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        int m = ss1.length;
        int n = ss2.length;
        // 记忆化搜索 dp[i][j]表示s1[0:i] s2[o:j] 使两个字符串相等所需删除字符的 ASCII 值的最小和
        int[][] dp = new int[m + 1][n + 1];
        // j=0时 dp[i][0]=dp[i-1][0]+s1[i]
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + ss1[i - 1];
        }
        // i=0时 dp[0][j]=dp[0][j-1]+s2[j]
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + ss2[j - 1];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 当前两字母相等的情况下 没有做删除的必要 dp可不变
                if (ss1[i - 1] == ss2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 当前两字母不相等的情况下 取最小值
                    dp[i][j] = Math.min(dp[i - 1][j] + ss1[i - 1], dp[i][j - 1] + ss2[j - 1]);
                }
            }
        }
        // 搜索完毕后返回答案
        return dp[m][n];
    }

    public int minimumDeleteSum(String s1, String s2) {
        // shuu: 尝试递归方式完成
        // !但是超时了 但解题应该是正确的
        return dps(s1, s1.length(), s2, s2.length());
    }

    int dps(String s1, int is1, String s2, int is2) {
        if (is1 == 0 && is2 == 0) {
            return 0;
        }
        if (is1 == 0) {
            return dps(s1, is1, s2, is2 - 1) + s2.charAt(is2 - 1);
        }
        if (is2 == 0) {
            return dps(s1, is1 - 1, s2, is2) + s1.charAt(is1 - 1);
        }
        if (s1.charAt(is1 - 1) == s2.charAt(is2 - 1)) {
            return dps(s1, is1 - 1, s2, is2 - 1);
        } else {
            return Math.min(dps(s1, is1 - 1, s2, is2) + s1.charAt(is1 - 1),
                    dps(s1, is1, s2, is2 - 1) + s2.charAt(is2 - 1));
        }
    }
}
// @lc code=end
