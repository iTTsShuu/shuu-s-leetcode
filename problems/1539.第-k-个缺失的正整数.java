/*
 * @lc app=leetcode.cn id=1539 lang=java
 *
 * [1539] 第 k 个缺失的正整数
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findKthPositive(int[] arr, int k) {
        if (arr[0] > k) {
            return k;
        }
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + r >> 1;
            int curA = arr[m] - m - 1;
            if (curA >= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return arr[l - 1] + k - (arr[l - 1] - l);
    }
}
// @lc code=end
