/*
 * @lc app=leetcode.cn id=1343 lang=java
 *
 * [1343] 大小为 K 且平均值大于等于阈值的子数组数目
 */

// @lc code=start
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        for (int i = 0; i < k - 1; i++) {
            sum += arr[i];
        }
        int r = k - 1;
        int l = 0;
        int ans = 0;
        while (r < arr.length) {
            sum += arr[r];
            if (sum / k >= threshold) {
                ans++;
            }
            sum -= arr[l];
            l++;
            r++;
        }
        return ans;
    }
}
// @lc code=end
