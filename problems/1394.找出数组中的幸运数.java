/*
 * @lc app=leetcode.cn id=1394 lang=java
 *
 * [1394] 找出数组中的幸运数
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey(), value = entry.getValue();
            if (Objects.equals(key, value)) {
                ans = Math.max(ans, key);
            }
        }
        return ans;
    }
}
// @lc code=end
