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
    public List<Integer> findAnagrams1(String s, String p) {
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
        // 统计p字符串
        for (int i = 0; i <= lens - lenp; i++) {
            char ch = s.charAt(i);
            if (map[ch - 'a'] > 0) { // 暴力匹配了所有的字符开头的定长窗口
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

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int lens = s.length(), lenp = p.length();
        // 特殊情况
        if (lens < lenp) {
            return list;
        }
        // Map<Character, Integer> map = new HashMap();
        // 统计p字符串
        // 不暴力匹配了所有的字符开头的定长窗口
        // 而是滑动窗口的思想对mapTmp做修改 //还是定长滑动窗口的思想
        int[] map = new int[26];
        int[] mapTmp = new int[26];
        for (int i = 0; i < lenp; i++) {
            map[p.charAt(i) - 'a']++;
            mapTmp[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(map, mapTmp)) {
            list.add(0);
        }
        for (int i = lenp; i < lens; i++) {
            char chead = s.charAt(i);
            char ctail = s.charAt(i - lenp);
            // 移除头部
            mapTmp[ctail - 'a']--;
            // 增加尾部
            mapTmp[chead - 'a']++;
            if (Arrays.equals(map, mapTmp)) {
                list.add(i - lenp + 1);
            }
        }
        return list;
    }
}
// @lc code=end
