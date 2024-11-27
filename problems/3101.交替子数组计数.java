/*
 * @lc app=leetcode.cn id=3101 lang=java
 *
 * [3101] 交替子数组计数
 */

// @lc code=start
class Solution {
    // 通过计算以下标i结尾的子数组中交替数组的数量
    // 累加得到答案
    public long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        int cnt = 1;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] != nums[i - 1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            ans += cnt;
        }
        return ans;
    }
}
// @lc code=end
