import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1019 lang=java
 *
 * [1019] 链表中的下一个更大节�??
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
    public int[] nextLargerNodes(ListNode head) {
        ListNode curNode=head;
        int n=0;
        while(curNode!=null){
            n++;
            curNode=curNode.next;
        }
        curNode=head;
        int[] answers=new int[n];
        Deque<int[]> stack=new ArrayDeque<int[]>();
        int index=-1;
        while(curNode!=null){
            index++;
            while(!stack.isEmpty()&&curNode.val>stack.peek()[1]){
                answers[stack.pop()[0]]=curNode.val;
            }
            stack.push(new int[]{index,curNode.val});
            curNode=curNode.next;
        }
        return answers;
    }
}
// @lc code=end

