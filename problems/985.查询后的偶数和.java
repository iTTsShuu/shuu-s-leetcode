/*
 * @lc app=leetcode.cn id=985 lang=java
 *
 * [985] 查询后的偶数和
 */

// @lc code=start

class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = queries.length;
        int sum = 0;
        for (int x : nums) {
            if (x % 2 == 0) {
                sum += x;
            }
        }
        int[] ans = new int[n];
        int index = 0;
        for (int[] query : queries) {
            if (nums[query[1]] % 2 == 0) {
                sum -= nums[query[1]];
            }
            nums[query[1]] += query[0];
            if (nums[query[1]] % 2 == 0) {
                sum += nums[query[1]];
            }
            ans[index++] = sum;
        }
        return ans;
    }
}
// @lc code=end
