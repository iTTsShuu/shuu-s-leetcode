/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
class Solution {
    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            // 与运算&的结果不为0说明当前位为1
            if ((n & (1 << i)) != 0) {
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end
