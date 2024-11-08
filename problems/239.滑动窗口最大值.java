/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int curM = Integer.MIN_VALUE;
        int left = 0;
        // 手动滑动窗口 超时了
        // shuu:是的 超时了
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                curM = Math.max(curM, nums[i]);
                ans[left] = curM;
            } else {
                if (nums[left] == curM) {
                    curM = getMax(nums, left + 1, k);
                } else {
                    curM = Math.max(curM, nums[i]);
                }
                ans[++left] = curM;
            }
        }
        return ans;
    }

    public int getMax(int[] nums, int left, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = left; i < left + k; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Arrays.fill(ans, 0);
        Deque<Integer> queue = new ArrayDeque();
        for (int i = 0; i < nums.length; i++) {
            // 单调队列的思想
            // 分别处理 元素入队 出队的逻辑
            // 这里加入队列的是下标 方便判断队首是否超出窗口
            if (queue.isEmpty() || nums[i] <= nums[queue.peekLast()]) {
                queue.addLast(i);
            } else {
                // 这种情况 为了保持单调性 移除到更大值
                while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                    queue.removeLast();
                }
                queue.offer(i);
            }
            // 或者队首已经超出了 窗口
            if (i - queue.peekFirst() > k - 1) {
                queue.removeFirst();
            }
            if (i >= k - 1) {
                ans[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return ans;
    }
}

// @lc code=end
class test239 {
    public static void main(String[] args) {
        Solution239 solution = new Solution239();
        int[] nums = { 1, -1 };
        int[] maxSlidingWindow = solution.maxSlidingWindow(nums, 1);
        for (int xxx : maxSlidingWindow) {
            System.out.printf("%d ", xxx);
        }
    }
}