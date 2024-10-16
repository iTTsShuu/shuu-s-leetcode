import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
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
    public boolean hasCycle(ListNode head) {
        // 快慢指针 迭代
        // ListNode fast=head,slow=head;
        // while(fast!=null){
        // fast=fast.next;
        // if (fast==null||fast.next==null) {
        // return false;
        // }
        // fast=fast.next;
        // slow=slow.next;
        // if (fast==slow) {
        // return true;
        // }
        // }
        // return false;

        // 哈希
        // Set<ListNode> mysSet=new HashSet<ListNode>();
        // while(head!=null){
        // if(!mysSet.add(head)){
        // return true;
        // }
        // head=head.next;
        // }
        // return false;

        // 快慢指针重写
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
