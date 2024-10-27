/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并 K 个升序链表
 */

// @lc code=start

import java.util.PriorityQueue;

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

    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }

    PriorityQueue<Status> queue = new PriorityQueue<Status>();

    // 通过优先队列进行合并
    public ListNode mergeKLists1(ListNode[] lists) {
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            if (f.ptr.next != null) {
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));
            }
        }
        return head.next;
    }

    // 通过优先队列进行合并
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> nodeQueue = new PriorityQueue<>((n1, n2) -> {
            return n1.val - n2.val;
        });
        for (ListNode node : lists) {
            if (node != null) {
                nodeQueue.offer(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!nodeQueue.isEmpty()) {
            // 每次取到的都是最小值
            ListNode f = nodeQueue.poll();
            tail.next = f;
            tail = tail.next;
            f = f.next;
            if (f != null) {
                nodeQueue.offer(f);
            }
        }
        return head.next;
    }
}

// @lc code=end
