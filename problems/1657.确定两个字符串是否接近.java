/*
 * @lc app=leetcode.cn id=1657 lang=java
 *
 * [1657] 确定两个字符串是否接近
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] count1 = new int[26], count2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            char ch = word1.charAt(i);
            count1[ch - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            char ch = word2.charAt(i);
            count2[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count1[i] == 0 && count2[i] > 0 || count2[i] == 0 && count1[i] > 0) {
                return false;
            }
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        return Arrays.equals(count1, count2);
    }
}
// @lc code=end
