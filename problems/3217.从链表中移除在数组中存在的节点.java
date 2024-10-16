/*
 * @lc app=leetcode.cn id=3217 lang=java
 *
 * [3217] 从链表中移除在数组中存在的节点
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
    Set<Integer> numsSet = new HashSet<>();

    public ListNode modifiedList(int[] nums, ListNode head) {
        // 使用递归删除
        // ListNode newHead = head;
        // for (int i = 0; i < nums.length; i++) {
        // numsSet.add(nums[i]);
        // }
        // newHead = removeVal(newHead);
        // return newHead;

        for (int i : nums) {
            numsSet.add(i);
        }
        ListNode headBefore = new ListNode();
        headBefore.next = head;
        ListNode tmp = headBefore;
        while (tmp.next != null) {
            if (numsSet.contains(tmp.next.val)) {
                tmp.next = tmp.next.next;
            } else {
                tmp = tmp.next;
            }
        }
        return headBefore.next;
    }

    // 从链表删除某个值节点的递归方法
    ListNode removeVal(ListNode head) {
        if (head == null) {
            return head;
        }
        head.next = removeVal(head.next);
        return numsSet.contains(head.val) ? head.next : head;
    }
}
// @lc code=end
