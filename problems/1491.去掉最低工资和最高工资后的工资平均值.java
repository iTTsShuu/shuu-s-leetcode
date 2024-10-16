/*
 * @lc app=leetcode.cn id=1491 lang=java
 *
 * [1491] 去掉最低工资和最高工资后的工资平均值
 */

// @lc code=start
class Solution {
    public double average(int[] salary) {
        int max=0,min=Integer.MAX_VALUE;
        double som=0;
        for (int i : salary) {
            som+=i;
            max=Math.max(max, i);
            min=Math.min(i, min);
        }
        som-=max;
        som-=min;
        return som/(salary.length-2);
    }
}
// @lc code=end

