/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容�?
 */

// @lc code=start
class Solution {
    public int maxArea1(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            // 什么乱拿吗
            if (height[left] < height[right]) {
                left++;

            } else {
                right--;
            }
        }
        return max;
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            // 什么乱拿吗
            if (height[left] < height[right]) {
                int tmp = left + 1;
                while (tmp < right && height[tmp] <= height[left]) { // 跳过更小值
                    tmp++;
                }
                left = tmp;

            } else {
                int tmp = right - 1;
                while (tmp > left && height[tmp] <= height[right]) { // 跳过更小值
                    tmp--;
                }
                right = tmp;
            }
        }
        return max;
    }
}
// @lc code=end
