/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-6000, head);
        ListNode lastSorted = head; // 创建维护最后排序的节点，并更新
        ListNode curNode = head.next;
        while (curNode != null) {
            if (lastSorted.val <= curNode.val) {
                lastSorted = lastSorted.next;
            } else {
                // 主要注意lastSorted最后排序节点的使用
                lastSorted.next = insertOrderly(dummyHead, curNode);
            }
            // ListNode dummy = new ListNode(-1, dummyHead);
            // ListNode preNode = dummy;
            // while (preNode.next != null && curNode.val > preNode.next.val) {
            // preNode = preNode.next;
            // }
            // curNode.next = preNode.next;
            // preNode.next = curNode;
            curNode = lastSorted.next;
        }
        return dummyHead.next;
    }

    ListNode insertOrderly(ListNode dummyHead, ListNode curNode) {
        ListNode preNode = dummyHead;
        while (curNode.val > preNode.next.val) {
            preNode = preNode.next;
        }
        ListNode nextToAdd = curNode.next;
        curNode.next = preNode.next;
        preNode.next = curNode;
        return nextToAdd;
    }
}
// @lc code=end
