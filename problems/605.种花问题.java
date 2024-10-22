/*
 * @lc app=leetcode.cn id=605 lang=java
 *
 * [605] 种花问题
 */

// @lc code=start
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 一次 遍历 检查每个位置是否可以插花 可插花时n-1 判断n最后是否为负
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && check(flowerbed, i)) {
                flowerbed[i] = 1;
                --n;
            }
        }
        return n <= 0;
    }

    public boolean check(int[] flowerbed, int i) {
        if (i >= 1 && i < flowerbed.length - 1) {
            return flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0;
        } else if (i == 0 && i + 1 <= flowerbed.length - 1) {
            return flowerbed[i + 1] == 0;
        } else if (i == flowerbed.length - 1 && i - 1 >= 0) {
            return flowerbed[i - 1] == 0;
        }
        return true;
    }
}
// @lc code=end
