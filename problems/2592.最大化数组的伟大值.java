/*
 * @lc app=leetcode.cn id=2592 lang=java
 *
 * [2592] 最大化数组的伟大值
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int maximizeGreatness(int[] nums) {
        // shuu:搞那麽多像个小丑，呵呵 一点想法没有 搁哪瞎捷豹操作 不如直接排序来的快
        // Map<Integer, Integer> map = new HashMap<>();
        // // shuu:直接统计数组中每个数的个数
        // for (int x : nums) {
        // map.put(x, map.getOrDefault(x, 0) + 1);
        // }
        // // 按大小进行排序
        // Set<Integer> keySet = map.keySet();
        // Integer[] array = keySet.toArray(new Integer[keySet.size()]);
        // Arrays.sort(array);
        // int n = array.length;
        // if (n < 2) {
        // return 0;
        // }
        // // 计算答案
        // int ans = 0;
        // for (int i = 1; i < n; i++) {
        // Integer after = map.get(array[i]);
        // Integer before = map.get(array[i - 1]);
        // ans += Math.min(after, before);
        // if (after > before) {
        // }
        // }

        // shuu:显得我的代码像傻子 呵呵
        // 排序 求 就 完 了
        Arrays.sort(nums);
        int i = 0;
        for (int x : nums) {
            if (x > nums[i]) {

                i++;
            }
        }
        return i;
        // shuu:

    }
}
// @lc code=end
