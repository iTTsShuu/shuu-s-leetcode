/*
 * @lc app=leetcode.cn id=1146 lang=java
 *
 * [1146] 快照数组
 */

// @lc code=start

import java.util.*;

class SnapshotArray {

    /*
     * 思考 只有set方法会对snap有影响
     * 小看解题发现果然不能暴力每次snap复制 而是记录set时对每个下标index的修改历史history
     * 使用map记录 同时以当前index为历史版本号(key) 再记录对应修改历史
     * 
     * 看了使用TreeMap偷懒的做法 TreeMap 使用红黑树存储key的map在查找key方面是 二分思想
     */
    int snapCnt = 0;
    Map<Integer, List<int[]>> history = new HashMap<>();

    public SnapshotArray(int length) {
    }

    public void set(int index, int val) {
        history.computeIfAbsent(index, key -> new ArrayList<>()).add(new int[] { snapCnt, val });
    }

    public int snap() {
        return snapCnt++;
    }

    public int get(int index, int snap_id) {
        if (!history.containsKey(index)) {
            return 0;
        }
        List<int[]> hList = history.get(index);
        int j = search(hList, snap_id);
        return j < 0 ? 0 : hList.get(j)[1];
    }

    int search(List<int[]> list, int snap_id) {
        // 开区间 (left, right)
        int left = -1;
        int right = list.size();
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // h[left][0] <= x
            // h[right][1] > x
            int mid = left + (right - left) / 2;
            if (list.get(mid)[0] <= snap_id) {
                left = mid; // 区间缩小为 (mid, right)
            } else {
                right = mid; // 区间缩小为 (left, mid)
            }
        }
        // 根据循环不变量，此时 h[left][0] <= x 且 h[left+1][0] = h[right][0] > x
        // 所以 left 是最大的满足 h[left][0] <= x 的下标
        // 如果不存在，则 left 为其初始值 -1
        return left;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
// @lc code=end
class test1146 {
    public static void main(String[] args) {
        SnapshotArray snapshotArray = new SnapshotArray(4);

    }
}