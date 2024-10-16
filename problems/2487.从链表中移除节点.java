/*
 * @lc app=leetcode.cn id=2487 lang=java
 *
 * [2487] 从链表中移除节点
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
    // 递归方法 关键想法是当前节点只对右边的节点有影响918，做反向处理。
    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        head.next = removeNodes(head.next);
        if (head.next != null && head.val < head.next.val) {
            return head.next;
        } else {
            return head;
        }
    }
}
// @lc code=end
