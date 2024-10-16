/*
 * @lc app=leetcode.cn id=1679 lang=java
 *
 * [1679] K 和数对的最大数目
 */

// @lc code=start

import java.util.HashMap;

class Solution {
    public int maxOperations(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int c = map.getOrDefault(k - nums[i], 0);
            if (c > 0) {
                map.put(k - nums[i], c - 1);
                ans++;
            } else {
                map.merge(nums[i], 1, Integer::sum);
            }
        }
        return ans;
    }
}
// @lc code=end
