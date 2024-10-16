/*
 * @lc app=leetcode.cn id=165 lang=java
 *
 * [165] 比较版本号
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int size1 = v1.length;
        int size2 = v2.length;
        for (int i = 0; i < Math.max(size1, size2); i++) {
            if (i < size1 && i < size2) {
                int t1 = Integer.parseInt(v1[i]), t2 = Integer.parseInt(v2[i]);
                if (t1 < t2) {
                    return -1;
                }
                if (t1 > t2) {
                    return 1;
                }
            }
            if (i >= size1 && i < size2) {
                int t1 = 0, t2 = Integer.parseInt(v2[i]);
                if (t1 < t2) {
                    return -1;
                }
                if (t1 > t2) {
                    return 1;
                }
            }
            if (i < size1 && i >= size2) {
                int t1 = Integer.parseInt(v1[i]), t2 = 0;
                if (t1 < t2) {
                    return -1;
                }
                if (t1 > t2) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
// @lc code=end
