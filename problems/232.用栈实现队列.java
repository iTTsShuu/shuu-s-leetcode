/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {
    Deque<Integer> inD;
    Deque<Integer> outD;

    public MyQueue() {
        inD = new ArrayDeque<>();
        outD = new ArrayDeque<>();
    }

    public void push(int x) {
        inD.push(x);
    }

    public int pop() {
        if (outD.isEmpty()) {
            in2Out();
        }
        return outD.pop();
    }

    public int peek() {
        if (outD.isEmpty()) {
            in2Out();
        }
        return outD.peek();
    }

    public boolean empty() {
        return outD.isEmpty() && inD.isEmpty();
    }

    private void in2Out() {
        while (!inD.isEmpty()) {
            outD.push(inD.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end
