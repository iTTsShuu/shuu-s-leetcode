/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2 的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        // 两种技巧：n & (n - 1)或者 n & (-n)
        // 找到最低位的1
        // 位运算的优先级较低，需要
        // shuu: 两种解决
        // return n > 0 && (n & (n - 1)) == 0;
        return n > 0 && (n & (-n)) == n;
    }
}
// @lc code=end
