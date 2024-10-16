/*
 * @lc app=leetcode.cn id=2390 lang=java
 *
 * [2390] 从字符串中移除星号
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String removeStars(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (ch != '*') {
                sb.append(ch);
            } else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
// @lc code=end
