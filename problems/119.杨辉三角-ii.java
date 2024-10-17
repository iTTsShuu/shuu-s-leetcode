/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start

import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[][] anss = new Integer[2][rowIndex + 1];
        anss[0][0] = 1;
        // 滚动数组 做更改
        // shuu: 注意这里是下标rowIndex
        for (int i = 1; i < rowIndex + 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    anss[i % 2][j] = 1;
                } else {
                    anss[i % 2][j] = anss[(i - 1) % 2][j] + anss[(i - 1) % 2][j - 1];
                }
            }
        }
        // 构造答案
        return Arrays.asList(anss[rowIndex % 2]);
    }
}
// @lc code=end
