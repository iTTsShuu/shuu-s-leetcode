/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        // 定位后半段
        ListNode halfToEnd = findMid(head);
        // 反转后半段
        ListNode reversseListNode = reversseListNode(halfToEnd.next);

        ListNode p1 = head;
        ListNode p2 = reversseListNode;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        // 还原？
        halfToEnd.next = reversseListNode(halfToEnd.next);
        return result;
    }

    // 反转链表
    private ListNode reversseListNode(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        // 反转后半段
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    // 快慢指针定位链表中点
    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
// @lc code=end
// 栈尝试
// Stack<Integer> stack = new Stack<>();

// if (head.next == null) {
// return true;
// }
// ListNode node = head;
// int count = 0;
// while (node != null) {
// int tmp = node.val;
// if (stack.isEmpty() || stack.peek() != tmp) {
// stack.push(tmp);
// } else {
// stack.pop();
// }
// node = node.next;
// count++;
// }
// if (count % 2 == 0) {
// return stack.isEmpty();
// } else {
// Stack<Integer> stack1 = new Stack<>();
// ListNode node1 = head;
// int i = 0;
// while (node1 != null) {
// i++;
// int tmp = node1.val;
// if (i == (count / 2) + 1) {
// node1 = node1.next;
// continue;
// }
// if (stack1.isEmpty() || stack1.peek() != tmp) {
// stack1.push(tmp);
// } else {
// stack1.pop();
// }
// node1 = node1.next;
// }
// return stack1.isEmpty();
// }
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode initListNode(int[] toBeList) {
        ListNode head = new ListNode(toBeList[0]);
        ListNode node = head;
        for (int i = 1; i < toBeList.length; i++) {
            node.next = new ListNode(toBeList[i]);
            node = node.next;
        }
        return head;
    }
}

class test234 {

    public static void main(String[] args) {
        int[] toBeList = new int[] {
                1, 2, 2, 2, 1
        };
        ListNode head = ListNode.initListNode(toBeList);
        Solution234 solution234 = new Solution234();
        System.out.println(solution234.isPalindrome(head));
    }
}