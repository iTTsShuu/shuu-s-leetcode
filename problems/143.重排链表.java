/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 */

// @lc code=start

import java.util.ArrayList;

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
    public void reorderList(ListNode head) {

        // shuu:队列方式处理节点
        // if (head == null) {
        // return;
        // }
        // List<ListNode> nodeList = new ArrayList<>();
        // ListNode node = head;
        // while (node != null) {
        // nodeList.add(node);
        // node = node.next;
        // }
        // int i = 0, j = nodeList.size() - 1;
        // while (i < j) {
        // ListNode right = nodeList.get(j);
        // ListNode left = nodeList.get(i);
        // right.next = left.next;
        // left.next = right;
        // i++;
        // --j;
        // }
        // nodeList.get(i).next = null;

        // shuu: 块慢指针运用之一
        // shuu: 找到中点节点 反转后半部分 合并两部分链表
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode reversed = reverseList(mid.next, null);
        mid.next = null;
        mergList(head, reversed);
    }

    // 找到中间节点
    public ListNode middleNode(ListNode head) {
        // 经典的快慢指针
        ListNode l = head, r = head;
        while (r.next != null && r.next.next != null) {
            r = r.next.next;
            l = l.next;
        }
        return l;
    }

    // 反转链表
    public ListNode reverseList(ListNode head, ListNode pre) {
        if (head == null) {
            return pre;
        } else {
            // shuu:这里是做头节点的返回
            ListNode ans = reverseList(head.next, head);
            head.next = pre;
            return ans;
        }
    }

    // 合并俩链表
    public void mergList(ListNode l1, ListNode l2) {
        ListNode l1Next;
        ListNode l2Next;
        while (l1 != null && l2 != null) {
            // 这里的交换有一点搅脑袋
            // shuu:使用l1Next和l2Next 更清晰一点
            l1Next = l1.next;
            l2Next = l2.next;

            l1.next = l2;
            l1 = l1Next;

            l2.next = l1;
            l2 = l2Next;
        }
    }
}
// @lc code=end
