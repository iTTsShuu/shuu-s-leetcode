/*
 * @lc app=leetcode.cn id=2952 lang=java
 *
 * [2952] 需要添加的硬币的最小数量
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    /**
     * 如果 x≤s，那么合并 [0,s−1] 和 [x,s+x−1] 这两个区间，我们可以得到 [0,s+x−1] 中的所有整数。
     * 如果 x>s，或者遍历完了 coins 数组，这意味着我们无法得到 s，那么就一定要把 s 加到数组中（加一个比 s
     * 还小的数字就没法得到更大的数，不够贪），这样就可以得到了 [s,2s−1] 中的所有整数，再与 [0,s−1] 合并，可以得到 [0,2s−1]
     * 中的所有整数。然后再考虑 x 和 2s 的大小关系，继续分类讨论
     * 
     * @param coins
     * @param target
     * @return
     */
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int ans = 0, s = 1, i = 0;
        while (s <= target) {
            // 动态的更新可取最大值 1~s可取时 1~2s-1可取
            if (i < coins.length && coins[i] <= s) {
                s += coins[i++];
            } else {
                // 单加硬币超出可取需要添加面值为s的硬币
                s *= 2; // 必须添加 s
                ans++;
            }
        }
        return ans;
    }
}

// @lc code=end
