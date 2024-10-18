/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        List<Integer> ansSet = new ArrayList<>();
        for (Integer x : nums2) {
            if (set1.contains(x) && !ansSet.contains(x)) {
                ansSet.add(x);
            }
        }
        // shuu:流式编程
        return ansSet.stream().mapToInt(Integer::intValue).toArray();
        // return ansSet.toArray(new Integer[ansSet.size()]);

    }
}
// @lc code=end
