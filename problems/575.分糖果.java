/*
 * @lc app=leetcode.cn id=575 lang=java
 *
 * [575] 分糖果
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        Set<Integer> set = new HashSet<>();
        for (int x : candyType) {
            set.add(x);
        }
        return set.size() >= n / 2 ? n / 2 : set.size();
    }
}
// @lc code=end
