/*
 * @lc app=leetcode.cn id=1845 lang=java
 *
 * [1845] 座位预约管理系统
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

class SeatManager {
    private PriorityQueue<Integer> available;

    public SeatManager(int n) {
        available = new PriorityQueue<>(n);
        for (int i = n; i > 0; i--) {
            available.offer(i);
        }
    }

    public int reserve() {
        return available.poll();
    }

    public void unreserve(int seatNumber) {
        available.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
// @lc code=end
