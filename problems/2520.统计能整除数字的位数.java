/*
 * @lc app=leetcode.cn id=2520 lang=java
 *
 * [2520] 统计能整除数字的位数
 */

// @lc code=start
class Solution {
    public int countDigits(int num) {
        // 模拟
        int ans = 0;
        int n = num;
        while (n != 0) {
            if (num % (n % 10) == 0) {
                ans++;
            }
            n /= 10;
        }
        return ans;
    }
}
// @lc code=end
