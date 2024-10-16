/*
 * @lc app=leetcode.cn id=817 lang=java
 *
 * [817] 链表组件
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
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        ListNode node = head;
        int count = 0;
        while (node != null) {
            boolean end = false;
            // 结束当前组件
            while (node != null && set.contains(node.val)) {
                end = true;
                node = node.next;
            }
            if (end) {
                count++;
            }
            if (node != null) {
                node = node.next;
            }
        }
        return count;
    }
}
// @lc code=end
