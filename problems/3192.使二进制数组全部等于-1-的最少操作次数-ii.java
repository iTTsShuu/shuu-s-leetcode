/*
 * @lc app=leetcode.cn id=3192 lang=java
 *
 * [3192] 使二进制数组全部等于 1 的最少操作次数 II
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums) {
        // 最优方法依然是从左往右做遍历
        // 判断当前位置是否为1 为0 则必须进行操作
        // 可以将要操作次数+1 在后续的判断中 同时判断当前值加上操作数的奇偶
        // 来判断是否需要操作
        int ans = 0; // 操作数
        for (int x : nums) {
            if ((x + ans) % 2 == 0) { // 需要操作
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end
