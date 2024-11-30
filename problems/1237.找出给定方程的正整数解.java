/*
 * @lc app=leetcode.cn id=1237 lang=java
 *
 * [1237] 找出给定方程的正整数解
 */

// @lc code=start
/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        // 什么！好像是二分查找
        // no二分 双指针不漏解
        // 从 x=1,y=1000 开始，表示在横坐标为 [x,1000] 以及纵坐标为 [1,y] 的矩形范围内搜索答案
        List<List<Integer>> ans = new ArrayList<>();
        int x = 1, y = 1000;
        while (x <= 1000 && y >= 1) {
            int cur = customfunction.f(x, y);
            if (cur == z) {
                ans.add(Arrays.asList(x++, y--));
            } else if (cur < z) {
                x++;
            } else {
                y--;
            }
        }
        return ans;
    }
}
// @lc code=end
