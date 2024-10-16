/*
 * @lc app=leetcode.cn id=3297 lang=java
 *
 * [3297] 统计重新排列后包含另一个字符串的子字符串数目 I
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public long validSubstringCount(String S, String T) {
        if (S.length() < T.length()) {
            return 0;
        }

        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int[] cnt = new int[26]; // t 的字母出现次数与 s 的字母出现次数之差
        for (char b : t) {
            cnt[b - 'a']++;
        }
        // 窗口长度
        int windowLen = 0;
        // 统计窗口内有多少个字母的出现次数比 t 的少
        int less = 0;
        for (int c : cnt) {
            if (c > 0) {
                less++;
            }
        }
        long ans = 0;
        int left = 0;
        for (char b : s) {
            if (--cnt[b - 'a'] == 0) {
                // 窗口内 b 的出现次数和 t 一样
                windowLen++;
            }
            while (windowLen == less) { // 窗口符合要求
                if (cnt[s[left++] - 'a']++ == 0) {
                    // s[left] 移出窗口后，窗口内 s[left] 的出现次数比 t 的少
                    windowLen--;
                }
            }
            ans += left;
        }
        return ans;
    }

    public long validSubstringCount2(String word1, String word2) {

        char[] chs2 = word2.toCharArray(), chs1 = word1.toCharArray();
        int[] map = new int[26];
        for (int i = 0; i < chs2.length; i++) {
            char ch = chs2[i];
            map[ch - 'a']++;
        }
        long ans = 0;
        for (int i = 0; i < chs1.length - chs2.length + 1; i++) {
            int[] tmpMap = new int[26];
            int j = i;
            // 以字符串1的每个字符为串首构造子串
            while (j < chs1.length) {
                char tmpch = chs1[j];
                tmpMap[tmpch - 'a']++;
                if (j - i < chs2.length - 1) {
                    j++;
                    continue;
                }
                // 比较当前map
                if (checkBigger(tmpMap, map)) {
                    ans += (chs1.length - j);
                    break;
                }
                j++;
            }
        }
        return ans;
    }

    // 比较的函数
    public boolean checkBigger(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (b[i] > 0 && b[i] > a[i]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
