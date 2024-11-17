/*
 * @lc app=leetcode.cn id=1170 lang=java
 *
 * [1170] 比较字符串最小字母出现频次
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n = queries.length;
        int[] answer = new int[n];
        int wLen = words.length;
        int[] W = new int[wLen];
        for (int i = 0; i < wLen; i++) {
            W[i] = f(words[i]);
        }
        // 二分查找 将W 进行排序 找到W[i]>f(queries) 的最小i
        Arrays.sort(W);
        for (int i = 0; i < n; i++) {
            int target = f(queries[i]);
            int searchI = binarySearch(W, target);
            if (searchI == wLen - 1 && W[searchI] <= target) {
                answer[i] = 0;
            } else {
                answer[i] = wLen - searchI;
            }
        }
        return answer;
    }

    int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (nums[m] <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }

    int f(String s) { // 统计 s 中最小字母出现的频次
        if (s == null || s.isEmpty()) { // 非空判断
            return -1;
        }
        int[] map = new int[26];
        char minCh = 'z';
        for (char x : s.toCharArray()) {
            minCh = x - 'a' < minCh - 'a' ? x : minCh;
            map[x - 'a']++;
        }
        return map[minCh - 'a'];
    }
}
// @lc code=end
