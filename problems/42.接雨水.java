/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int trap(int[] height) {
        // shuu:要动态规划，还没搞定！！！
        // shuu: 特殊情况
        // 小于长度3时 一定接0
        int len = height.length;
        if (len < 3) {
            return 0;
        }

        // 双指针 动态规划的求当前遍历值左边的最大值和右边的最大值 用数组储存
        // 边界情况不存水
        // !!这里可以通过滚动数组做优化
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        // 动态规划的求当前位置左边的最大值
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        rightMax[len - 1] = height[len - 1];
        // 动态规划的求当前位置右边边的最大值
        for (int i = len - 2; i >= 0; --i) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        // 求完之后直接求每个位置的存水 计算答案
        int ans = 0;
        for (int i = 1; i < len - 1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    public int trap1(int[] height) {
        // shuu: 单调栈的使用
        // shuu: 特殊情况
        // 小于长度3时 一定接0
        if (height.length < 3) {
            return 0;
        }
        // 情况一：当前遍历的元素（柱子）高度小于栈顶元素的高度 height[i] < height[st.top()]
        // 情况二：当前遍历的元素（柱子）高度等于栈顶元素的高度 height[i] == height[st.top()]
        // 情况三：当前遍历的元素（柱子）高度大于栈顶元素的高度 height[i] > height[st.top()]
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            if (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                stack.push(i);
            }
            if (!stack.isEmpty() && height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                // 当前值大于单调栈顶 出现了凹槽 ，弹出栈中所有元素 横向计算所有的凹槽水
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    Integer midIndex = stack.pop();
                    // 注意边界状态
                    // 即当前值的左边没有更大的值
                    if (!stack.isEmpty()) {
                        int leftIndex = stack.peek();
                        int minH = Math.min(height[leftIndex], height[i]) - height[midIndex];
                        ans += minH * (i - leftIndex - 1);
                    }
                }
                stack.push(i);
            }
        }
        return ans;
    }
}

// @lc code=end
/**
 * 42.接雨水
 */
class test42 {
    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        Solution42 solution = new Solution42();
        System.out.println(solution.trap(height));
    }
}