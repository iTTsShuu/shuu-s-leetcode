/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

//import classes.ListNode;

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
    public ListNode reverseKGroup(ListNode head, int k) {
        // shuu:跟着灵神敲代码真的很爽！！！！！
        // 求链表长度
        int cnt = 0;
        for (ListNode n = head; n != null; n = n.next) {
            cnt++;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        ListNode pre = null;
        ListNode cur = head;
        // k个一组进行循环
        for (int i = cnt; i >= k; i -= k) { // 这里剩余长度大于k继续进行反转
            // 反转k个节点
            for (int j = 0; j < k; j++) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            // 此时cur 为下一段的第一个节点
            // 注意p0是反转这一段的上一个节点p0-next为反转部分的最后一个（原来的第一个）
            // 而原来的第一个反转后指向null 需要将原来的 上一个指向cur(下一段的第一个节点)
            // 再将p0移动到反转部分的最后一个（原来的第一个）
            ListNode nextP0 = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            // p0 进行转移
            p0 = nextP0;
        }
        return dummy.next;
    }
}
// @lc code=end
