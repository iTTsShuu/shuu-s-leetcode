package shidai;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    void sort(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

    public static String bigIntPlus(String a, String b) {
        char[] reverseA = reverse(a.toCharArray());
        char[] reverseB = reverse(b.toCharArray());
        StringBuilder sb = new StringBuilder();
        // 从末位相加
        int plus = 0;// 记录进位
        int i = 0;
        for (i = 0; i < reverseA.length && i < reverseB.length; i++) {
            // 计算
            int aValue = reverseA[i] - '0';
            int bValue = reverseB[i] - '0';
            plus = aValue + bValue + plus > 9 ? 1 : 0;
            sb.append((aValue + bValue + plus) % 10);
        }
        // 其中一个没有遍历完成
        if (i < reverseA.length) {
            for (int j = i; j < reverseA.length; j++) {
                // 记得加进位
                int tmp = reverseA[i] + plus;
                plus = tmp > 9 ? 1 : 0;
                sb.append(tmp % 10);
            }
        } else if (i < reverseB.length) {
            for (int j = i; j < reverseB.length; j++) {
                // 记得加进位
                int tmp = reverseB[i] + plus;
                plus = tmp > 9 ? 1 : 0;
                sb.append(tmp % 10);
            }
        }
        // 还存在进位时
        if (plus > 0) {
            sb.append(plus);
        }
        return sb.reverse().toString();
    }

    // 翻转字符串
    static char[] reverse(char[] reverse) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < reverse.length; i++) {
            stack.push(reverse[i]);
        }
        for (int i = 0; i < reverse.length; i++) {
            reverse[i] = stack.pop();
        }
        return reverse;
    }

    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        System.out.println(bigIntPlus(a, b));
    }
}
