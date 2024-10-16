/*
 * @lc app=leetcode.cn id=2090 lang=java
 *
 * [2090] 半径为 k 的子数组平均值
 */

// @lc code=start

import java.util.Arrays;

class Solution {

    public int[] getAverages(int[] nums, int k) {
        // 写的太答辩 39/40了 其实是没用long

        int l = 0, r = 2 * k;
        int n = nums.length;
        int[] anss = new int[n];
        if (2 * k + 1 > n) {
            for (int i = 0; i < n; i++) {
                anss[i] = -1;
            }
            return anss;
        } else if (k == 0) {
            return Arrays.copyOf(nums, n);
        }
        long sum = 0;
        for (int i = 0; i <= r; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < n; i++) {
            // 下标k-1以前的数半径为 k 的子数组平均值 是 -1
            if (i < k) {
                anss[i] = -1;
            } else if (i > n - k - 1) { // 后半长度不够k
                anss[i] = -1;
            } else {
                anss[i] = (int) sum / (2 * k + 1);
                r++;
                if (r < n) {
                    sum += nums[r];
                    sum -= nums[l];
                    l++;
                }
            }
        }
        return anss;

        // 滑动窗口

        /*
         * int n = nums.length;
         * int[] res = new int[n];
         * Arrays.fill(res, -1);
         * 
         * int l = 0, r = 0;
         * long winSum = 0L;// *注意用long
         * int idx = k;
         * 
         * while (r < n) {
         * // 1、扩大窗口
         * winSum += nums[r];
         * 
         * // 2、缩小窗口
         * if (r - l + 1 > 2 * k + 1) {
         * winSum -= nums[l];
         * l++;
         * }
         * // 3、更新答案
         * if (r - l + 1 == 2 * k + 1) {
         * res[idx++] = (int) (winSum / (2 * k + 1));// 注意转为int
         * }
         * 
         * r++;
         * }
         * return res;
         */

    }
}
// @lc code=end
