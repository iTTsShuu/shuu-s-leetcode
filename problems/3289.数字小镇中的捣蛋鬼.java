/*
 * @lc app=leetcode.cn id=3289 lang=java
 *
 * [3289] 数字小镇中的捣蛋鬼
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int[] ans = new int[2];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (!set.add(nums[i])) {
                ans[k++] = nums[i];
            }
        }
        return ans;
    }
}
// @lc code=end
