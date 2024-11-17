/*
 * @lc app=leetcode.cn id=2321 lang=java
 *
 * [2321] 拼接数组的最大分数
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    // 暴力一点的解法 应该正确 但是超时
    public int maximumsSplicedArray1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // 注意到 设交换子数组的长度为x 交换子数组长度在n/2以上（x>n/2）时
        // 与交换n-x个相同
        // 只需要求长度1~n/2的子数组的最大值和最小值
        // 求交换前的和
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        int ans = Math.max(sum1, sum2);
        for (int i = 1; i <= n / 2; i++) {
            // 尝试窗口为i的交换
            ans = Math.max(tryWindowSwitch(nums1, nums2, sum1, sum2, i), ans);
        }
        return ans;
    }

    // 尝试长度为k的窗口
    int tryWindowSwitch(int[] nums1, int[] nums2, int sum1, int sum2, int k) {
        int curSum1 = 0, curSum2 = 0;
        int x = 0, y = 0;
        int ans = 0;
        while (y < nums1.length) {
            curSum1 += nums1[y];
            curSum2 += nums2[y];
            if (y - x + 1 == k) {// 固定长度窗口
                ans = Math.max(ans, Math.max(sum1 - curSum1 + curSum2, sum2 - curSum2 + curSum1));
                curSum1 -= nums1[x];
                curSum2 -= nums2[x];
                x++;
            }
            y++;
        }
        return ans;
    }

    // 其实是差值数组的最大子数组和
    // 见灵神解题：https://leetcode.cn/problems/maximum-score-of-spliced-array/solutions/1626030/by-endlesscheng-fm8l/
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        return Math.max(sum1 + diffMax(nums2, nums1), sum2 + diffMax(nums1, nums2));
    }

    int diffMax(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] diff = new int[nums1.length];
        for (int i = 0; i < n; i++) {
            diff[i] = nums1[i] - nums2[i];
        }
        int ans = 0; // 同样最差情况下 子数组和的最大值为0 子数组为空
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            preSum = Math.max(preSum + diff[i], diff[i]);
            ans = Math.max(ans, preSum);
        }
        return ans;
    }
}
// @lc code=end
