import java.util.List;

/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start
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
    public ListNode reverseList(ListNode head) {
        // 理想递归，但是再次丢失了头节点的位置，重新两参数的递归
        // ListNode ans=null;
        // if(head.next==null){
        // return head;
        // }
        // else{
        // ans=reverseList(head.next);
        // while(ans.next!=null){
        // ans=ans.next;
        // }
        // ans.next=head;
        // head.next=null;
        // return ans;
        // }

        // shuu:
        // 重写的递归函数
        return reverseList1(head, null);

        // ?非递归的写法：迭代遍历更改
        // ListNode pre = null, curr = head;
        // while (curr != null) {
        // ListNode next = curr.next;
        // curr.next = pre;
        // pre = curr;
        // curr = next;
        // }
        // return pre;
    }

    // 反转链表
    public ListNode reverseList1(ListNode head, ListNode pre) {
        if (head == null) {
            return pre;
        } else {
            ListNode ans = reverseList1(head.next, head);
            head.next = pre;
            return ans;
        }
    }
}
// @lc code=end
