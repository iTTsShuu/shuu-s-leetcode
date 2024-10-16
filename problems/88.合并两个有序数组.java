import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // for (int i = 0; i < n; i++) {
        // nums1[m+i]=nums2[i];
        // }
        // Arrays.sort(nums1);
        // 逆向双指针
        int MPlusN = (m + n) - 1;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[MPlusN--] = nums1[i--];
            } else {
                nums1[MPlusN--] = nums2[j--];
            }
        }
        while (i >= 0) {
            nums1[MPlusN--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[MPlusN--] = nums2[j--];
        }
    }
}
// @lc code=end
