/*
 * @lc app=leetcode.cn id=3226 lang=java
 *
 * [3226] 使两个整数相等的位更改次数
 */

// @lc code=start
class Solution {
    public int minChanges(int n, int k) {
        // 只可以改n二进制为1的位
        if (k > n) {
            return -1; // k>n情况一定不能做到
        } else if (k == n) {
            return 0;
        } else if ((n & k) == k) { // k是n的子集
            return Integer.bitCount(n ^ k);
        } else {
            return -1;
        }
    }
}
// @lc code=end
