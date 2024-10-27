/*
 * @lc app=leetcode.cn id=693 lang=java
 *
 * [693] 交替位二进制数
 */

// @lc code=start
class Solution {
    public boolean hasAlternatingBits(int n) {
        n = n ^ (n >> 1);
        return (n & (n + 1)) == 0;
    }
}
// @lc code=end
