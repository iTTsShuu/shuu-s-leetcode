import java.util.List;

/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode node=head,rightnode=head;
        //将链表闭合为环
        int n=0;
        while(node!=null){
            n++;
            rightnode=node;
            node=node.next;
        }
        rightnode.next=head;
        //因为环的存在,每个节点向右移动k个位置，等效头节点向右移动(n-k%n)个位置
        for (int i = 0; i < n-(k%n); i++) {
            head=head.next;
        }
        //找到最右的节点将环链表断开
        rightnode=head;
        for (int i = 0; i < n-1; i++) {
            rightnode=rightnode.next;
        }
        rightnode.next=null;
        return head;
    }
}
// @lc code=end

