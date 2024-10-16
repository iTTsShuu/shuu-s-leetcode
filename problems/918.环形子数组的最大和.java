/*
 * @lc app=leetcode.cn id=918 lang=java
 *
 * [918] 环形子数组的最大和
 */

// @lc code=start
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // 拼接暴力遍历 超时！
        // int n = nums.length;
        // int l = 0, r = 0;
        // int sum = 0;
        // int ans = Integer.MIN_VALUE;
        // while (r < 2 * n) {
        // if (r < n) {
        // sum += nums[r];
        // ans = Math.max(ans, sum);
        // r++;
        // } else if (r >= n && r < 2 * n) {
        // int tl = l;
        // int tmpSum = sum;
        // while (tl < r - 1) {
        // tmpSum -= nums[tl % n];
        // ans = Math.max(ans, tmpSum);
        // tl++;
        // }
        // sum += nums[r % n];
        // sum -= nums[l % n];
        // r++;
        // l++;
        // }
        // }
        // return ans;

        // 分别求最大子数组和 和 最小子数组和
        int preMax = 0, preMin = 0;
        int maxSum = Integer.MIN_VALUE, minSum = Integer.MAX_VALUE;
        int sum = 0;
        for (int i : nums) {
            // 分别求最小和最大前缀
            // 求当前数结尾的最大和最小前缀
            preMax = Math.max(preMax + i, i);
            preMin = Math.min(preMin + i, i);
            // 维护最大值和最小值
            maxSum = Math.max(maxSum, preMax);
            minSum = Math.min(minSum, preMin);
            sum += i;
        }
        // 最小子数组为全数组的情况会导致错判断，进行剔除
        return sum == minSum ? maxSum : Math.max(maxSum, sum - minSum);
    }
}

// @lc code=end
class test918 {
    public static void main(String[] args) {
        Solution918 solution918 = new Solution918();
        int[] nums = { -3, -2, -3 };
        System.out.println(solution918.maxSubarraySumCircular(nums));
    }
}