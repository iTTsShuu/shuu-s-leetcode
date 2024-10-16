/*
 * @lc app=leetcode.cn id=2215 lang=java
 *
 * [2215] 找出两数组的不同
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int n : nums2) {
            set2.add(n);
        }
        for (int n : nums1) {
            set1.add(n);
        }
        for (int n : nums2) {
            set1.remove(n);
        }
        for (int n : nums1) {
            set2.remove(n);
        }

        return List.of(List.copyOf(set1), List.copyOf(set2));
    }
}
// @lc code=end
