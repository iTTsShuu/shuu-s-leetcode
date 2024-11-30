/*
 * @lc app=leetcode.cn id=3223 lang=java
 *
 * [3223] 操作后字符串的最短长度
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int minimumLength(String s) {
        // 计数统计 只跟数量相关 大于3时减2
        int[] map = new int[26];
        for (char ch : s.toCharArray()) {
            map[ch - 'a']++;
            if (map[ch - 'a'] >= 3) {
                map[ch - 'a'] -= 2;
            }
        }
        return Arrays.stream(map).sum();
    }
}
// @lc code=end
