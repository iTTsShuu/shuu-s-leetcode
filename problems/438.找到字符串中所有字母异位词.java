/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int lens = s.length(), lenp = p.length();
        if (lens < lenp) {
            return list;
        }
        // Map<Character, Integer> map = new HashMap();
        int[] map = new int[26];
        for (int i = 0; i < p.length(); i++) {
            map[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= lens - lenp; i++) {
            char ch = s.charAt(i);
            if (map[ch - 'a'] > 0) {
                // Map<Character, Integer> mapTmp = new HashMap();
                int[] mapTmp = new int[26];
                for (int j = 0; j < lenp; j++) {
                    char chTmp = s.charAt(i + j);
                    if (map[chTmp - 'a'] > 0) {
                        mapTmp[chTmp - 'a']++;
                    }
                }
                if (Arrays.equals(map, mapTmp)) {
                    list.add(i);
                }
            }
        }
        return list;
    }
}
// @lc code=end
