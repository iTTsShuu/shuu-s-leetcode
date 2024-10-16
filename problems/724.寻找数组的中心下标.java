/*
 * @lc app=leetcode.cn id=724 lang=java
 *
 * [724] 寻找数组的中心下标
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0, rightSum = Arrays.stream(nums).sum() - nums[0];
        int mIndex = 0;
        while (mIndex < nums.length && leftSum != rightSum) {
            leftSum += nums[mIndex];
            mIndex++;
            if (mIndex == nums.length) {
                return -1;
            } else {
                rightSum -= nums[mIndex];
            }

        }
        return mIndex;
    }
}
// @lc code=end
