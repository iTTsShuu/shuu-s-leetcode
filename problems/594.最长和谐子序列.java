/*
 * @lc app=leetcode.cn id=594 lang=java
 *
 * [594] 最长和谐子序列
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLHS(int[] nums) {
        // 第一想法 哈希计数
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int max = 0;
        for (Integer i : map.keySet()) {
            if (map.containsKey(i - 1)) {
                max = Math.max(max, map.get(i - 1) + map.get(i));
            }
            if (map.containsKey(i + 1)) {
                max = Math.max(max, map.get(i + 1) + map.get(i));
            }
        }
        return max;
        // shuu: 看解题有很多人都在考虑dp 我看来属于是复杂题 做多了
        // shuu: 这里应该首先想到的是 与顺序无关 只关心出现次数

    }
}
// @lc code=end
