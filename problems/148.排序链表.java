/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 */

// @lc code=start

import java.util.List;

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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 快慢指针找到中点
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode ansNode = new ListNode();
        ListNode headAns = ansNode;
        while (left != null && right != null) {
            if (left.val < right.val) {
                ansNode.next = left;
                left = left.next;
            } else {
                ansNode.next = right;
                right = right.next;
            }
            ansNode = ansNode.next;
        }
        if (left != null) {
            ansNode.next = left;
        } else {
            ansNode.next = right;
        }
        return headAns.next;
    }
}
// @lc code=end
