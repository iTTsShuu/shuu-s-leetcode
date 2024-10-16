/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode left = dummyHead, right = dummyHead;
        int dis = -1;
        // 这里的深度计算其实很烧脑 不如下面方法易于理解：
        // 前后指针找到倒数第N个节点
        while (right != null) {
            if (dis == n) {
                right = right.next;
                left = left.next;
            } else {
                right = right.next;
                dis++;
            }
        }
        // 进行删除
        left.next = left.next.next;
        return dummyHead.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode leftNode = dummy, rightNode = head;
        // 这里是题目保证了n不会超过链表长度，否则这里需要判断right 是否为空
        for (int i = 0; i < n; i++) {
            rightNode = rightNode.next;
        }
        while (rightNode != null) {
            rightNode = rightNode.next;
            leftNode = leftNode.next;
        }
        leftNode.next = leftNode.next.next;
        return dummy.next;
    }
}
// @lc code=end
