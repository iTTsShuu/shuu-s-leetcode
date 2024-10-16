/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // 新建小顶堆
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (heap.size() == k) {
                if (heap.peek()[1] < value) {
                    heap.poll();
                    heap.offer(new int[] { key, value });
                }
            } else {
                heap.offer(new int[] { key, value });
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = heap.poll()[0];
        }
        return ret;
    }
}
// @lc code=end
