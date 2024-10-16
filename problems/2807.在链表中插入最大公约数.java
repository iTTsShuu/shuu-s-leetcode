/*
 * @lc app=leetcode.cn id=2807 lang=java
 *
 * [2807] 在链表中插入最大公约数
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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // 递归调用写法
        // if (head.next != null) {
        // ListNode nodeNext = insertGreatestCommonDivisors(head.next);
        // head.next = new ListNode(gcb(head.val, nodeNext.val), nodeNext);
        // }
        // return head;
        // 循环修改写法
        ListNode node = head;
        while (node.next != null) {
            node.next = new ListNode(gcb(node.val, node.next.val), node.next);
            node = node.next.next;
        }
        return head;
    }

    // 求最大公约数
    int gcb(int a, int b) {
        int tmp = a % b;
        while (tmp != 0) {
            a = b;
            b = tmp;
            tmp = a % b;
        }
        return b;
    }
}
// @lc code=end
