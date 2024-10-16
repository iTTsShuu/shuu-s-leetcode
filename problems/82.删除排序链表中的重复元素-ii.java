import java.util.List;

/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        // 多记录一个前节点 在删除时使用
        ListNode left = new ListNode(-101), right = head, leftHead = left;
        ListNode preNode = left;
        left.next = head;
        while (right != null) {
            if (left.val < right.val) {
                preNode = left;
                left = left.next;
                right = right.next;
            } else {
                // 循环做删除
                ListNode tempNode = right;
                right = right.next;
                while (right != null && right.val == tempNode.val) {
                    tempNode = tempNode.next;
                    right = right.next;
                }
                preNode.next = right;
                left = preNode;
            }

        }
        return leftHead.next;
    }
}
// @lc code=end
