/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        // shuu:一种单调栈的思想 遇到比栈顶小的数压入栈 比栈顶大的数弹出所有栈元素 进行修改
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < answer.length; i++) {
            int cur = temperatures[i];
            while (!stack.isEmpty() && cur > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                answer[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return answer;
    }
}
// @lc code=end
