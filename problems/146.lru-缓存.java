
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// // @lc code=start
// class LRUCache extends LinkedHashMap<Integer, Integer> {
// private int capacity;

// public LRUCache(int capacity) {
// super(capacity, 0.75F, true);
// this.capacity = capacity;
// }

// public int get(int key) {
// return super.getOrDefault(key, -1);
// }

// public void put(int key, int value) {
// super.put(key, value);
// }

// @Override
// protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
// return size() > capacity;
// }
// }

class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, DLinkedNode> map = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        // 键值存在，移动键到顶端
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if (node == null) { // 键值不存在
            DLinkedNode toAdd = new DLinkedNode(key, value);
            map.put(key, toAdd);
            // 添加到链表头部
            addToHead(toAdd);
            this.size++;
            if (this.size > capacity) {
                DLinkedNode removeNode = removeTail();
                map.remove(removeNode.key);
                this.size--;
            }
        } else { // 键值存在
                 // 修改对应节点value
            node.value = value;
            // 移动节点到头部
            moveToHead(node);
        }
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode toRemove = this.tail.prev;
        removeNode(toRemove);
        return toRemove;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
