/*
 * @lc app=leetcode.cn id=374 lang=java
 *
 * [374] 猜数字大小
 */

// @lc code=start
/**
 * Forward declaration of guess API.
 * 
 * @param num your guess
 * @return -1 if num is higher than the picked number
 *         1 if num is lower than the picked number
 *         otherwise return 0
 *         int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int tmpAns = guess(mid);
            if (tmpAns == 0) {
                return mid;
            } else if (tmpAns == -1) {
                right = mid;
            } else if (tmpAns == 1) {
                left = mid + 1;
            }
        }
        return left;
    }
}
// @lc code=end
