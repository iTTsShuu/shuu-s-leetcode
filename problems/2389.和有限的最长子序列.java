/*
 * @lc app=leetcode.cn id=2389 lang=java
 *
 * [2389] 和有限的最长子序列
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length, m = queries.length;
        int[] ans = new int[m];
        int[] sums = new int[n + 1];
        sums[0] = 0;
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < m; i++) {
            int query = queries[i];
            int searchI = banerySearch(query, sums);
            ans[i] = searchI;
        }
        return ans;
    }

    int banerySearch(int target, int[] sums) {
        int l = 1;
        int r = sums.length - 1;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (sums[m] == target) {
                return m;
            } else if (sums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
}
// @lc code=end
