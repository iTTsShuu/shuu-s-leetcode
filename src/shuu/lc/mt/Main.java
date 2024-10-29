package mt;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int goodNum(int[] nums) {
        // 奇数位数的个数为偶且不等于0
        int ans = 0;
        for (int x : nums) {
            ans += isGood(x) ? 1 : 0;
        }
        return ans;
    }

    private static boolean isGood(int x) {
        // 最小的好数是11
        if (x < 11) {
            return false;
        }
        // 遍历每一位求奇数位个数
        int cnt = 0;
        while (x != 0) {
            int cur = x % 10;
            if (cur % 2 != 0) {
                cnt++;
            }
            x /= 10;
        }
        return cnt % 2 == 0;
    }

    // 2
    public static int maxValue(int n, int m, int[] a, int[] b, int[] c) {
        int[] used = new int[m]; // 标识每个标签是否被用 存储使用的下标
        Arrays.fill(used, -1);
        // dp[i]表示前i个标签的最大值
        // dp[i+1]=MAX(b[i+1],c[i+1]])+dp[i](需满足used[a[i+1]]==-1)
        // used[a[i+1]]!=-1 时 dp[i+1]=dp[i]-b[used[a[i+1]]+c[a[i+1]]+b[i+1]
        int preMax = 0;
        for (int curI = 0; curI < n; curI++) { // curI为当前物品
            int curITag = a[curI]; // 当前需要的标签
            if (used[curITag] == -1) { // 标签没有被使用
                if (b[curI] > c[curI]) { // 使用更大
                    preMax += b[curI];
                    used[curITag] = curI; // 标记使用位置
                } else { // 不使用
                    preMax += c[curI];
                }
            } else { // 标签被使用
                int useTagI = used[curITag]; // 使用tag的物品
                if (c[curI] + b[useTagI] >= b[curI] + c[useTagI]) { // 当前物品不适用 和 当前物品使用前物品不使用比较更大
                    preMax += c[curI];
                } else {
                    // 使用当前更大
                    preMax -= b[useTagI];
                    preMax += c[useTagI];
                    preMax += b[curI];
                    used[curITag] = curI;
                }
            }
        }
        return preMax;
    }

    // 3
    public static int maxCoins(int[] edges, int a[], int x, int y, int[] qUK) {
        int start = qUK[0]; // 开始位置
        int steps = qUK[1]; // 最大移动步数
        // dp[steps] 来表示开始走step步的金币数
        // // x,y>0时 走完step步
        // if (x >= 0 && y >= 0) {
        // int ans = 0;
        // for (int i = 0; i < steps; i++) {
        // ans += a[edges[start]] > a[start] ? x : y;
        // start = edges[start];
        // }
        // return ans;
        // }
        // 维护最大值
        int curCoins = 0;
        int maxCo = 0;
        for (int i = 0; i < steps; i++) {
            curCoins += a[edges[start]] > a[start] ? x : y;
            start = edges[start];
            maxCo = Math.max(maxCo, curCoins);
        }
        return maxCo;
    }

    public static void main(String[] args) {
        // 1
        // Scanner in = new Scanner(System.in);
        // int n = in.nextInt();
        // int[] nums = new int[n];
        // in.nextLine();
        // for (int i = 0; i < n; i++) {
        // nums[i] = in.nextInt();
        // }
        // System.out.println(goodNum(nums));

        // 2
        // Scanner in = new Scanner(System.in);
        // int n = in.nextInt();
        // int m = in.nextInt();

        // int[] a = new int[n];
        // in.nextLine();
        // for (int i = 0; i < n; i++) {
        // a[i] = in.nextInt();
        // }
        // int[] b = new int[n];
        // in.nextLine();
        // for (int i = 0; i < n; i++) {
        // b[i] = in.nextInt();
        // }
        // int[] c = new int[n];
        // in.nextLine();
        // for (int i = 0; i < n; i++) {
        // c[i] = in.nextInt();
        // }
        // System.out.println(maxValue(n, m, a, b, c));

        // 3
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        in.nextLine();
        int[] edges = new int[n];
        for (int i = 0; i < n; i++) {
            edges[i] = in.nextInt();
        }
        int[] a = new int[n];
        in.nextLine();
        for (int i = 0; i < edges.length; i++) {
            a[i] = in.nextInt();
        }
        int[][] qUK = new int[q][2];
        for (int i = 0; i < q; i++) {
            in.nextLine();
            qUK[i][0] = in.nextInt();
            qUK[i][1] = in.nextInt();
            System.out.println(maxCoins(edges, a, x, y, qUK[i]));
        }

    }
}
