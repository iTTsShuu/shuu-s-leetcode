/*
 * @lc app=leetcode.cn id=740 lang=java
 *
 * [740] 删除并获得点数
 */

// @lc code=start
class Solution {
    public int deleteAndEarn(int[] nums) {
        // shuu:做过的 代码 没写思路
        int maxVal = 0;
        // 数组最大值
        // 遍历求最大值
        for (int i = 0; i < nums.length; i++) {
            maxVal = Math.max(maxVal, nums[i]);
        }
        int[] soms = new int[maxVal + 1];
        // 选择一个值可以获得的总点数
        for (int val : nums) {
            soms[val] += val;
        }
        // 只有一个值可选
        if (soms.length == 1) {
            return soms[0];
        }
        // shuu: 这里的统计做完之后转换为打家劫舍问题
        // 转换为相邻值取最大值
        int x = soms[0], y = Math.max(soms[0], soms[1]);
        int ans = Math.max(x, y);
        for (int i = 2; i < soms.length; i++) {
            // i与x不相邻 与 y 相邻
            ans = Math.max(x + soms[i], y);
            x = y;
            y = ans;
        }
        return ans;
    }
}
// @lc code=end
