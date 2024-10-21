/*
 * @lc app=leetcode.cn id=1317 lang=java
 *
 * [1317] 将整数转换为两个无零整数的和
 */

// @lc code=start
class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n; i++) {
            // 都不包含0 则为方案直接返回
            if (!containsZero(i) && !containsZero(n - i)) {
                return new int[] { i, n - i };
            }

        }
        return null;
    }

    // 按数位找是否整除10
    boolean containsZero(int n) {
        while (n != 0) {
            if (n % 10 == 0) {
                return true;
            }
            n /= 10;
        }
        return false;
    }
}
// @lc code=end
