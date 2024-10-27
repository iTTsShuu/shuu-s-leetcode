package pdd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static int maxPerfectLen(String str, int n) {

        // 用来表示以str[i]结尾的子字符串的最大完美长度
        int pre = 1;
        int ans = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                pre = 1;
            } else {
                pre = pre + 1;
            }
            ans = Math.max(ans, pre);
        }

        return ans;
    }

    public static int[] hash(int[] arr, int n, int m) {

        int[] hashArray = new int[m];
        Arrays.fill(hashArray, -1);
        for (int x : arr) {
            int index = x % n;
            while (index < m && hashArray[index] != -1) {
                index++;
            }
            if (index != m) {
                hashArray[index] = x;
            }
        }

        return hashArray;
    }

    public static int payToMost(int[][] candies) {
        int pay = 0;
        // 价格candies[i][0]
        // 数量candies[i][1]
        // 两个堆？？？？ 分别最小价格和最多糖果？
        // 贪心的取最小价格和糖果 当前curC需要大于 大顶堆顶？？max
        // 那其实 大顶堆买一个顶俩 缩小俩距离
        // 小顶价格
        PriorityQueue<int[]> minPriceQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 大顶数量
        PriorityQueue<int[]> maxAmountQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int[] is : candies) {
            minPriceQueue.offer(is);
            maxAmountQueue.offer(is);
        }
        int curC = 0;
        // 比最大数量小
        while (curC <= maxAmountQueue.peek()[1]) {
            // 从最多买性价比更高
            if (maxAmountQueue.peek()[0] <= minPriceQueue.peek()[0] * 2 && maxAmountQueue.peek()[1] > 0) {
                int[] poll = maxAmountQueue.poll();
                poll[1]--;
                pay += poll[0];
                curC++;
                maxAmountQueue.offer(poll);

            }
            // 从最小价格买
            else {
                int[] poll = minPriceQueue.poll();
                poll[1]--;
                pay += poll[0];
                curC++;
                // 最小价格卖完了 就不往回放了
                if (poll[1] != 0) {
                    minPriceQueue.offer(poll);
                }

            }
        }
        return pay;
    }

    public static double winRate(double[][] pairs) {
        double rate = 1.0;
        if (pairs.length == 1) {
            rate = pairs[0][0];
        }
        return rate;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 1
        // int n = in.nextInt();
        // String str = in.nextLine();
        // int maxPerfectLen = Main.maxPerfectLen(str, n);
        // System.out.println(maxPerfectLen);
        // 2
        int n = in.nextInt();
        double[][] pairs = new double[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = in.nextDouble();
            pairs[i][1] = in.nextDouble();
        }
        System.out.printf("%.3f", winRate(pairs));

        // 3
        // int n = in.nextInt();
        // int m = in.nextInt();
        // in.nextLine();
        // int[] arr = new int[n];
        // for (int i = 0; i < n; i++) {
        // arr[i] = in.nextInt();
        // }
        // int[] hash = Main.hash(arr, n, m);

        // for (int x : hash) {
        // System.out.printf("%d ", x);
        // }

        // 4
        // int n = in.nextInt();
        // in.nextLine();
        // int[][] candies = new int[n][2];
        // // 数量candies[i][1]
        // for (int i = 0; i < n; i++) {
        // candies[i][1] = in.nextInt();
        // }
        // in.nextLine();
        // // 价格candies[i][0]
        // for (int i = 0; i < n; i++) {
        // candies[i][0] = in.nextInt();
        // }
        // System.out.println(Main.payToMost(candies));
    }
}