/*
 * @lc app=leetcode.cn id=1503 lang=java
 *
 * [1503] 所有蚂蚁掉下来前的最后一刻
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        // shuu:两只相遇的蚂蚁同时改变移动方向之后的情形等价于两只蚂蚁都不改变移动方向
        // 是的 两只相遇的蚂蚁同时改变移动方向之后的情形等价于两只蚂蚁都不改变移动方向 ！！！
        // 是的 两只相遇的蚂蚁同时改变移动方向之后的情形等价于两只蚂蚁都不改变移动方向 ！！！
        // 是的 两只相遇的蚂蚁同时改变移动方向之后的情形等价于两只蚂蚁都不改变移动方向 ！！！
        // 是的 两只相遇的蚂蚁同时改变移动方向之后的情形等价于两只蚂蚁都不改变移动方向 ！！！
        // 是的 两只相遇的蚂蚁同时改变移动方向之后的情形等价于两只蚂蚁都不改变移动方向 ！！！
        // 是的 两只相遇的蚂蚁同时改变移动方向之后的情形等价于两只蚂蚁都不改变移动方向 ！！！
        // 是的 两只相遇的蚂蚁同时改变移动方向之后的情形等价于两只蚂蚁都不改变移动方向 ！！！
        // 是的 两只相遇的蚂蚁同时改变移动方向之后的情形等价于两只蚂蚁都不改变移动方向 ！！！
        // 是的 两只相遇的蚂蚁同时改变移动方向之后的情形等价于两只蚂蚁都不改变移动方向 ！！！
        // 是的 两只相遇的蚂蚁同时改变移动方向之后的情形等价于两只蚂蚁都不改变移动方向 ！！！
        // 是的 两只相遇的蚂蚁同时改变移动方向之后的情形等价于两只蚂蚁都不改变移动方向 ！！！
        // 是的 两只相遇的蚂蚁同时改变移动方向之后的情形等价于两只蚂蚁都不改变移动方向 ！！！
        int ans = 0;
        for (int x : left) {
            ans = Math.max(ans, x);
        }
        for (int x : right) {
            ans = Math.max(ans, n - x);
        }
        return ans;
    }
}
// @lc code=end
