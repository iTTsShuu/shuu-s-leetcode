/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // shuu: 基于堆的做法 堆排序
        // // 小顶堆
        // Queue<Integer> heap = new PriorityQueue<>((a, b) -> {
        // return a - b;
        // });
        // // 先加入k个
        // for (int i = 0; i < k; i++) {
        // heap.offer(nums[i]);
        // }
        // // 遍历整个数组 保持堆长度为k
        // for (int i = k; i < nums.length; i++) {
        // if (nums[i] > heap.peek()) {
        // heap.poll();
        // heap.offer(nums[i]);
        // }
        // }
        // // 做完之后直接返回即可
        // return heap.peek();
    }
}
// @lc code=end
