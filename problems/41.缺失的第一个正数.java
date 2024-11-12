/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 原解中做了至负数和零为n+1的操作
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            // 这个方法对原来数组中就是负数和零的数 判断不太友好 会出现错误
            // 因此 原解中做了至负数和零为n+1的操作
            int cur = Math.abs(nums[i]);
            if (cur <= n) {
                nums[cur - 1] = -Math.abs(nums[cur - 1]); // 标记出现过的数的位置
            }
        }
        // 重新遍历数组可以找到标记位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                return i + 1;
        }
        return n + 1;
    }
}
// @lc code=end
