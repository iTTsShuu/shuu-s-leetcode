/*
 * @lc app=leetcode.cn id=2217 lang=java
 *
 * [2217] 找到指定长度的回文数
 */

// @lc code=start
class Solution {
    // 对折方法
    // 先求回文的一半 我直接一个对折
    public long[] kthPalindrome(int[] queries, int intLength) {
        int len = (intLength + 1) / 2; // 向上取整求 初始 半长
        long orign = (long) Math.pow(10, len - 1);
        int n = queries.length;
        long[] ans = new long[n];
        boolean isOdd = intLength % 2 != 0;
        for (int i = 0; i < n; i++) {
            if (queries[i] > orign * 9) { // 除去非法数字 我直接让他丨出去
                ans[i] = -1;
                continue;
            }
            // 先计算半边
            long half = orign + queries[i] - 1;
            long cur = half;
            // 我直接一个对折
            if (isOdd) { // 奇数长
                while (half > 9) {
                    cur *= 10;
                    half /= 10;
                    cur += half % 10;
                }
            } else { // 偶数长
                while (half > 0) {
                    cur *= 10;
                    cur += half % 10;
                    half /= 10;
                }
            }
            ans[i] = cur;
        }
        return ans;
    }
}
// @lc code=end
