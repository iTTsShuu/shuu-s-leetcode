/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list1=reverseList(l1),list2=reverseList(l2);
        ListNode ans= reverseList(toaddTwoNumbers(list1, list2));
        return ans;
    }
    public ListNode toaddTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans=new ListNode((l1.val+l2.val)%10),a=l1.next,b=l2.next;
        int carry=(l1.val+l2.val)/10;
        ListNode t=ans;
        while(a!=null&&b!=null){
            if(t.next==null)t.next=new ListNode();
            t=t.next;
            t.val=(a.val+b.val+carry)%10;
            carry=(a.val+b.val+carry)/10;
            a=a.next;
            b=b.next;
        }
        while(a!=null){
            if(t.next==null)t.next=new ListNode();
            t=t.next;
            t.val=(a.val+carry)%10;
            carry=(a.val+carry)/10;
            a=a.next;
        }
        while(b!=null){
            if(t.next==null)t.next=new ListNode();
            t=t.next;
            t.val=(b.val+carry)%10;
            carry=(b.val+carry)/10;
            b=b.next;
        }
        if(carry!=0){
            t.next=new ListNode();
            t=t.next;
            t.val=1;
        }
        return ans;
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre=null,curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }
}
// @lc code=end

