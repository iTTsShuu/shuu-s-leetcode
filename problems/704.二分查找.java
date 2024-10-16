/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start

import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

// @lc code=end
class test704 {
    public static void main(String[] args) {
        int[] nums = new int[] {
                -1, 0, 3, 5, 9, 12
        };
        Solution704 solution = new Solution704();
        System.out.println(solution.search(nums, 2));
    }
}