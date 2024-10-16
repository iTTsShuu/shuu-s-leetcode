/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        // 枚举
        /*
         * int ans = 0;
         * for (int i = 0; i < nums.length; i++) {
         * int sum = 0;
         * for (int j = i; j < nums.length; j++) {
         * sum += nums[j];
         * if (sum == k) {
         * ans++;
         * }
         * }
         * }
         * return ans;
         */
        // 前缀和+哈希表遍历
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        // 加入初始和0
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
// @lc code=end
