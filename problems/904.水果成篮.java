/*
 * @lc app=leetcode.cn id=904 lang=java
 *
 * [904] 水果成篮
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();

        int left = 0, ans = 0;
        for (int right = 0; right < n; ++right) {
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
            while (cnt.size() > 2) {
                cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
                if (cnt.get(fruits[left]) == 0) {
                    cnt.remove(fruits[left]);
                }
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int totalFruit1(int[] fruits) {

        int l = 0, r = 0;
        int max = 0;
        while (l < fruits.length) {
            int count = 0;
            Set<Integer> set = new HashSet<>();
            r = l;
            while (r < fruits.length) {
                int fruit = fruits[r];
                if (!set.contains(fruit) && set.size() < 2) {
                    set.add(fruit);
                    count++;
                } else {
                    // 种类以确定情况下
                    if (set.contains(fruit)) {
                        // 当前水果种类在篮子中
                        count++;
                    } else {
                        // 当前水果种类不在篮子中
                        l = r;
                        break;
                    }
                }
                l++;
                r++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
// @lc code=end

class test904 {
    public static void main(String[] args) {
        int[] fruits = { 1, 2, 1 };
        Solution solution = new Solution();
        System.out.println(solution.totalFruit(fruits));
    }
}