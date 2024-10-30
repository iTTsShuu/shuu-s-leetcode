package jizhi;

import java.util.*;

public class Main {

    public static int findMaxSub(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        // 遍历 dp[i]表示当前数字结尾的子数组的最大和
        // nums[i+1]>0时 dp[i+1]=Max(dp[i]+num[i+1],nums[i+1] )
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
        }
        return max;
    }

    public static String findMaxTail(String s) {
        String[] split = s.split(",");
        // 第一想法是reverse
        List<char[]> listRversed = new ArrayList<>();
        for (String cString : split) {
            listRversed.add(reverse(cString));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listRversed.get(0).length; i++) {
            char ch = listRversed.get(0)[i];
            boolean flag = true;
            for (char[] cs : listRversed) {
                if (cs[i] != ch) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append(ch);
            } else {
                break;
            }
        }
        return sb.length() == 0 ? "jzyx" : sb.reverse().toString();
    }

    //
    static char[] reverse(String s) {
        char[] reversed = s.toCharArray();
        Deque<Character> cDeque = new ArrayDeque<>();
        for (char c : reversed) {
            cDeque.push(c);
        }
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = cDeque.pop();
        }
        return reversed;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 2
        // int n = in.nextInt();
        // in.nextLine();
        // int[] nums = new int[n];
        // for (int i = 0; i < n; i++) {
        // nums[i] = in.nextInt();
        // }
        // System.out.println(findMaxSub(nums));

        // 3
        String s = in.nextLine();
        System.out.println(findMaxTail(s));
    }
}