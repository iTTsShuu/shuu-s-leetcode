/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
