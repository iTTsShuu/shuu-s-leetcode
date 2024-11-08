/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 这个方法对原来数组中就是负数和零的数 判断不太友好 会出现错误
            int cur = Math.abs(nums[i]);
            if (nums[i] > 0) {
                nums[cur - 1] = -Math.abs(nums[cur - 1]); // 标记出现过的数的位置
            } else if (nums[i] < 0) {
                nums[-nums[i]] = -nums[nums[i]];
            }
        }
    }
}
// @lc code=end
