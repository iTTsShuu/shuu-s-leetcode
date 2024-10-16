/*
 * @lc app=leetcode.cn id=1944 lang=java
 *
 * [1944] 队列中可以看到的人数
 */

// @lc code=start
class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        int left = 0, right = 0;
        // 暴力遍历
        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, heights[j]);
                int min = Math.min(heights[i], heights[j]);
                if (min >= max) {
                    ans[i]++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}

// @lc code=end
class test1944 {

    public static void main(String[] args) {
        Solution1944 solution1944 = new Solution1944();
        int[] heights = { 10, 6, 8, 5, 11, 9 };
        solution1944.canSeePersonsCount(heights);
    }
}