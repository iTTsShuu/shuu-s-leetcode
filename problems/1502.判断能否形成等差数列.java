import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1502 lang=java
 *
 * [1502] 判断能否形成等差数列
 */

// @lc code=start
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int dec=arr[1]-arr[0];
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i+1]-arr[i]!=dec) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

