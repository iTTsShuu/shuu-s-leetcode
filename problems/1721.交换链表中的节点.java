/*
 * @lc app=leetcode.cn id=1721 lang=java
 *
 * [1721] 交换链表中的节点
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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        // 找到第k-1个节点
        ListNode kMinus1 = dummy;
        for (int i = 0; i < k - 1; i++) {
            kMinus1 = kMinus1.next;
        }
        // 找到倒数第K+1个节点
        ListNode lefNode = dummy, rightNode = dummy;
        for (int i = 0; i < k + 1; i++) {
            rightNode = rightNode.next;
        }
        while (rightNode != null) {
            lefNode = lefNode.next;
            rightNode = rightNode.next;
        }
        ListNode kNode = kMinus1.next; // 第k个节点
        ListNode nodeK = lefNode.next; // 倒数第k个节点
        // 两节点相邻的特殊情况
        // 1. k在倒数k左边
        if (kNode.next == nodeK) {
            // 进行交换
            kNode.next = nodeK.next;
            kMinus1.next = nodeK;
            nodeK.next = kNode;
        } else if (nodeK.next == kNode) {
            // 进行交换
            nodeK.next = kNode.next;
            lefNode.next = kNode;
            kNode.next = nodeK;
        } else {
            // 交换两节点
            ListNode nodeKNext = nodeK.next; // 倒数第k个节点后一个节点
            kMinus1.next = nodeK;
            lefNode.next = kNode;
            nodeK.next = kNode.next;
            kNode.next = nodeKNext;

        }

        return dummy.next;
    }
}
// @lc code=end
