/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 丢失的数字
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        // 做一个抵消
        // shuu: 未被抵消的数 即为所求
        int ans = 0;
        for (int i = 0; i <= nums.length; i++) {
            ans += i;
            if (i < nums.length) {
                ans -= nums[i];
            }
        }
        return ans;
    }
}
// @lc code=end
