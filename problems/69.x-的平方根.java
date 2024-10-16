/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x;
        int ans = -1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if ((long) m * m <= x) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
}
// @lc code=end
