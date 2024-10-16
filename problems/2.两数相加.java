import java.util.List;

/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode((l1.val + l2.val) % 10), a = l1.next, b = l2.next;
        int carry = (l1.val + l2.val) / 10;
        ListNode t = ans;
        while (a != null && b != null) {
            if (t.next == null)
                t.next = new ListNode();
            t = t.next;
            t.val = (a.val + b.val + carry) % 10;
            carry = (a.val + b.val + carry) / 10;
            a = a.next;
            b = b.next;
        }
        while (a != null) {
            if (t.next == null)
                t.next = new ListNode();
            t = t.next;
            t.val = (a.val + carry) % 10;
            carry = (a.val + carry) / 10;
            a = a.next;
        }
        while (b != null) {
            if (t.next == null)
                t.next = new ListNode();
            t = t.next;
            t.val = (b.val + carry) % 10;
            carry = (b.val + carry) / 10;
            b = b.next;
        }
        if (carry != 0) {
            t.next = new ListNode();
            t = t.next;
            t.val = 1;
        }
        return ans;
    }

    public void myprint(ListNode l) {
        while (l != null) {
            System.out.print(l.val + ",");
            l = l.next;
        }
        System.out.println(" ");
    }
}

// @lc code=end
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class mymain {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        mySolution solution = new mySolution();
        solution.myprint(l2);
        ListNode ans = solution.addTwoNumbers(l1, l2);
        solution.myprint(ans);
    }

}
