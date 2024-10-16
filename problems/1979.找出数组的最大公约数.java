/*
 * @lc app=leetcode.cn id=1979 lang=java
 *
 * [1979] 找出数组的最大公约数
 */

// @lc code=start
class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int x : nums) {
            min = Math.min(x, min);
            max = Math.max(x, max);
        }
        return gcb(max, min);
    }

    // 求最大公因数的方法
    // 1. 递归
    int gcb1(int a, int b) {
        return a % b == 0 ? b : gcb(b, a % b);
    }

    // 2. 辗转相除模拟迭代
    int gcb(int a, int b) {
        int tmp = a % b;
        while (tmp != 0) {
            a = b;
            b = tmp;
            tmp = a % b;
        }
        return b;
    }
}

// @lc code=end
class test1979 {
    public static int gcb(int a, int b) {
        return a % b == 0 ? b : gcb(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcb(16, 6));
    }
}
