/*
 * @lc app=leetcode.cn id=3248 lang=java
 *
 * [3248] 矩阵中的蛇
 */

// @lc code=start
class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        // 我直接一个模拟
        int ans = 0;
        for (String c : commands) {
            switch (c) {
                case "UP":
                    ans -= n;
                    break;
                case "RIGHT":
                    ans += 1;
                    break;
                case "DOWN":
                    ans += n;
                    break;
                case "LEFT":
                    ans -= 1;
                    break;
                default:
                    break;
            }
        }
        return ans;
    }
}
// @lc code=end
