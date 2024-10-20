/*
 * @lc app=leetcode.cn id=2233 lang=java
 *
 * [2233] K 次增加后的最大乘积
 */

// @lc code=start
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int maximumProduct(int[] nums, int k) {
        // !!错误的思想!!
        // 等价寻找 n-1个nums中的数 使得这些数的乘积最大
        // int MOD = 1_000_000_007;
        // // 排序取最大的前n-1个数
        // Arrays.sort(nums);
        // int n = nums.length;
        // int ans = 1;
        // for (int i = n - 1; i > 0; --i) {
        // // 0 不可取
        // if (nums[i] != 0) {
        // ans *= nums[i] % MOD;
        // }
        // }
        // ans *= nums[0] + k;
        // return ans % MOD;

        // 做堆化 小顶堆 每次将最小值加1
        int MOD = 1_000_000_007;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int x : nums) {
            queue.offer(x);
        }
        // 每次最小值+1
        while (k != 0) {
            k--;
            queue.offer(queue.poll() + 1);
        }
        // 加完k后 计算乘积
        // 记得用long避免溢出
        long ans = 1;
        while (!queue.isEmpty()) {
            ans = (ans * queue.poll()) % MOD;
        }
        return (int) ans;
    }
}

// @lc code=end
class test2233 {
    public static void main(String[] args) {
        int MOD = 1_000_000_007;
        System.out.println(1885853696 % MOD);
    }
}