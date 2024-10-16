/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

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
        // 没注意有序链表，多开额外空间 ，像个傻波依一样夏季包hash 真蠢完了
        // Set<Integer> set = new HashSet<>();
        // ListNode dummy = new ListNode(0, head);
        // ListNode tmp = dummy;
        // while (tmp.next != null) {
        // if (set.contains(tmp.next.val)) {
        // tmp.next = tmp.next.next;
        // } else {
        // set.add(tmp.next.val);
        // tmp = tmp.next;
        // }
        // }
        // return dummy.next;

        // 直接遍历一遍 跳过就完事了

        if (head == null) {
            return head;
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
// @lc code=end
