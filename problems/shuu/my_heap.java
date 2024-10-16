package shuu;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆实践 尝试实现一个堆 这里实现大顶堆
 */
public class my_heap<E> extends ArrayList<E> {

    // 使用数组实现堆 这里用大顶堆
    private List<Integer> myHeap = new ArrayList<>();

    // 获取下标i节点的左节点下标
    int left(int i) {
        return 2 * i + 1;
    }

    // 获取下标i节点的右节点下标
    int right(int i) {
        return 2 * i + 2;
    }

    // 父节点的
    int parent(int i) {
        return (i - 1) / 2;
    }

    // peek堆顶元素
    int peek() {
        return myHeap.get(0);
    }

    // 建堆
    my_heap(List<Integer> nums) {
        // 将列表元素原封不动添加进堆
        myHeap = new ArrayList<>(nums);
        // 堆化除叶节点以外的其他所有节点
        // 叶节点天然没有子节点， 不需要进行堆化
        for (int i = parent(size() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    // 元素入堆
    // shuu:从入堆节点开始，从底至顶执行堆化
    void push(int i) {
        myHeap.add(i);
        // 从底至顶执行堆化
        siftUp(size() - 1);
    }

    // 元素出堆
    // shuu:
    // 如果我们直接从列表中删除首元素，
    // 那么二叉树中所有节点的索引都会发生变化，
    // 这将使得后续使用堆化进行修复变得困难。
    // 为了尽量减少元素索引的变动，我们采用以下操作步骤。
    int pop() {
        // 判空处理
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        // 交换根节点与最右叶节点（交换首元素与尾元素）
        swap(0, size() - 1);
        // 删除节点
        int val = myHeap.remove(size() - 1);
        // 从顶至底堆化
        siftDown(0);
        // 返回堆顶元素
        return val;
    }

    // 从顶至底堆化
    void siftDown(int i) {
        while (true) {
            // 判断节点 i, l, r 中值最大的节点，记为 ma
            int l = left(i), r = right(i), ma = i;
            if (l < size() && myHeap.get(l) > myHeap.get(ma))
                ma = l;
            if (r < size() && myHeap.get(r) > myHeap.get(ma))
                ma = r;
            // 若节点 i 最大或索引 l, r 越界，则无须继续堆化，跳出
            if (ma == i)
                break;
            // 交换两节点
            swap(i, ma);
            // 循环向下堆化
            i = ma;
        }
    }

    // 从底至顶执行堆化
    void siftUp(int i) {
        while (true) {
            // 获取节点 i 的父节点
            int p = parent(i);
            // 当“越过根节点”或“节点无须修复”时，结束堆化
            if (p < 0 || myHeap.get(i) <= myHeap.get(p))
                break;
            // 交换两节点
            swap(i, p);
            // 循环向上堆化
            i = p;
        }
    }

    @Override
    public int size() {
        return myHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return myHeap.isEmpty();
    }

    private void swap(int i, int p) {
        Integer tmp = myHeap.get(i);
        myHeap.set(i, myHeap.get(p));
        myHeap.set(p, tmp);
    }

}
