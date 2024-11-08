/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        // 额外数组
        /*
         * int n = nums.length;
         * int left = 0, right = 0;
         * int[] numsTmp = new int[n];
         * for (int i = 0; i < n; i++) {
         * numsTmp[i] = nums[i];
         * }
         * int count = 0;
         * for (int i = 0; i < n; i++) {
         * if (numsTmp[i] != 0) {
         * nums[left] = numsTmp[i];
         * left++;
         * }
         * }
         * for (int i = left; i < n; i++) {
         * nums[i] = 0;
         * }
         */

        // 双指针
        // for (int i = 0, j = 0; i < nums.length; i++) {
        // if (nums[j] == 0) {
        // if (nums[i] != 0) {
        // swap(i, j, nums);
        // j++;
        // }
        // } else {
        // j++;
        // }
        // }

        // 双指针更易理解版
        int l = 0, r = 0;
        // l标识已处理的序列末尾 r标识未处理的序列开头
        while (r < nums.length) {
            if (nums[l] == 0) {
                if (nums[r] != 0) {
                    swap(l, r, nums);
                    l++;
                }
            } else {
                l++;
            }
            r++;
        }
    }

    public void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
// @lc code=end
