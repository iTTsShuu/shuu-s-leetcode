/*
 * @lc app=leetcode.cn id=2058 lang=java
 *
 * [2058] 找出临界点之间的最小和最大距离
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode left = head, mid = left.next, right = mid.next;
        int[] ans = new int[] { -1, -1 };
        if (right == null) {
            return ans;
        }
        List<Integer> indexs = new ArrayList<>();
        int index = 1;
        // 顺序记录所有极值下标
        while (right != null) {
            if (isEage(left, mid, right)) {
                indexs.add(index);
            }
            left = left.next;
            mid = mid.next;
            right = right.next;
            index++;
        }
        // 搜寻最小距离
        int min = index;
        if (indexs.size() >= 2) {
            for (int i = 1; i < indexs.size(); i++) {
                min = Math.min(min, indexs.get(i) - indexs.get(i - 1));
            }
            ans[0] = min;
            ans[1] = indexs.get(indexs.size() - 1) - indexs.get(0);
        }
        return ans;
    }

    public boolean isEage(ListNode left, ListNode mid, ListNode right) {
        return (mid.val > left.val && mid.val > right.val) || (mid.val < left.val && mid.val < right.val);
    }
}
// @lc code=end
