package yuxin;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String hitOrNot(double h, double r, double x0, double v1, double v2) {
        // 计算距离
        double dis = Math.sqrt(x0 * x0 + h * h);
        double time = dis / v2;

        double disz = time * v1;
        return disz > x0 + r || disz < x0 - r ? "No" : "Yes";
    }

    public static void operationIX(int op, int ii, int x, int[] a) {
        int cnt = 0;
        switch (op) {
            case 1:
                a[ii - 1] = x;
                break;
            case 2:
                for (int i = 0; i < ii; i++) {
                    if (a[i] == x)
                        cnt++;
                }
                System.out.println(cnt);
        }
    }

    public static int minMinus(int[] a) {
        // 顺序无关 先排个序
        Arrays.sort(a);
        // 贪心取当前最小值减到0 因为最小的数减到0至少需要一次操作
        // 可以反证 如果不选最小值做操作减 最后都要多至少一次来操作最小值
        // int cnt = 0; // 操作次数
        // int sumMinus = 0;// 统计累减掉的值

        // (错误的)
        // for (int i = 0; i < a.length; i++) {
        // while (a[i] - sumMinus != 0) {
        // sumMinus += findMin2k(a[i] - sumMinus);
        // cnt++;
        // }
        // }
        // return cnt;

        // 时间不太够了 暴力了 最开始想错了
        int cnt = 0; // 操作次数
        while (a[a.length - 1] != 0) {
            // 应该每次求可删长度和删去值的乘积 取最大进行删
            int maxI = 0; // 最大删除位置
            int maxS = 0;
            for (int i = 0; i < a.length; i++) {
                int curS = findMin2k(a[i]) * (a.length - i);
                if (curS > maxS) {
                    maxI = i;
                    maxS = curS;
                }
            }
            // 找到最大删除位置对之后的数进行删除
            int min2k = findMin2k(a[maxI]);
            for (int i = maxI; i < a.length; i++) {
                a[i] -= min2k;
            }
            cnt++; // 操作数加一
            // 重排序
            Arrays.sort(a);
            // 进行下一次删除
        }

        return cnt;
    }

    // 找最大可减
    private static int findMin2k(int num) {
        int k = 1;
        while (k < num) {
            k *= 2;
        }
        // 注意num是2的幂的情况
        return k > num ? k / 2 : k;
    }

    public static void main(String[] args) {
        // 1
        // Scanner in = new Scanner(System.in);
        // int T = in.nextInt();
        // for (int i = 0; i < T; i++) {
        // int h = in.nextInt();
        // int r = in.nextInt();
        // int x0 = in.nextInt();
        // int v1 = in.nextInt();
        // int v2 = in.nextInt();
        // System.out.println(hitOrNot(h * 1.0, r * 1.0, x0 * 1.0, v1 * 1.0, v2 * 1.0));
        // }

        // 2
        // Scanner in = new Scanner(System.in);
        // int n = in.nextInt();
        // int q = in.nextInt();
        // in.nextLine();
        // int[] a=new int[n];
        // for (int i = 0; i < n; i++) {
        // a[i] = in.nextInt();
        // }
        // for (int i = 0; i < q; i++) {
        // int op = in.nextInt();
        // int ii = in.nextInt();
        // int x = in.nextInt();
        // operationIX(op, ii, x,a);
        // }

        // 3
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] anss = new int[t];
        for (int i = 0; i < t; i++) {
            in.nextLine();
            int n = in.nextInt();
            int[] a = new int[n];
            in.nextLine();
            for (int j = 0; j < n; j++) {
                a[j] = in.nextInt();
            }
            anss[i] = minMinus(a);
        }
        in.nextLine();
        for (int i = 0; i < t; i++) {
            System.out.println(anss[i]);
        }
    }
}
