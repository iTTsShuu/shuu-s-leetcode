/*
 * @lc app=leetcode.cn id=735 lang=java
 *
 * [735] 小行星碰撞
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            boolean alive = true;
            while (alive && asteroid < 0 && !deque.isEmpty() && deque.peek() > 0) {
                alive = -asteroid > deque.peek();
                if (-asteroid >= deque.peek()) {
                    deque.pop();
                }
            }
            if (alive) {
                deque.push(asteroid);
            }
        }
        int[] ans = new int[deque.size()];
        for (int i = deque.size() - 1; i >= 0; i--) {
            ans[i] = deque.pop();
        }
        return ans;
    }
}
// @lc code=end
