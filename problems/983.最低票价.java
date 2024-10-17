/*
 * @lc app=leetcode.cn id=983 lang=java
 *
 * [983] 最低票价
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int mincostTickets1(int[] days, int[] costs) {
        // 在第 100 天购买为期 1 天的通行证，接下来需要解决的问题为：1 到 99 天的最小花费。
        // 在第 94 天购买为期 7 天的通行证，接下来需要解决的问题为：1 到 93 天的最小花费。
        // 在第 71 天购买为期 30 天的通行证，接下来需要解决的问题为：1 到 70 天的最小花费。

        // shuu:递归解决方法
        int n = days.length;
        // 改用一个boolean数组储存 减少重复计算
        boolean[] toTravel = new boolean[days[n - 1] + 1];
        // 创建最大日期长度的记忆数组
        int[] memo = new int[days[n - 1] + 1];
        Arrays.fill(memo, -1);
        for (int day : days) {
            toTravel[day] = true;
        }
        return dps(costs, days[n - 1], memo, toTravel);
    }

    // 改用一个boolean数组储存 减少重复计算
    // // 判断日期是否需要旅行的函数
    // boolean containsDay(int[] days, int curDay) {
    // for (int x : days) {
    // if (x == curDay) {
    // return true;
    // }
    // }
    // return false;
    // }

    int dps(int[] costs, int curDay, int[] memo, boolean[] toTravel) {
        if (curDay <= 0) {
            // 第0天没有解决方案
            return memo[0] = 0;
        }
        // 搜索过 直接返回
        if (memo[curDay] != -1) {
            return memo[curDay];
        }
        if (!toTravel[curDay]) {
            return memo[curDay] = dps(costs, curDay - 1, memo, toTravel);
        }
        // 取三种方案的最小值
        return memo[curDay] = Math.min(dps(costs, curDay - 1, memo, toTravel) + costs[0],
                Math.min(dps(costs, curDay - 7, memo, toTravel) + costs[1],
                        dps(costs, curDay - 30, memo, toTravel) + costs[2]));
    }

    // 修改为递推过程
    public int mincostTickets(int[] days, int[] costs) {
        // 在第 100 天购买为期 1 天的通行证，接下来需要解决的问题为：1 到 99 天的最小花费。
        // 在第 94 天购买为期 7 天的通行证，接下来需要解决的问题为：1 到 93 天的最小花费。
        // 在第 71 天购买为期 30 天的通行证，接下来需要解决的问题为：1 到 70 天的最小花费。

        // shuu:递归解决方法
        int n = days.length;
        // 改用一个boolean数组储存 减少重复计算
        boolean[] toTravel = new boolean[days[n - 1] + 1];
        // 创建最大日期长度的记忆数组
        int[] dp = new int[days[n - 1] + 1];
        for (int day : days) {
            toTravel[day] = true;
        }
        for (int i = 1; i <= days[n - 1]; i++) {
            if (!toTravel[i]) {
                dp[i] = dp[i - 1];
            } else {
                // shuu:注意这里的从三种方案中取最小值
                // !!! 因为唇笔题目会让 costs[0]>costs[1]或costs[1]>costs[2]
                // 也就是i<30时 可以一开始就选出现30天
                dp[i] = Math.min(dp[i - 1] + costs[0],
                        Math.min(dp[Math.max(0, i - 7)] + costs[1],
                                dp[Math.max(i - 30, 0)] + costs[2]));
            }
        }

        return dp[days[n - 1]];
    }
}
// @lc code=end
