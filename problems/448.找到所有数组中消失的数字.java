/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 原地修改，将遇到过的数 为下标的数做-n处理 变为负数 标记当前数 存在
        int n = nums.length;
        for (int x : nums) {
            // !! 减n不可实现 还是乖乖 加n吧
            // // x 可能已经减过 n 做加n取余处理 取到原来的值
            // int index = (x - 1 + n) % n;
            // // 置为原来的值 - n
            // // 避免nums[index] -= n时 出现多次减导致的负值
            // nums[index] -= n;
            // System.out.println("nums[" + index + "]: " + nums[index]);

            int index = (x - 1) % n;
            nums[index] += n;
        }
        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ansList.add(i + 1);
            }
        }
        return ansList;
    }
}

// @lc code=end
class test448 {
    public static void main(String[] args) {
        Solution448 solution = new Solution448();
        int[] name = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };
        List<Integer> disappearedNumbers = solution.findDisappearedNumbers(name);
        // disappearedNumbers.stream().forEach(a -> {
        // System.out.println(a);
        // });
    }
}