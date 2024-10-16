/*
 * @lc app=leetcode.cn id=2181 lang=java
 *
 * [2181] 合并零之间的节点
 */

// @lc code=start
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
    public ListNode mergeNodes(ListNode head) {
        ListNode left = head, right = head.next;
        ListNode ans = head;
        int sum = 0;
        while (right != null) {
            if (right.val == 0) {
                right = right.next;
                // 赋值为和
                left.val = sum;
                left.next = right;
                left = left.next;
                // 重置sum
                sum = 0;
            }
            if (right != null) {
                sum += right.val;
                right = right.next;
            }
        }
        return ans;
    }
}
// @lc code=end
