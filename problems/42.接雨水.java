/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        // TODO 待完成
        // shuu:要动态规划，还没搞定！！！
        // shuu: 特殊情况
        // 小于长度3时 一定接0
        if (height.length < 3) {
            return 0;
        }

        int l = 0, r = 0;
        int ans = 0;

        while (l < height.length && r < height.length) {

            int curCap = 0;
            int curMin = Math.min(height[r], height[l]);
            int curMax = Math.max(height[r], height[l]);
            while (r < height.length && height[r] < curMin) {
                curCap += height[r];
                r++;
            }
            // 结束循环时 找到一个杯
            ans += (r - l - 1) * curMin - curCap;
            // 移动l
            l = r;
        }
        return ans;
    }
}
// @lc code=end
