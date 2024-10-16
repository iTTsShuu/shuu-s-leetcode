/*
 * @lc app=leetcode.cn id=712 lang=java
 *
 * [712] 两个字符串的最小ASCII删除和
 */

// @lc code=start

import java.util.Arrays;

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
                // if (ss1[i - 1] == ss2[j - 1]) {
                // dp[i][j] = dp[i - 1][j - 1];
                // } else {
                // 当前两字母不相等的情况下 取最小值
                // dp[i][j] = Math.min(dp[i - 1][j] + ss1[i - 1], dp[i][j - 1] + ss2[j - 1]);
                // }

                // shuu:一句话模式：三目运算符
                dp[i][j] = ss1[i - 1] == ss2[j - 1] ? dp[i - 1][j - 1]
                        : Math.min(dp[i - 1][j] + ss1[i - 1], dp[i][j - 1] + ss2[j - 1]);
            }
        }
        // 搜索完毕后返回答案
        return dp[m][n];
    }

    // 递归
    public int minimumDeleteSum3(String s1, String s2) {
        // shuu: 尝试递归方式完成
        // !但是超时了 但解题应该是正确的
        // shuu: 更新 使用一个数组记录以及计算过的结果 重新记忆化搜索
        // 是的 修改了记忆搜索 成功解决
        int m = s1.length();
        int n = s2.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return dps(s1, m, s2, n, memo);
    }

    int dps(String s1, int is1, String s2, int is2, int[][] memo) {
        if (is1 == 0 && is2 == 0) {
            return memo[0][0] = 0;
        }
        if (is1 == 0) {
            return memo[is1][is2] = dps(s1, is1, s2, is2 - 1, memo) + s2.charAt(is2 - 1);
        }
        if (is2 == 0) {
            return memo[is1][is2] = dps(s1, is1 - 1, s2, is2, memo) + s1.charAt(is1 - 1);
        }
        if (memo[is1][is2] != -1) {
            // 计算过的情况
            return memo[is1][is2];
        }
        if (s1.charAt(is1 - 1) == s2.charAt(is2 - 1)) {
            return memo[is1][is2] = dps(s1, is1 - 1, s2, is2 - 1, memo);
        } else {
            return memo[is1][is2] = Math.min(dps(s1, is1 - 1, s2, is2, memo) + s1.charAt(is1 - 1),
                    dps(s1, is1, s2, is2 - 1, memo) + s2.charAt(is2 - 1));
        }
    }

    // 空间优化尝试
    // 观察到dp[i][j]与dp[i-1][j] dp[i][j-1] dp[i-1][j-1] 相关
    // 滚动数组
    public int minimumDeleteSum(String s1, String s2) {
        // shuu: 记忆化搜索 传统dp
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        int m = ss1.length;
        int n = ss2.length;
        // 记忆化搜索 dp[i][j]表示s1[0:i] s2[o:j] 使两个字符串相等所需删除字符的 ASCII 值的最小和
        // 用两个数组 滚动表示dp[i] 和 dp[i-1]
        int[][] dp = new int[2][n + 1];
        // j=0时 dp[i][0]=dp[i-1][0]+s1[i]
        // for (int i = 1; i <= m; i++) {
        // dp[i % 2][0] = dp[i - 1][0] + ss1[i - 1];
        // }

        // i=0时 dp[0][j]=dp[0][j-1]+s2[j]
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + ss2[j - 1];
        }
        for (int i = 0; i < m; i++) {
            // 关键一步
            // !!!对 dp[i][0]的处理！！！！
            // 这里一步一改 直接封神 抬走下一题
            dp[(i + 1) % 2][0] = dp[i % 2][0] + ss1[i];
            for (int j = 0; j < n; j++) {
                // 当前两字母相等的情况下 没有做删除的必要 dp可不变
                if (ss1[i] == ss2[j]) {
                    dp[(i + 1) % 2][j + 1] = dp[i % 2][j];
                } else {
                    // 当前两字母不相等的情况下 取最小值
                    dp[(i + 1) % 2][j + 1] = Math.min(dp[i % 2][j + 1] + ss1[i], dp[(i + 1) % 2][j] + ss2[j]);
                }

                // shuu:一句话模式：三目运算符
                // 出现覆盖
                // dp[(i + 1) % 2][j + 1] = ss1[i] == ss2[j] ? dp[i % 2][j]
                // : Math.min(dp[i % 2][j + 1] + ss1[i], dp[(i + 1) % 2][j] + ss2[j]);
            }
        }
        // 搜索完毕后返回答案
        return dp[m % 2][n];
    }
}
// @lc code=end
