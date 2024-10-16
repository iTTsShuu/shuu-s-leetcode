/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String ss : strs) {
            char[] charArray = ss.toCharArray();
            // 对字符串进行排序
            Arrays.sort(charArray);
            if (map.containsKey(String.valueOf(charArray))) {
                map.get(String.valueOf(charArray)).add(ss);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(ss);
                map.put(String.valueOf(charArray), list);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
// @lc code=end

class trues {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> lists = solution.groupAnagrams(strs);
        for (List<String> list : lists) {
            for (String ss : list) {
                System.out.print(ss + " ");
            }
        }
    }
}