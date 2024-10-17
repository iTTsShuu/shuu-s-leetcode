/*
 * @lc app=leetcode.cn id=1035 lang=java
 *
 * [1035] 不相交的线
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int maxUncrossedLines2(int[] nums1, int[] nums2) {
        // dp[i][j] 表示nums1[0:i]和nums[0:j]的最大连线数
        // nums[i]==nums[j]时 dp[i][j]=dp[i-1][j-1]+1
        // 否则 dp[i][j]=Max(dp[i-1][j],dp[i][j-1])

        // shuu: 递归写法
        int m = nums1.length;
        int n = nums2.length;
        int[][] memo = new int[m + 1][n + 1];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return dps(nums1, nums2, m, n, memo);
    }

    int dps(int[] nums1, int[] nums2, int i1, int i2, int[][] memo) {
        // 有空数组 没有可连线
        if (i1 == 0 || i2 == 0) {
            // 记忆化
            return memo[i1][i2] = 0;
        }
        // 返回以及记录的结果
        if (memo[i1][i2] != -1) {
            return memo[i1][i2];
        }
        // nums[i]==nums[j]时 dp[i][j]=dp[i-1][j-1]+1
        if (nums1[i1 - 1] == nums2[i2 - 1]) {
            return memo[i1][i2] = dps(nums1, nums2, i1 - 1, i2 - 1, memo) + 1;
        } // 否则 dp[i][j]=Max(dp[i-1][j],dp[i][j-1])
        return memo[i1][i2] = Math.max(dps(nums1, nums2, i1 - 1, i2, memo),
                dps(nums1, nums2, i1, i2 - 1, memo));

    }

    // 记忆化搜索
    public int maxUncrossedLines1(int[] nums1, int[] nums2) {
        // dp[i][j] 表示nums1[0:i]和nums[0:j]的最大连线数
        // nums[i]==nums[j]时 dp[i][j]=dp[i-1][j-1]+1
        // 否则 dp[i][j]=Max(dp[i-1][j],dp[i][j-1])

        // shuu: 递归写法
        // 超时了 是的 不知道为什么
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[m][n];
    }

    // shuu:单数组空间优化
    // 记忆化搜索
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // dp[i][j] 表示nums1[0:i]和nums[0:j]的最大连线数
        // nums[i]==nums[j]时 dp[i][j]=dp[i-1][j-1]+1
        // 否则 dp[i][j]=Max(dp[i-1][j],dp[i][j-1])

        // shuu: 递归写法
        // 超时了 是的 不知道为什么
        int m = nums1.length;
        int n = nums2.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int pre = 0; // dp[0]重置为0
            for (int j = 0; j < n; j++) {
                int tmp = dp[j + 1];// 记录将被覆盖的值
                if (nums1[i] == nums2[j]) {
                    dp[j + 1] = pre + 1;
                } else {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j]);
                }
                // 更新pre 更新pre=dp[i][j+1]
                pre = tmp;
            }
        }

        return dp[n];
    }

}
// @lc code=end
