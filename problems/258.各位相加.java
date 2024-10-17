/*
 * @lc app=leetcode.cn id=258 lang=java
 *
 * [258] 各位相加
 */

// @lc code=start
class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            int yu = num % 10;
            num /= 10;
            num += yu;
        }
        return num;
    }
}
// @lc code=end
