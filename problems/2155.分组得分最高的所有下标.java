/*
 * @lc app=leetcode.cn id=2155 lang=java
 *
 * [2155] 分组得分最高的所有下标
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length;
        // 可以统计前半left的1个数 在第一个一后面 0与1 个数相等则与最大值相等 最大值只可能出现在 01交界点
        // 第一个一一定是得分最高分配方案
        List<Integer> ansList = new ArrayList<>();
        int cnt1 = 0;
        int cnt0 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {

                if (cnt1 == 0) {
                    // 第一次遇到1
                    ansList.add(i);
                }
                cnt1++;

            } else if (cnt1 > 0) { // 出现过1了 开始计算0
                cnt0++;
                if (cnt0>=) {

                }
            }
        }
    }
}
// @lc code=end
