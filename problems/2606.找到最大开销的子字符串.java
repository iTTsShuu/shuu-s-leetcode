/*
 * @lc app=leetcode.cn id=2606 lang=java
 *
 * [2606] 找到最大开销的子字符串
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        Map<Character, Integer> chIndexMap = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            chIndexMap.put(chars.charAt(i), i);
        }
        int maxPre = 0; // 以当前s[i]结尾的子串的最大前缀和
        int ans = 0; // 注意可以取空串 所以最小答案为0
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (chIndexMap.containsKey(ch)) {
                if (maxPre > 0) {
                    maxPre = maxPre + vals[chIndexMap.get(ch)];
                } else {
                    maxPre = vals[chIndexMap.get(ch)];
                }
            } else {
                if (maxPre > 0) {
                    maxPre = maxPre + ch - 'a' + 1;
                } else {
                    maxPre = ch - 'a' + 1;
                }
            }
            // 维护答案最大值
            ans = Math.max(ans, maxPre);
        }
        // 注意可以取空串
        return ans;
    }
}
// @lc code=end
