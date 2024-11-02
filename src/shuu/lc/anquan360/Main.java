package anquan360;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static int mixTime(int[] a) {
        // 哈希表记录
        // 混合的选择可以是任意的 所以每次往最大值混合 可以保证只混合一次不出现重复
        Set<Integer> set = new HashSet<>();
        int time = 0;
        for (Integer x : a) {
            if (set.contains(x)) {
                time++;
            } else {
                set.add(x);
            }
        }
        return time;
    }

    private static int splitArea(int[] a, int k) {
        // 将A 划分为 k段
        // 一个序列 1 2 2 3 3 6 4 4 每个子序列的权和尽可能大
        // 只出现一次的数字无论被划分到哪都只能能贡献一次最大权
        // 分成k段需要k-1次划分 每次划分从各个区间选择出现两次以上的数 划分其中最大的数啊a[i]对权值贡献为a[i]
        // 先统计各个数出现的数量
        // 划分只选择有重复的元素n=7 k=3划分 1 2 1 3 4 1 3
        // 每次划分都在 有重复出现的最大数 倒数第二个位置进行划分
        int n = a.length;
        if (n == k) { // 划分为n个区间时 最大权值就是数组和
            return Arrays.stream(a).sum();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            // 同时维护一个存储出现两次以上的数的大顶堆?
        }
        // 求出划分前的权
        int valueSum = 0;
        for (Integer x : map.keySet()) { // 遍历key
            valueSum += x;
        }
        Set<Integer> set = new HashSet<>(); // 记录划分位置
        // 做k-1次划分
        for (int i = 0; i < k - 1; i++) {
            // 每一次划分都遍历数组寻找最大划分
            set.add(findMaxSplite(a, set));
        }
        return valueSum;
    }

    private static int findMaxSplite(int[] a, Set<Integer> set) {
        for (int i = 0; i < a.length; i++) {

        }
        return -1;
    }

    // 突然想到或许我该递归
    private static int splitArea1(int[] a, int k) {
        int n = a.length;
        return dfs(a, k, 0, n - 1, 0);
    }

    // 返回当前区间的权值的方法
    private static int getValue(int[] a, int left, int right) {
        Set<Integer> set = new HashSet<>();
        int valueCur = 0;
        for (int i = left; i <= right; i++) {
            if (!set.contains(a[i])) {
                set.add(a[i]);
                valueCur += a[i];
            }
        }
        return valueCur;
    }

    /**
     * 尝试递归划分
     * 
     * @param a     原始数组
     * @param k     划分目标区间数
     * @param left  当前区间左下标
     * @param right 当前区间右下标
     * @param cnt   当前划分次数
     * @return
     */
    private static int dfs(int[] a, int k, int left, int right, int cnt) {
        if (cnt == k - 1) {// 已经经过k-1次划分
            // 返回当前区间的权值
            return getValue(a, left, right);
        }
        // 还需要划分
        // 求当前区间的最大划分位置
        // 在重复数序列中找到最大划分
        Map<Integer, Integer> map = new HashMap(); // (k,v)->(a[],index)
        int maxI = 0; // 划分位置
        int maxV = 0;// 当前最大值
        for (int i = left; i <= right; i++) {
            if (map.containsKey(a[i]) && a[i] > maxV) {
                maxI = map.get(a[i]);
                maxV = a[i];
            }
            map.put(a[i], i);
        }

        // 划分左右
        int leftM = dfs(a, k, left, maxI, cnt + 1);
        int rightM = dfs(a, k, maxI + 1, right, cnt + 1);
        return leftM + rightM;
    }

    private static int dfs1(int[] a, int k, int left, int right, int cnt) {
        if (cnt == k - 1) {// 已经经过k-1次划分
            // 返回当前区间的权值
            return getValue(a, left, right);
        }
        // 还需要划分
        // 求当前区间的最大划分位置 // 在重复数序列中找到最大划分
        Map<Integer, Integer> map = new HashMap(); // (k,v)->(a[],index)
        int maxI = 0; // 划分位置
        int maxV = 0;// 当前最大值
        for (int i = left; i <= right; i++) {
            if (map.containsKey(a[i])) {
                maxI = map.get(a[i]);
                int leftM = dfs(a, k, left, maxI, cnt + 1);
                int rightM = dfs(a, k, maxI + 1, right, cnt + 1);
                maxV = Math.max(maxV, leftM + rightM);
            }
            map.put(a[i], i);
        }
        return maxV;
    }

    public static void main(String[] args) {
        // 1
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // sc.nextLine();
        // int[] a = new int[n];
        // for (int i = 0; i < n; i++) {
        // a[i] = sc.nextInt();
        // }
        // System.out.println(mixTime(a));

        // 2
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println(splitArea1(A, k));
    }

}
