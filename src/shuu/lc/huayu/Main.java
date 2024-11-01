package huayu;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    private static String tarString(String s) {
        StringBuffer sb = new StringBuffer();
        char[] chs = s.toCharArray();
        int cnt = 1;
        int i = 0;
        for (i = 1; i < chs.length; i++) {
            if (chs[i] == chs[i - 1]) {
                cnt++;
            } else {
                sb.append(chs[i - 1]);
                sb.append(cnt);
                cnt = 1; // 重置计数
            }
        }
        // 最后一串拼接
        sb.append(chs[i - 1]);
        sb.append(cnt);
        return sb.toString();
    }

    private static long calculate(String s) {
        // 简单算式种 运算符下标 为1 3 5 7 9...
        char[] chs = s.toCharArray();
        int index = 2;
        long ans = 0;
        // 除 第一个数以外 两个一组取出串中的数字 存储在栈中 当出现*时 弹出栈顶 计算后再加入栈
        // 两次遍历
        Deque<Long> stack = new ArrayDeque<>();
        stack.push((long) (chs[0] - '0'));
        while (index < chs.length) {
            switch (chs[index - 1]) {
                case '-': {
                    stack.push((long) ('0' - chs[index]));
                    break;
                }
                case '+': {
                    stack.push((long) (chs[index] - '0'));
                    break;
                }
                case '*': {
                    stack.push((chs[index] - '0') * stack.pop());
                    break;
                }
            }
            index += 2;
        }
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.nextLine();
        // 1
        // System.out.println(tarString(s));

        // 2
        System.out.println(calculate(s));
    }

}
