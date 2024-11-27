/*
 * @lc app=leetcode.cn id=3233 lang=java
 *
 * [3233] 统计不是特殊数字的数字数量
 */

// @lc code=start
class Solution {
    private static final int MAX = 31622;
    private static final int[] PI = new int[MAX + 1];// PI为[0,i]的质数个数

    static {
        // 从最小质数2 开始
        for (int i = 2; i <= MAX; i++) {
            if (PI[i] == 0) {// i是质数
                PI[i] = PI[i - 1] + 1;
                // 标记i的所有倍数为合数
                for (int j = i * i; j <= MAX; j += i) {
                    PI[j] = -1;
                }
            } else {
                PI[i] = PI[i - 1];
            }
        }
    }

    public int nonSpecialCount(int l, int r) {
        // 质数的平方 才是特殊数字
        // 等价于区间 [0,r] 内的特殊数字个数，减去区间 [0,l−1] 内的特殊数字个数
        // shuu:灵神的预处理和前缀和
        return r - l + 1 - (PI[(int) Math.sqrt(r)] - PI[(int) Math.sqrt(l - 1)]);
    }
}
// @lc code=end
