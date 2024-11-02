/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start

import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode detectCycle1(ListNode head) {

        // 第一想法 哈希
        Set<ListNode> set = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (!set.contains(node)) {
                set.add(node);
            } else {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        // 快慢指针
        ListNode fast = head, slow = head;
        int pos = -1;
        while (fast != null) {
            fast = fast.next;
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        // shuu: 关键思想!
        // 这里重新从头新引入指针 它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。
        fast = head;
        while (fast != null) {
            if (fast == slow) {
                return fast;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return null;
    }
}
// @lc code=end
