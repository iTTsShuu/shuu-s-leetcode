/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */

// @lc code=start

import java.util.TreeMap;

class MedianFinder {
    // 维护一个有序的数组
    // 加入数 时通过插入的方式
    // 计算记录插入后的中位数
    TreeMap<Integer, Integer> map;
    int left, right;
    int n;
    // 分开存储中位数左边和右边的数

    public MedianFinder() {
        this.map = new TreeMap<>();
        n = 0;
        left = 0;
        right = 0;
    }

    public void addNum(int num) {

    }

    public double findMedian() {

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end
