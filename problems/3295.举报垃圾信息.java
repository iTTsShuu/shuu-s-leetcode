/*
 * @lc app=leetcode.cn id=3295 lang=java
 *
 * [3295] 举报垃圾信息
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> set = new HashSet<>(Arrays.asList(bannedWords));
        int cnt = 0;
        for (String s : message) {
            if (set.contains(s)) {
                cnt++;
            }
            if (cnt >= 2) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
