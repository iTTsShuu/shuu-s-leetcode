/*
 * @lc app=leetcode.cn id=1332 lang=java
 *
 * [1332] 删除回文子序列
 */

// @lc code=start
class Solution {
    public int removePalindromeSub(String s) {
        // shuu:是的 子序列 是的 两个字母 是的 最多删两次 是的 直接判断是不是回文就完几把事了
        // 煞笔！
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                // 不是回文直接返回2 最多删两次
                return 2;
            }
        }
        // 是回文串 删一次
        return 1;
    }
}
// @lc code=end
