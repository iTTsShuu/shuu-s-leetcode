/*
 * @lc app=leetcode.cn id=2160 lang=java
 *
 * [2160] 拆分数位后四位数字的最小和
 */

// @lc code=start
class Solution {
    public int minimumSum(int num) {
        int[] nums = new int[4];
        int min = 10, preMin = 10;
        for (int i = 0; i < 4; i++) {
            int x = num % 10;
            nums[i] = x;
            if (x < min) {
                preMin = min;
                min = x;
            } else if (x < preMin) {
                preMin = x;
            }
            num /= 10;
        }
        // 构造答案
        int ans = min * 9 + preMin * 9;
        for (int i = 0; i < 4; i++) {
            ans += nums[i];
        }
        return ans;
    }
}
// @lc code=end
