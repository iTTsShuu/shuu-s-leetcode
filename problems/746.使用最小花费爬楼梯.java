import javax.swing.event.AncestorEvent;
import javax.swing.text.html.CSS;

/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int x=0,y=0,spend=0;
        //因为前两层没有意义可以从下标为2层开始。
        for (int i = 2 ; i <= cost.length; i++) {
            spend=Math.min(x+cost[i-2], y+cost[i-1]);
            x=y;
            y=spend;
        }
        return spend;
    }
}
// @lc code=end

