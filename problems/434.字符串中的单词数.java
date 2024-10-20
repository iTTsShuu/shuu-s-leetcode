/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 */

// @lc code=start
class Solution {
    public int countSegments(String s) {
        if (s == null || s.trim().isEmpty() || s.equals("")) {
            return 0;
        }
        String[] split = s.trim().split("\\s+");
        return split.length;
    }
}
// @lc code=end
