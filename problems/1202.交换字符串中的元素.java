/*
 * @lc app=leetcode.cn id=1202 lang=java
 *
 * [1202] 交换字符串中的元素
 */

// @lc code=start

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // 想法1 ：排序pairs 有相同交换位置的pairs可以从大到小排序这些位置上的字母
        // 或者说叫标记每个位置所有可以交换的位置 然后从第一位开始选择最小的 可以
        Map<Integer, List<Integer>> map = new HashMap<>();

        return "s";
    }
}
// @lc code=end
