/*
 * @lc app=leetcode.cn id=1646 lang=java
 *
 * [1646] 获取生成数组中的最大值
 */

// @lc code=start
class Solution {
    public int getMaximumGenerated(int n) {
        // shuu:笑死 直接模拟
        int[] nums = new int[n + 1];
        if (n == 0) {
            return 0;
        }
        nums[0] = 0;
        nums[1] = 1;
        int max = 1;
        for (int i = 2; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[(i - 1) / 2] + nums[(i - 1) / 2 + 1];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
// @lc code=end
