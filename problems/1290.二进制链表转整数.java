/*
 * @lc app=leetcode.cn id=1290 lang=java
 *
 * [1290] 二进制链表转整数
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
    public int getDecimalValue(ListNode head) {
        ListNode node = head;
        Deque<Integer> stack = new ArrayDeque<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        int ans = 0;
        int n = stack.size();
        for (int i = 0; i < n; i++) {
            ans += stack.pop() == 1 ? Math.pow(2, i) : 0;
        }
        return ans;
    }
}
// @lc code=end
