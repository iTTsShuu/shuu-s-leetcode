/*
 * @lc app=leetcode.cn id=1558 lang=java
 *
 * [1558] 得到目标数组的最少函数调用次数
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int minOperations1(int[] nums) {
        // 0不需要操作 数组的顺序无需关心 那可以做排序 参考最小（非零值的）的调用次数
        // 其余值只能通过加一得到
        int n = nums.length;
        Arrays.sort(nums);
        // 跳过零
        int index = 0;
        while (nums[index] == 0) {
            index++;
        }

        int ans = 0;
        ans += n - index + 1;// 非零数至少都得加一
        // 最小非零数 决定乘2次数
        int time2 = nums[index] / 2;
        ans += time2;
        // 此后的数只能通过加一获得

        int pow = (int) Math.pow(2, time2);
        for (int i = index; i < n; i++) {
            ans += nums[i] - pow;
        }

        return ans;
    }

    public int minOperations(int[] nums) {
        // 反向思考加结合二进制
        // 统计所有二进制1的数量为为加一的次数
        // 最大值的二进制位数为除2的次数
        int ans = 0;
        int maxn = 0;
        for (int x : nums) {
            maxn = Math.max(x, maxn);
            // 统计所有数的二进制1的数量
            while (x != 0) {
                if ((x & 1) != 0) {
                    ans++;
                }
                x >>= 1;
            }
        }
        // 特殊情况
        if (maxn == 0) {
            return 0;
        }
        while (maxn != 0) {
            ans++;
            maxn >>= 1;
        }
        return ans - 1;
    }

}
// @lc code=end
