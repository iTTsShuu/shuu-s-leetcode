import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //递归
        //定义边界条件，当有一个链表为空时，只需返回另一链表
        if (list1==null) {
            return list2;
        }
        if(list2==null){
            return list1;
        }
        if (list1.val>=list2.val) {
            list2.next=mergeTwoLists(list1, list2.next);;
            return list2;
        }
        else{
            list1.next=mergeTwoLists(list1.next, list2);
            return list1;
        }
        // 插入法尝试，以找不到头节点结束
        // ListNode l1=list1,l2=list2;
        // ListNode temp=null,temp2=null;
        // boolean oned=false;
        // if(l1==null){
        //     return list2;
        // }
        // while(l2!=null){
        //     while(l1!=null&&l2.val>=l1.val){
        //         temp=l1;
        //         l1=l1.next;
        //     }
        //     temp2=l2.next;
        //     l2.next=l1;
        //     if(!oned&&temp==null){
        //         list1=l2;
        //         oned=true;
        //     }
        //     if(temp!=null){
        //         temp.next=l2;
        //         temp=temp.next;
        //     }
        //     l2=temp2;
        // }
        // return list1;
    }
}
// @lc code=end
 
class test{
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void myListout(ListNode toout) {
        while(toout!=null){
            System.out.print(toout.val+" ");
            toout=toout.next;
        }
        System.out.println(" ");
    }
    public static void main(String[] args) {
        ListNode l1=new ListNode(1 );
        ListNode l2=new ListNode(1,new ListNode(2,new ListNode(4)));
        mySolution solution=new mySolution();
        ListNode ans = solution.mergeTwoLists( l1 , l2);
        test test1=new test();
        test1.myListout(ans);
    }
}
