package lenove;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static int findMin(int n) {
        // 如果全用1 需要n个1
        // 把n个1分为9个一组
        // 从小到大排序
        // 用栈反转
        // Deque<Integer> stack = new ArrayDeque<>();
        // 大于9
        // 应该可以优化栈的空间开销

        int ans = 0;
        int times = 1;
        while (n >= 9) {
            // 最后一位是9
            ans += times * 9;
            n -= 9;
            times *= 10;
        }
        // 最后小于9的
        ans += times * n;
        // stack.push(n);
        // while (!stack.isEmpty()) {
        // ans *= 10;
        // ans += stack.pop();
        // }
        return ans;
    }

    public static String findMinString(int n) {

        StringBuilder ans = new StringBuilder();
        // long times = 1;
        while (n >= 9) {
            // 最后一位是9
            ans.append(9);
            n -= 9;
        }
        // 最后小于9的
        ans.insert(0, n);

        return ans.toString();
    }

    public static int mostVisit(int[][] toVisit, int n, int m) {
        // 合并区间 比较合并前后的数量差距 求多次合并的最大值
        if (n < 2) {
            return 1;
        }
        // 排序
        Arrays.sort(toVisit, (v1, v2) -> {
            return v1[0] == v2[0] ? v2[1] - v1[1] : v1[0] - v2[0];
        });
        int cnt = 0; // 合并次数
        int max = 0; // 维护最大值
        for (int i = 1; i < n; i++) {
            if (toVisit[i][0] > toVisit[i - 1][1]) {
                // 不需要合并
                cnt = 0;
            } else {
                // 需要合并
                cnt++;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

    public static void main(String[] args) {
        // 1
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(findMin(n));

        // 2
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int m = sc.nextInt();
        // sc.nextLine();
        // int[][] toVisit = new int[n][2];
        // for (int i = 0; i < n; i++) {
        // toVisit[i][0] = sc.nextInt();
        // toVisit[i][1] = sc.nextInt();
        // }
        // System.out.println(mostVisit(toVisit, n, m));
    }
}
