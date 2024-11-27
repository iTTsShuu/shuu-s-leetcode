/*
 * @lc app=leetcode.cn id=869 lang=java
 *
 * [869] 重新排序得到 2 的幂
 */

// @lc code=start

import java.util.HashSet;

class Solution {
    // 方案一回溯全排列判断
    public boolean reorderedPowerOf21(int n) {
        char[] chs = Integer.toString(n).toCharArray();
        boolean[] used = new boolean[chs.length];
        return backTrack(chs, used, 0, 0);
    }

    // 回溯全排列了
    boolean backTrack(char[] chs, boolean[] used, int index, int num) {
        if (index == chs.length) {
            return isPowerOf2(num);
        }
        // 尝试所有未使用的数
        for (int i = 0; i < chs.length; i++) {
            int cur = chs[i] - '0';
            if (!used[i]) {
                // 前置不能为0
                if ((num == 0 && cur == 0) || (i > 0 && !used[i - 1] && chs[i] == chs[i - 1])) { // 同时避免了连续重复字符
                } else {
                    used[i] = true;
                    if (backTrack(chs, used, index + 1, num * 10 + cur)) {
                        return true; // 找到一个就提前终止
                    }
                    used[i] = false;// 复原现场
                }
            }
        }
        return false;
    }

    boolean isPowerOf2(int num) {
        // 位运算快速判断当前值是否是2的幂
        return (num & (num - 1)) == 0;
    }

    // 预处理+哈希表
    public boolean reorderedPowerOf2(int n) {
        // 预处理+hash表
        // 提前将 1<n<10^9 所以 2^29为最大可能性
        // 共有 2^0-2^29 三十个可能 预处理这三十个数的数字组成
        // 提前存一个set 将0-9数字出现的次数处理成字符串储存下来 即可快速判断

        init();
        return this.set.contains(countDigits(n));
    }

    HashSet<String> set = new HashSet<>();

    public void init() {
        for (int i = 0; i < 30; i++) {
            int cur = (int) Math.pow(2, i);
            this.set.add(countDigits(cur));
        }
    }

    public String countDigits(int n) {
        char[] map = new char[10];
        while (n > 0) {
            map[n % 10]++;
            n /= 10;
        }
        return new String(map);
    }
}
// @lc code=end
