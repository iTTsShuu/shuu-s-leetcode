/*
 * @lc app=leetcode.cn id=3191 lang=java
 *
 * [3191] 使二进制数组全部等于 1 的最少操作次数 I
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = 0;
        // shuu:这里的重点其实是 每个位置只操作一次
        // 因为要满足最少的要求：
        for (int i = 0; i < n - 2; i++) {
            // 需要操作
            if (nums[i] == 0) {
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                ans++;
            }
        }
        // 判断最后两个数是否需要处理

        return nums[n - 1] == 1 && nums[n - 2] == 1 ? ans : -1;
    }
}
// @lc code=end
