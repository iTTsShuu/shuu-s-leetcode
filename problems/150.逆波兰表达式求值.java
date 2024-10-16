/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (isNUM(tokens[i])) {
                stack.add(Integer.valueOf(tokens[i]));
            } else {
                int y = stack.pop();
                int x = stack.pop();
                switch (tokens[i]) {
                    case "+":
                        stack.push(x + y);
                        break;
                    case "-":
                        stack.push(x - y);
                        break;
                    case "*":
                        stack.push(x * y);
                        break;
                    case "/":
                        stack.push(x / y);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    public Boolean isNUM(String s) {
        return !("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s));
    }
}
// @lc code=end
