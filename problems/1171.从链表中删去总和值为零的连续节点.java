/*
 * @lc app=leetcode.cn id=1171 lang=java
 *
 * [1171] 从链表中删去总和值为零的连续节点
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

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
    public ListNode removeZeroSumSublists(ListNode head) {
        // shuu:哈希表 plus 前缀和 理解官解 成为官解
        // 记录前缀和
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode node = head;
        int curSum = 0;
        // 这里有出现相等的前缀和会出现覆盖
        while (node != null) {
            curSum += node.val;
            map.put(curSum, node);
            node = node.next;
        }
        // 第二次遍历 首次出现存在的前缀和进行删除
        // 可能会出现删除头节点的情况 所以添加dummy
        ListNode dummy = new ListNode(0, head);
        curSum = 0;
        for (node = dummy; node != null; node = node.next) {
            curSum += node.val;
            if (map.containsKey(curSum)) {
                node.next = map.get(curSum).next;
            }
        }
        return dummy.next;
    }
}
// @lc code=end
