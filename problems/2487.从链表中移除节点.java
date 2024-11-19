/*
 * @lc app=leetcode.cn id=2487 lang=java
 *
 * [2487] 从链表中移除节点
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

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
    // 递归方法 关键想法是当前节点只对右边的节点有影响918，做反向处理。
    public ListNode removeNodes1(ListNode head) {
        if (head == null) {
            return head;
        }
        head.next = removeNodes(head.next);
        if (head.next != null && head.val < head.next.val) {
            return head.next;
        } else {
            return head;
        }
    }

    // 迭代
    public ListNode removeNodes(ListNode head) {
        // 用栈来迭代 ，本质也是反向遍历链表 删除小于新链表头部的节点 拼接新节点到头
        // 也可以反转链表删除后再次反转得到答案
        Deque<ListNode> stack = new ArrayDeque<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode tmpHead = stack.pop();
        while (!stack.isEmpty()) {
            if (stack.peek().val >= tmpHead.val) {
                stack.peek().next = tmpHead;
                tmpHead = stack.peek();
            }
            stack.pop();
        }
        return tmpHead;
    }
}
// @lc code=end
