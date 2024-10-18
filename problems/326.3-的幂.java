/*
 * @lc app=leetcode.cn id=326 lang=java
 *
 * [326] 3 的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfThree(int n) {
        // shuu:试除法
        // while (n != 0 && n % 3 == 0) {
        // n /= 3;
        // }
        // return n == 1;
        // 判断是否是整数最大3幂的除数
        return n > 0 && 1162261467 % n == 0;
    }
}
// @lc code=end
