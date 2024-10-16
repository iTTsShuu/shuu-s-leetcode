/*
 * @lc app=leetcode.cn id=2816 lang=java
 *
 * [2816] 翻倍以链表形式表示的数字
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
    public ListNode doubleIt(ListNode head) {
        // shuu:尝试递归
        if (dfs(head) == 1) {
            return new ListNode(1, head);
        }

        return head;
    }

    int dfs(ListNode head) {
        if (head == null) {
            return 0;
        }
        int Val = head.val;
        head.val = (Val * 2) % 10 + dfs(head.next);
        return (Val * 2) / 10;
    }
}
// @lc code=end
