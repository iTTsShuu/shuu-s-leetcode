/*
 * @lc app=leetcode.cn id=2293 lang=java
 *
 * [2293] 极大极小游戏
 */

// @lc code=start

class Solution {
    public int minMaxGame(int[] nums) {
        while (nums.length != 1) {
            int[] newN = new int[nums.length / 2];
            for (int i = 0; i < newN.length; i++) {
                if (i % 2 == 0) {
                    newN[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    newN[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            nums = newN;
        }
        return nums[0];
    }
}
// @lc code=end
