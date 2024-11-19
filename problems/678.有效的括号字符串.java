/*
 * @lc app=leetcode.cn id=678 lang=java
 *
 * [678] 有效的括号字符串
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean checkValidString(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (chs[i] == '(') {
                stack1.push(i);
            } else if (chs[i] == '*') {
                stack2.push(i);
            } else if (chs[i] == ')' && !stack1.isEmpty()) {
                stack1.pop();
            } else if (chs[i] == ')' && !stack2.isEmpty()) {
                stack2.pop();
            } else {
                return false;
            }
        }
        // 比较剩余左括号和*号的位置
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int l = stack1.pop();
            int xin = stack2.pop();
            if (xin < l) {
                return false;
            }
        }
        return stack1.isEmpty();
    }
}
// @lc code=end
