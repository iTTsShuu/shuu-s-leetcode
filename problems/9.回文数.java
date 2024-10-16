/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        Deque<Integer> deque = new ArrayDeque();
        int temp = x;
        while (temp != 0) {
            int yu = temp % 10;
            deque.push(yu);
            temp = temp / 10;
        }
        int n = deque.size();
        int huiwen = 0;
        for (int i = 0; i < n; i++) {
            int pop = deque.pop();
            huiwen += pop * (Math.pow(10, i));
        }
        System.out.println(huiwen);
        return huiwen == x;
    }
}
// @lc code=end

/**
 * 9.回文数
 */
class tretsdsad {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(10));
    }

}