/*
 * @lc app=leetcode.cn id=1669 lang=java
 *
 * [1669] 合并两个链表
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode node1 = list1;
        ListNode nodeA = null, nodeB = null;
        int index = -1;
        // 找到插入前后节点
        while (index < b) {
            index++;
            if (index == a - 1) {
                nodeA = node1;

            }
            node1 = node1.next;
        }
        nodeB = node1;
        nodeA.next = list2;
        ListNode node2 = new ListNode(0, list2);
        // 遍历到list2最后一个节点做连接
        while (node2.next != null) {
            node2 = node2.next;
        }
        node2.next = nodeB;
        return list1;
    }
}
// @lc code=end
