import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        /*
         * 广度优先进行子节点扩充
         * 1.每次将队列里的所有元素取出进行拓展，将所有元素节点的子节点依次（左到右）的加入队列
         * 2.对取出的所有元素进行填充next
         * 3.处理到队列为空时结束算法。
         */
        if(root==null){
            return null;
        }
        Queue<Node> myQueue=new LinkedList();
        myQueue.add(root);
        while(!myQueue.isEmpty()){
            int n=myQueue.size();
            System.out.println(n);
            for (int i = 0; i < n; i++) {
                Node tNode=myQueue.poll();
                if(i<n-1){
                    tNode.next=myQueue.peek();
                }
                else{
                    tNode.next=null;
                }
                if(tNode.left!=null){
                    myQueue.add(tNode.left);
                }
                if(tNode.right!=null){
                    myQueue.add(tNode.right);
                }
            }
        }
        return root;
    }
}
// @lc code=end

class test  {
    public static void main(String[] args) {
        mySolution solution=new mySolution();
        Node node=new Node(1, new Node(2,new Node(4),new Node(5), null)
        ,new Node(3, null, new Node(7),null), null);
        solution.connect(node);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};