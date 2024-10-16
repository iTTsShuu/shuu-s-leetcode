/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> partitionLabels(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        int start = 0, end = 0;
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(chs[i], i);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            end = Math.max(end, indexMap.get(chs[i]));
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }
}
// @lc code=end
