/*
 * @lc app=leetcode.cn id=2876 lang=java
 *
 * [2876] 有向图访问计数
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] countVisitedNodes(List<Integer> edges) {
        List<Integer> ans = new ArrayList<>();
        int size = edges.size();
        for (int i = 0; i < size; i++) {
            Set<Integer> set = new HashSet<>();
            Integer temp = edges.get(i);

        }
    }
}
// @lc code=end
