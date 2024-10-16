import java.util.Stack;

/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //// 因为头节点有可能发生变化，可以使用虚拟头节点可以避免复杂的分类讨论
        //未尝试
        
        // 先访问后加入的方式想到栈
        Stack<ListNode> stack=new Stack<>();
        ListNode leftnode=head,rightnode=head;
        ListNode node=head;
        //遍历链表时记录需要反转左右位置的节点
        //同时将需要反转的节点入栈
        for (int i = 0; i < right; i++) {
            if(i==left-2){
                leftnode=node;
            }
            if(i>left-2){
                stack.push(node);
            }
            node=node.next;
            rightnode=node;
        }
        //取出栈中的节点进行反转
        if(left==1){
            head=stack.pop();
            leftnode=head;
        }
        while(!stack.empty()){
            ListNode addNode=stack.pop();
            leftnode.next=addNode;
            leftnode=leftnode.next;
            leftnode.next=null;
        }
        if(rightnode!=null){
            leftnode.next=rightnode;
        }
        return head;
        
    }
}
// @lc code=end

