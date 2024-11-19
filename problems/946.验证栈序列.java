/*
 * @lc app=leetcode.cn id=946 lang=java
 *
 * [946] 验证栈序列
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 用栈模拟 在遇到相同数字时弹出 最后所有数都入栈出栈一次代表成功
        Deque<Integer> stack = new ArrayDeque<>();
        int popI = 0;
        for (int i = 0; i < popped.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[popI]) {
                stack.pop();
                popI++;
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end
