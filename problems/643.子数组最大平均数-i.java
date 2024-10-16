/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }

        int l = 0, r = k;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double maxSum = sum;
        while (r < nums.length) {
            sum += nums[r];

            sum -= nums[l];

            maxSum = Math.max(maxSum, sum);
            r++;
            l++;
        }
        return 1.0 * maxSum / k;
    }
}
// @lc code=end
