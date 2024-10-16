import java.util.List;

/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode node=head;
        ListNode leftlist=new ListNode(-1),rightlist=new ListNode(-1);
        ListNode rightHead=rightlist,leftHead=leftlist;
        while(node!=null){
            if(node.val<x){
                leftlist.next=node;
                leftlist=leftlist.next;
            }
            else{
                rightlist.next=node;
                rightlist=rightlist.next;
            }
            node=node.next;
        }
        rightlist.next=null;
        leftlist.next=rightHead.next;
        return leftHead.next;
    }
}
// @lc code=end

