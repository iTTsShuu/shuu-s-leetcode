import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 随机链表的复制
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node ,Node > map=new HashMap();
        copydfs(head, map);
        return map.get(head);
    }
    public Node copydfs(Node head,Map<Node , Node> map){
        if(head==null){
            return null;
        }
        if(!map.containsKey(head)){
            Node copy=new Node(head.val);
            map.put(head, copy);
            copy.next=copydfs(head.next,map);
            copy.random=copydfs(head.random,map);

        }
        return map.get(head);
    }
}
// @lc code=end

