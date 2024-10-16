/*
 * @lc app=leetcode.cn id=328 lang=java
 *
 * [328] 奇偶链表
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // shuu: 两个指针分别连接偶数和奇数链表
        ListNode s = head, f = head.next;
        ListNode ss = s, ff = f;
        while ((ss != null && ss.next != null) || (ff != null && ff.next != null)) {
            if (ss != null && ss.next != null) {
                ss.next = ss.next.next;
                ss = ss.next;
            }
            if (ff != null && ff.next != null) {
                ff.next = ff.next.next;
                ff = ff.next;
            }
        }
        // 拼接答案
        while (s.next != null) {
            s = s.next;
        }
        s.next = f;
        return head;
    }

}
// @lc code=end
