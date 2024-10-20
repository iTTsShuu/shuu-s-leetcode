/*
 * @lc app=leetcode.cn id=908 lang=java
 *
 * [908] 最小差值 I
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int smallestRangeI(int[] nums, int k) {
        // 先想到 堆+哈希表 贪心的在最大值和最小值上加-k到k
        // 然后想到数学 遂看解题
        // CV之
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        return max - min > 2 * k ? max - min - 2 * k : 0;
    }
}
// @lc code=end
