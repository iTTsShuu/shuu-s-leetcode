/*
 * @lc app=leetcode.cn id=263 lang=java
 *
 * [263] 丑数
 */

// @lc code=start
class Solution {
    public boolean isUgly(int n) {
        // shuu:当 n>0 时，若 n 是丑数，
        // 则 n 可以写成 2 3 5 的 a b c 次幂 和的形式
        // 其中 a,b,c 都是非负整数。特别地，当 a,b,c 都是 0 时，n=1
        // 可以对 n 反复除以 2,3,5直到 n 不再包含质因数 2,3,5。
        // 若剩下的数等于 1，则说明 n 不包含其他质因数，是丑数；
        // 否则，说明 n 包含其他质因数，不是丑数。
        if (n <= 0) {
            return false;
        }
        int[] factors = { 2, 3, 5 };
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}
// @lc code=end
