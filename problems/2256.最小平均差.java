/*
 * @lc app=leetcode.cn id=2256 lang=java
 *
 * [2256] 最小平均差
 */

// @lc code=start

class Solution {
    public int minimumAverageDifference(int[] nums) {
        // 前缀和 和 后缀和的共同运用
        int n = nums.length;
        long pre = 0, suf = 0;
        for (int x : nums) {
            suf += x;
        }
        // 遍历维护最小平均差 和 对应下标
        long minAns = Long.MAX_VALUE;
        int minI = 0;
        for (int i = 0; i < n; i++) {
            pre += nums[i];
            suf -= nums[i];
            // 计算平均差
            long diff = i == n - 1 ? pre / n : Math.abs(pre / (i + 1) - suf / (n - i - 1));
            if (diff < minAns) {
                minAns = diff;
                minI = i;
            }
        }
        return minI;
    }
}
// @lc code=end
