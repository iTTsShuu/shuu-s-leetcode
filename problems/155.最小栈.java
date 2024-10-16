import java.util.Stack;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {

    Stack<Integer> stack;
    Stack<Integer> min_stack;

    public MinStack() {
        stack=new Stack<>();
        min_stack=new Stack<>();
        min_stack.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        stack.push(val);
        min_stack.push(Math.min(val, min_stack.peek()));
    }
    
    public void pop() { 
        stack.pop();
        min_stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

