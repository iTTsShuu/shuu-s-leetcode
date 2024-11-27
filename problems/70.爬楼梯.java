/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        // 动态规划 + 滑动数组
        int x = 1, y = 1, ans = 1;
        for (int i = 0; i < n - 1; i++) {
            x = y;
            y = ans;
            ans = x + y;
        }
        return ans;
    }
}
// @lc code=end
